package jports.bovespa;

import java.util.Date;

import jports.adapters.DoubleDiv100000000000;
import jports.text.FixedLengthColumn;
import jports.text.FixedLengthTable;

@FixedLengthTable(
		charset = "windows-1252")
public class BovespaProd {

	/**
	 * CÓDIGO DO PAPEL NO SISTEMA ISIN SOB O QUAL FORAM CADASTRADOS PROVENTOS
	 */
	@FixedLengthColumn(
			start = 2,
			end = 14)
	public String isin; // 02 - CODISI - CÓDIGO ISIN BASE - X(12) 03 14

	/**
	 * NÚMERO DE SEQÜÊNCIA DO PAPEL CORRESPONDENTE AO ESTADO DE DIREITO SOB O QUAL
	 * FORAM CADASTRADOS PROVENTOS
	 */
	@FixedLengthColumn(
			start = 14,
			end = 17)
	public int distribuicao; // 03 - DISMES - DISTRIBUIÇÃO BASE N(03) 15 17

	/**
	 * CÓDIGO DE NEGOCIAÇÃO DO PAPEL NA BOVESPA
	 */
	@FixedLengthColumn(
			start = 17,
			end = 29)
	public String ticker; // 04 - CODNEG - X(12) 18 29

	/**
	 * NOME, NO PREGÃO, DA EMPRESA EMITENTE DO PAPEL
	 */
	@FixedLengthColumn(
			start = 29,
			end = 41)
	public String empresa; // 05 - NOMPRE - NOME RESUMIDO DA EMPRESA X(12) 30 41

	/**
	 * ESPECIFICAÇÃO DO PAPEL - PARA PAPÉIS PERTENCENTES AO NOVO MERCADO, NAS
	 * POSIÇÕES 9 E 10 ESTÁ INDICADO: N1, N2 OU NM.
	 */
	@FixedLengthColumn(
			start = 41,
			end = 51)
	public String especificacao; // 06 - ESPECI - X(10) 42 51

	/**
	 * TIPO DE PROVENTO/EVENTO VER TABELA ASSOCIADA PA005
	 */
	@FixedLengthColumn(
			start = 51,
			end = 54)
	public int tipo_provento; // 07 - TIPROV - N(03) 52 54

	/**
	 * DESCRIÇÃO DO TIPO DE PROVENTO/EVENTO
	 */
	@FixedLengthColumn(
			start = 54,
			end = 69)
	public String nome_provento; // 08 - NOMPRO - X(15) 55 69

	/**
	 * DATA DE APROVAÇÃO DO PROVENTO EM ASSEMBLÉIA
	 */
	@FixedLengthColumn(
			start = 69,
			end = 77,
			pattern = "yyyyMMdd")
	public Date data_aprovacao; // 09 - DATAGE - FORMATO AAAAMMDD N(08) 70 77
	/**
	 * VALOR DO PROVENTO (VALOR, PERCENTUAL OU FATOR)
	 */
	@FixedLengthColumn(
			start = 77,
			end = 95,
			adapter = DoubleDiv100000000000.class)
	public double valor_provento; // 10 - VLRPRO - N(07)V(11) 78 95

	/**
	 * FATOR DE GRUPAMENT - ESTA INFORMAÇÃO NÃO ESTÁ SENDO UTILIZADA E O CONTEÚDO É
	 * FIXO 1
	 */
	@FixedLengthColumn(
			start = 95,
			end = 113,
			adapter = DoubleDiv100000000000.class)
	public double fator_grupamento; // 11 - FATGRU - N(07)V(11) 96 113

	/**
	 * CÓDIGO ISIN DESTINO CÓDIGO DO PAPEL NO SISTEMA ISIN SOBRE O QUAL INCIDE O
	 * PROVENTO
	 */
	@FixedLengthColumn(
			start = 113,
			end = 125)
	public String isin_destino; // 12 - ISIPRO - X(12) 114 125

	/**
	 * DISTRIBUIÇÃO DESTINO - NÚMERO DE SEQÜÊNCIA DO PAPEL CORRESPONDENTE AO ESTADO
	 * DE DIREITO SOBRE O QUAL INCIDE O PROVENTO
	 */
	@FixedLengthColumn(
			start = 125,
			end = 128)
	public int distribuicao_destino; // 13 - DISPRO - N(03) 126 128

	/**
	 * CÓDIGO ISIN ORIGEM - CÓDIGO DO PAPEL NO SISTEMA ISIN SOB O QUAL FOI
	 * CADASTRADA UMA SUBSCRIÇÃO ORIGINANDO UM DIREITO (SÓ EXISTIRÁ P/ TIPO DE
	 * PROVENTO =“52”)
	 */
	@FixedLengthColumn(
			start = 128,
			end = 140)
	public String isin_origem; // 14 - ISIORI - X(12) 129 140

