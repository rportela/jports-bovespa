package jports.bovespa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BovespaPosicoesEmAbertoParser {

	public List<BovespaPosicoesEmAberto> parse(InputStream is) throws IOException,
			ParseException {

		ArrayList<BovespaPosicoesEmAberto> list = new ArrayList<>(100);
		BufferedReader reader = new BufferedReader(new InputStreamReader(is, Charset.forName("windows-1252")));
		String line;
		Date data_pregao = null;
		Date data_arquivo = null;

		while ((line = reader.readLine()) != null) {
			String[] cells = line.split("\\|");
			int lineType = Integer.parseInt(cells[0]);
			switch (lineType) {
			case 1:
				data_pregao = new SimpleDateFormat("yyyyMMdd").parse(cells[1]);
				data_arquivo = new SimpleDateFormat("yyyyMMddHH:mm:ss").parse(cells[2] + cells[3]);
				break;
			case 2:
				BovespaPosicoesEmAberto item = new BovespaPosicoesEmAberto();
				item.data_arquivo = data_arquivo;
				item.data_pregao = data_pregao;
				item.ticker = cells[1];
				item.nome = cells[2];
				item.tipo_ativo = cells[3];
				item.isin = cells[4];
				item.num_acoes = Long.parseLong(cells[5]);
				item.preco_medio = Double.parseDouble(cells[6]);
				item.temp = cells[7];
				item.volume = Double.parseDouble(cells[8]);
				list.add(item);
				break;
			default:
				throw new RuntimeException("Unknown record type " + lineType + " for SI_D_DBTCPARF.txt");
			}
		}
		return list;
	}

}
