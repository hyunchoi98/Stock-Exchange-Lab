import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


//Represents a stock in the SafeTrade project

public class Stock {
	
	private String stockSymbol; 
	private String companyName;
	private double lowestSell;
	private double highestSell;
	private int volumeDay;
	private double stockPrice;
	Queue <TradeOrder> buy;
	Queue <TradeOrder> sell;
	
	
	

	//Constructs a new stock with a given symbol, 
	//company name, and starting price.
	//creates a priority queue to sell and buy orders both with  
	//PriceComparator method
	public Stock(String symbol, String name, double price)
	{
		stockSymbol = symbol;
		companyName = name;
		lowestSell = price;
		highestSell = price;
		stockPrice = price;
		volumeDay = 0;
		buy = new PriorityQueue<TradeOrder>(10, new PriceComparator());
		sell = new PriorityQueue<TradeOrder>(10, new PriceComparator());
	}

	//Returns a quote string for this stock. 
	//includes company name, stock symbol, last sale price
	//lowest and highest day prices, lowest price in a sell order,
	//the number of shares in it, highest price in buy order and num shares
	//in it
	
	public String getQuote() {
		//sample output
		//Giggle.com (GGGL) Price: 12.00 hi: 14.50 lo: 9.00 vol: 
		//500 Ask: none Bid: 12.50 size: 200
		
		String str = companyName + " (" + stockSymbol + ")" + " Price: " + stockPrice +
				"hi" + highestSell + "low" + lowestSell + "vol" + volumeDay +"\n Ask: ";
		
		if (sell.peek()!=null) {
			str += sell.peek().getPrice();
			str += " Size: ";
			str += sell.peek().getShares();
		}
		else {
			str += "None";
		}
		
		str+= " Bid: ";
		if (buy.peek()!=null) {
			str+= buy.peek().getPrice();
			str += " Size: ";
			str += buy.peek().getShares();
		}
		else {
			str += "None";
		}
		
		return str;
		
	}
	
	//Places a trading order, adds order to apporpirate priority 
	//queue depending on if it is a buy or sell. Notifies the trader 
	//that placed the order that it has been placed by sending a message
	public void placeOrder(TradeOrder order) {
		if (order.isSell())
			sell.add(order);
		if (!order.isSell())
			buy.add(order);
		
		Trader trader = order.getTrader();
		trader.receiveMessage("Your order for " + order.getSymbol() +
				"has been placed");
	}
	
}