	/**
	 * DISTRIBUIÇÃO ORIGEM - NÚMERO DE SEQÜÊNCIA DO PAPEL CORRESPONDENTE AO ESTADO
	 * DE DIREITO SOB O QUAL FOI CADASTRADA UMA SUBSCRIÇÃO ORIGINANDO UM DIREITO (SÓ
	 * EXISTIRÁ P/ TIPO DE PROVENTO =“52”)
	 */
	@FixedLengthColumn(
			start = 140,
			end = 143)
	public int distribuicao_origem; // 15 - DISORI - N(03) 141 143

	/**
	 * CÓDIGO ISIN DE DIREITOS DE SUBSCRIÇÃO - CÓDIGO DE UM DIREITO DE SUBSCRIÇÃO NO
	 * SISTEMA ISIN (SÓ EXISTIRÁ P/ TIPOS DE PROVENTO =“50” OU ”51”)
	 */
	@FixedLengthColumn(
			start = 143,
			end = 155)
	public String isin_subscricao; // 16 - ISIDIR - X(12) 144 155

	/**
	 * DISTRIBUIÇÃO DE DIREITOS DE SUBSCRIÇÃO - NÚMERO DE SEQÜÊNCIA DE UM DIREITO DE
	 * SUBSCRIÇÃO (SÓ EXISTIRÁ P/ TIPOS DE PROVENTOS =“50” OU “51”)
	 */
	@FixedLengthColumn(
			start = 155,
			end = 158)
	public int distribuicao_subscricao; // 17 - DISDIR - N(03) 156 158

	/**
	 * PREÇO DE EMISSÃO DO PAPEL EM SUBSCRIÇÕES
	 */
	@FixedLengthColumn(
			start = 158,
			end = 176,
			adapter = DoubleDiv100000000000.class)
	public double preco_subscricao; // 18 - PRESUB - N(07)V(11) 159 176

	/**
	 * DATA DE PRAZO FINAL P/ SUBSCRIÇÕES NA EMPRESA
	 */
	@FixedLengthColumn(
			start = 176,
			end = 184,
			pattern = "yyyyMMdd")
	public Date limite_subscricao; // 19 - LIMSUB - FORMATO AAAAMMDD N(08) 177 184

	/**
	 * DATA DE PREVISÃO DE PAGAMENTO P/ DIVIDENDOS
	 */
	@FixedLengthColumn(
			start = 184,
			end = 192,
			pattern = "yyyyMMdd")
	public Date data_pagamento; // 20 - DATDIV - FORMATO AAAAMMDD N(08) 185 192

	/**
	 * ANO DO EXERCÍCIO BASE INICIAL P/ DIVIDENDOS
	 */
	@FixedLengthColumn(
			start = 192,
			end = 196)
	public int exercicio_ano_ini; // 21 - INIDIV - FORMATO ‘AAAA’ N(04) 193 196

	/**
	 * ANO DO EXERCÍCIO BASE FINAL P/ DIVIDENDOS
	 */
	@FixedLengthColumn(
			start = 196,
			end = 200)
	public int exercicio_ano_fim; // 22 - FIMDIV - FORMATO ‘AAAA’ N(04) 197 200

	/**
	 * INDICADOR DA FORMA DE PAGAMENTO DOS DIVIDENDOS VER TABELA ASSOCIADA PA014
	 */
	@FixedLengthColumn(
			start = 200,
			end = 201)
	public String forma_pagamento; // 23 - INDDIV - X(01) 201 201

	/**
	 * INDICADOR DO TRATAMENTO DE FRAÇÕES VER TABELA ASSOCIADA PA009
	 */
	@FixedLengthColumn(
			start = 201,
			end = 203)
	public String indicador_fracoes; // 24 - INDFRA - X(02) 202 203

	/**
	 * DESCRIÇÃO DO INDICADOR DO TRATAMENTO DAS FRAÇÕES
	 */
	@FixedLengthColumn(
			start = 203,
			end = 218)
	public String descricao_fracoes; // 25 - NOMFRA - X(15) 204 218

	/**
	 * PREÇO DAS FRAÇÕES
	 */
	@FixedLengthColumn(
			start = 218,
			end = 236,
			adapter = DoubleDiv100000000000.class)
	public double preco_fracoes; // 26 - PREFRA - N(07)V(11) 219 236

	/**
	 * INDICADOR DE CRÉDITO AUTOMÁTICO P/ BONIFICAÇÕES “S” = SIM (CRÉDITO
	 * AUTOMÁTICO); “N” = NÃO (CRÉDITO MANUAL)
	 */
	@FixedLengthColumn(
			start = 236,
			end = 237)
	public boolean credito_automatico; // 27 - INDBON - X(01) 237 237

