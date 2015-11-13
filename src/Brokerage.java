
public class Brokerage implements login {

	
	//Constructs new brokerage affiliated with a given stock exchange.
	public Brokerage(StockExchange exchange){}
	
	
	//Tries to register a new trader with 
	//a given screen name and password.
	//If succesful creates new trader object and 
	//adds this trader to the map of traders(screen name as key)
	public int addUser(String name, String password){};
	
	//Tries to login a trader with a given screen name and password.
	public int login(String name, String password){}
	
	//Removes a specified trader from the set of logged-in traders.
	public void logout (Trader trader) {
		
	}
	
	//Requests a quote for a given stock from the stock exachange and passes it
	//along to the trader by calling trader's receiveMessage method.
	public void getQuote(String symbol, Trader trader) {
		
	}
	
	//Places an order at the stock exchange.
	public void placeOrder(TradeOrder order) {
		
	}
	
	
	
	
}
