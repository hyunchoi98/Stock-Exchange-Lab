
public class TradeOrder {
	
	Trader trader;
	String symbol;
	boolean buyOrder, marketOrder;
	int numShares;
	double price;
	
	
	public TradeOrder(Trader trader, String symbol, boolean buyOrder,
			boolean marketOrder, int numShares, double price) {
		this.trader = trader;
		this.symbol = symbol;
		this.buyOrder = buyOrder;
		this.marketOrder = marketOrder;
		this.numShares = numShares;
		this.price = price;
		
	}
	
	//Returns the price per share for this trade order (used by a limit order).
	public double getPrice() {
		return price;
	}
	
	
	//Returns the number of shares to be traded in this trade order.
	public int getShares() {
		return numShares;
	}
	
	//Returns the stock symbol for this trade order.
	public String getSymbol() {
		return symbol;
	}
	
	//Return s the trader for this trade order.
	public Trader getTrader() {
		return trader;
	}
	
	//Returns true if this is a buy order; otherwise returns false.
	public boolean isBuy() {
		return buyOrder;
	}
	
	//Returns true if this is a limit order; otherwise returns false.
	public boolean isLimit() {
		return !marketOrder;
	}
	
	//Returns true if this is a market order; otherwise returns false.
	public boolean isMarket() {
		return marketOrder;
	}
	
	//Returns true if this is a sell order; otherwise returns false.
	public boolean isSell() {
		return !buyOrder;
		
	}
	
	//Subtracts a given number of shares from the total number of shares in this trade order.
	public void subtractShares(int shares){
		numShares -= shares;
	}
	
}
