
public class TradeOrder {
	public TradeOrder(Trader trader, String symbol, boolean buyOrder, boolean marketOrder, int numShares, double price) {
		
		
	}
	
	//Returns the price per share for this trade order (used by a limit order).
	public double getPrice() {
		
	}
	
	
	//Returns the number of shares to be traded in this trade order.
	public int getShares() {
		
	}
	
	//Returns the stock symbol for this trade order.
	public String getSymbol() {
		
	}
	
	//Returns the trader for this trade order.
	public Trader getTrader() {
		
	}
	
	//Returns true if this is a buy order; otherwise returns false.
	public boolean isBuy() {
		
	}
	
	//Returns true if this is a limit order; otherwise returns false.
	public boolean isLimit() {
		
	}
	
	//Returns true if this is a market order; otherwise returns false.
	public boolean isMarket() {
		
	}
	
	//Returns true if this is a sell order; otherwise returns false.
	public boolean isSell() {
		
		
	}
	
	//Subtracts a given number of shares from the total number of shares in this trade order.
	public void subtractShares(int shares){
		
	}
	
}