	/**
	 * INDICADOR DE CORREÇÃO P/ DIVIDENDOS E SUBSCRIÇÕES VER TABELA ASSOCIADA PA006
	 */
	@FixedLengthColumn(
			start = 237,
			end = 240)
	public int indicador_correcao; // 28 - INDCOR - N(03) 238 240

	/**
	 * DESCRIÇÃO DO INDICADOR DE CORREÇÃO P/ DIVIDENDOS E SUBSCRIÇÕES
	 */
	@FixedLengthColumn(
			start = 240,
			end = 255)
	public String descricao_correcao; // 29 - NOMCOR - X(15) 241 255

	/**
	 * PERIODICIDADE DE CORREÇÃO P/ DIVIDENDOS E SUBSCRIÇÕES VER TABELA ASSOCIADA
	 * PA007
	 */
	@FixedLengthColumn(
			start = 255,
			end = 258)
	public int periodicidade_correcao; // 30 - PERCOR - N(03) 256 258

	/**
	 * DESCRIÇÃO DA PERIODICIDADE DE CORREÇÃO P/ DIVIDENDOS E SUBSCRIÇÕES
	 */
	@FixedLengthColumn(
			start = 258,
			end = 273)
	public String periodicidade_correcao_descricao; // 31 - NOMPER - X(15) 259 273

	/**
	 * DATA DE INÍCIO DE CORREÇÃO P/ DIVIDENDOS E SUBSCRIÇÕES
	 */
	@FixedLengthColumn(
			start = 273,
			end = 281,
			pattern = "yyyyMMdd")
	public Date correcao_inicio; // 32 - INICOR - FORMATO AAAAMMDD N(08) 274 281

	/**
	 * DATA DE FIM DE CORREÇÃO P/ DIVIDENDOS E SUBSCRIÇÕES
	 */
	@FixedLengthColumn(
			start = 281,
			end = 289,
			pattern = "yyyyMMdd")
	public Date correcao_fim; // 33-FIMCOR- FORMATO AAAAMMDD N(08)282 289

	/**
	 * NÚMERO DE PARCELAS P/ PAGTO. DE DIVIDENDOS E SUBSCRIÇÕES
	 */
	@FixedLengthColumn(
			start = 289,
			end = 292)
	public int num_parcelas; // 34 - NUMPAR - N(03) 290 292

	/**
	 * PERIODICIDADE P/ PAGAMENTO DE DIVIDENDOS E SUBSCRIÇÕES PARCELADAS VER TABELA
	 * ASSOCIADA PA008
	 */
	@FixedLengthColumn(
			start = 292,
			end = 295)
	public int periodicidade; // 35 - PERPAR - N(03) 293 295

	/**
	 * DESCRIÇÃO DA PERIODICIDADE P/ PAGAMENTO DE DIVIDENDOS E SUBSCRIÇÕES
	 * PARCELADAS
	 */
	@FixedLengthColumn(
			start = 295,
			end = 310)
	public String periodicidade_nome; // 36 - NOMPAR - X(15) 296 310

	/**
	 * % DA PRIMEIRA PARCELA DE UMA SUBSCRIÇÃO PARCELADA
	 */
	@FixedLengthColumn(
			start = 310,
			end = 328,
			adapter = DoubleDiv100000000000.class)
	public double parcela_subscricao; // 37 - PARSUB - N(07)V(11) 311 328

	/**
	 * CÓDIGO DO USUÁRIO ADMINISTRADOR ATUAL
	 */
	@FixedLengthColumn(
			start = 328,
			end = 333)
	public int usuario_adm; // 38 - USUADM - N(05) 329 333

	/**
	 * DATA DE INÍCIO DE PAGAMENTO DOS PROVENTOS OU DE INÍCIO DE NEGOCIAÇÃO “EX”
	 */
	@FixedLengthColumn(
			start = 333,
			end = 341,
			pattern = "yyyyMMdd")
	public Date data_ex; // 39 - INIPRO - FORMATO AAAAMMDD N(08) 334 341

	/**
	 * NÚMERO DE SEQüÊNCIA DE IDENTIFICAÇÃO DOS PROVENTOS PARA ATUALIZAÇÃO
	 */
	@FixedLengthColumn(
			start = 341,
			end = 348)
	public int sequencia; // 40 - NUMSEQ - N(07) 342 348

	/**
	 * SITUAÇÃO DO PROVENTO “I” = INCLUÍDO; “A” = ALTERADO; “E” = EXCLUÍDO ”H” =
	 * HISTÓRICO (SE ARQ. “PROH”); “ “ = EM ATUALIZAÇÃO (SE ARQ.”PROT” OU “PROH”)
	 */
	@FixedLengthColumn(
			start = 348,
			end = 349)
	public String situacao; // 41 - SITUAC - X(01) 349 349

}
