
//Represents a stock in the SafeTrade project

public class Stock {
	
//Constructs a new stock with a given symbol, 
//company name, and starting price.
//creates a priority queue to sell and buy orders both with  
//PriceComparator method
public Stock(String symbol, String name, double price)
{}

//Returns a quote string for this stock. 
//includes company name, stock symbol, last sale price
//lowest and highest day prices, lowest price in a sell order,
//the number of shares in it, highest price in buy order and num shares
//in it
public String getQuote()
{
	//sample output
	
	String x ="Giggle.com (GGGL) Price: 12.00 hi: 14.50 lo: 9.00 "
			+ "vol: 500 Ask: none Bid: 12.50 size: 200";
	
	return x; 	
}

//Places a trading order, adds order to apporpirate priority 
//queue depending on if it is a buy or sell. Notifies the trader 
//that placed the order that it has been placed by sending a message
public void placeOrder(TradeOrder order)
{}

}
