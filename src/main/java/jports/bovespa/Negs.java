package jports.bovespa;

import java.sql.Time;
import java.util.Date;

import jports.text.CsvColumn;
import jports.text.CsvTable;

@CsvTable(
		separator = ";",
		linePrefix = "2",
		capacity = 100000)
public class Negs {

	// Session date
	@CsvColumn(
			pattern = "yyyy-MM-dd")
	public Date session_date;

	// Instrument identifier
	@CsvColumn
	public String instrument_symbol;

	// Trade number
	@CsvColumn
	public Long trade_number;

	// Trade price
	@CsvColumn
	public Double trade_price;

	// Traded quantity
	@CsvColumn
	public Long traded_quantity;

	// Trade time (format HH:MM:SS.NNNNNN)
	@CsvColumn(
			pattern = "HH:mm:ss.SSS")
	public Time trade_time;

	// Trade indicator: 1 - Trade / 2 - Trade cancelled
	@CsvColumn
	public Long trade_indicator;

	// Buy order date
	@CsvColumn
	public Date buy_order_date;

	// Sequential buy order number
	@CsvColumn
	public Long sequential_buy_order_number;

	// Secondary Order ID - Buy Order.
	@CsvColumn
	public Long secondary_order_id_buy_order;

	// 0 - Neutral (Order was not executed) / 1 - Aggressor / 2 - Passive
	@CsvColumn
	public Long aggressor_buy_order_indicator;

	// Sell order sell date
	@CsvColumn(
			pattern = "yyyy-MM-dd")
	public Date sell_order_date;

	// Sequential sell order number
	@CsvColumn
	public Long sequential_sell_order_number;

	// Secondary Order ID - Buy Order.
	@CsvColumn
	public Long secondary_order_id_sell_order;

	// 0 - Neutral (Order was not executed) / 1 - Aggressor / 2 - Passive
	@CsvColumn
	public Long aggressor_sell_order_indicator;

	// Define if the cross trade was intentional: 1 - Intentional / 0 - Not
	// Intentional
	@CsvColumn
	public Long cross_trade_indicator;

	// Entering Firm (Buy Side) - Available from March/2014
	@CsvColumn
	public Long buy_member;

	// Entering Firm (Sell Side) - Available from March/2014
	@CsvColumn
	public Long sell_member;

}
