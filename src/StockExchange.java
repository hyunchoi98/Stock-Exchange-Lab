import java.util.HashMap;



public class StockExchange {

	HashMap<String, Stock> stocks; 
	
	//Creates new stock exchange object
	//Initializes listed stocks to an empty map (a HashMap).
	public StockExchange() {
		stocks = new HashMap<String, Stock>();
		
		
	}
	
	//Returns a quote for a given stock.
	public String getQuote (String symbol) {
		return stocks.get(symbol).getQuote();
	}
	
	//Adds a new stock with given parameters to the listed stocks.
	public void listStock(String symbol, String name, double price) {
		Stock stock = new Stock (symbol, name, price);
		
		stocks.put(symbol, stock);
		
	}
	
	//Places a trade order by calling stock.placeOrder for 
	//the stock specified by the stock symbol in the trade order.
	public void placeOrder(TradeOrder order) {	
		
	}
	
}
