import java.util.TreeMap;


public class Brokerage implements Login {

	StockExchange exchange;
	TreeMap<String, String> traders;
	TreeMap<String, String> loggedIn;
	
	
	//Constructs new brokerage affiliated with a given stock exchange.
	public Brokerage(StockExchange exchange){
		this.exchange = exchange;
		traders = new TreeMap<String, String>();
		loggedIn = new TreeMap<String, String>();
	}
	
	
	//Tries to register a new trader with 
	//a given screen name and password.
	//If succesful creates new trader object and 
	//adds this trader to the map of traders(screen name as key)
	public int addUser(String name, String password){
		if (name.length()<4 || name.length()>10) {
			return -1;
		}
		else if (password.length()<2 || password.length()>10) {
			return -2;
		}
		else if (!traders.containsKey(name)){
			return -3;
		}
		else {
			traders.put(name, password);
			return 0;
		}
		
		
	};
	
	//Tries to login a trader with a given screen name and password.
	public int login(String name, String password){
		if (!traders.containsKey(name)) {
			return -1;
		}
		else if(traders.get(name).equals(password)) {
			return -2;
		}
		else if (loggedIn.containsKey(name)) {
			return -3;
		}
		else {
			loggedIn.put(name, password);
			return 0;
		}
	}
	
	//Removes a specified trader from the set of logged-in traders.
	public void logout (Trader trader) {
		loggedIn.remove(trader.getName());
	}
	
	//Requests a quote for a given stock from the stock exachange and passes it
	//along to the trader by calling trader's receiveMessage method.
	public void getQuote(String symbol, Trader trader) {
		trader.receiveMessage(exchange.getQuote(symbol));
		
		
	}
	
	//Places an order at the stock exchange.
	public void placeOrder(TradeOrder order) {
		exchange.placeOrder(order);
	}
	
	
	
	
}
