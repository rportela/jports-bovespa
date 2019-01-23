import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import jports.bovespa.BovespaDataSource;
import jports.bovespa.BovespaParser;
import jports.bovespa.IsinFile;
import jports.bovespa.IsinFileEmissor;

public class DataQualityTests {

	@Test
	public void testIsinForDuplicateCnpj() throws IOException {

		final IsinFile isin = new BovespaParser().parseIsin(getClass().getResourceAsStream("isinp.zip"));
		final HashMap<Long, List<IsinFileEmissor>> cnpjMap = new HashMap<>();
		isin.getEmissores().stream().forEach(emissor -> {
			if (emissor.cnpj != null && emissor.cnpj > 0) {
				cnpjMap
						.computeIfAbsent(emissor.cnpj, f -> new ArrayList<>())
						.add(emissor);
			}
		});

		StringBuilder log = new StringBuilder(1024);

		cnpjMap.entrySet().stream().filter(e -> e.getValue().size() > 1).forEach(e -> {
			log.append("______________________\r\n");
			log.append("Duplicates of " + e.getKey()).append("\r\n");
			for (IsinFileEmissor emissor : e.getValue()) {
				log.append(emissor.nome + " (" + emissor.codigo + ")").append("\r\n");
			}
		});

		System.out.println(log.toString());
		Files.writeString(Paths.get("testIsinForDuplicateCnpj.txt"), log.toString());
	}

	@Test
	public void testSerieHistoricaDiariaForWrongIsin() throws IOException {
		Date date = new GregorianCalendar(2019, 0, 22).getTime();
		StringBuilder log = new StringBuilder(1024);
		new BovespaDataSource(null)
				.fetchSerieHistorica(date)
				.stream()
				.filter(item -> {
					switch (item.mercado_id) {
					case 70: // OPÇÕES DE COMPRA
					case 80: // OPÇÕES DE VENDA
						String isin = item.isin; // ex: BRAALRACNOR6
						String tipoAtivo = isin.substring(6, 9);
						return "ACN".equals(tipoAtivo) || // ACOES NOMINATIVAS
								"CTF".equals(tipoAtivo) || // COTA FUNDO
								"TRV".equals(tipoAtivo) // TITULOS PERPETUOS DE REMUNERACAO VARIAVEL BASEADA ROYALTIES
						;
					default:
						return false;
					}

				}).forEach(item -> {
					log
							.append(item.ticker)
							.append(" -> ")
							.append(item.isin)
							.append("\r\n");
				});

		System.out.println(log.toString());
		Files.writeString(Paths.get("testSerieHistoricaDiariaForWrongIsin.txt"), log.toString());
	}

}
