
public class PriceComparator {

	private boolean ascending;
	
	//Constructs a price comparator that compares two orders 
	//in ascending order.
	public PriceComparator() {
		ascending = true;
	}
	
	//Constructs a price comparator that compares two orders
	//in ascending or descending order.
	public PriceComparator (boolean asc) {
		ascending = asc;
	}
	
	//0 if both orders are market orders.
	//-1 if order1 is market and order2 is limit.
	//1 if order1 is limit and order2 is market.
	//if both are limit orders, convert to cents and take 
	//the difference
	public int compare(TradeOrder order1, TradeOrder order2) {
		if (order1.isMarket() && order2.isMarket()) {
			return 0;
		}
		else if (order1.isMarket() && order2.isLimit()) {
			return -1;
		}
		else if (order1.isLimit() && order2.isMarket()) {
			return 1;
		}
		else {
			int diff = (int) order1.getPrice() - (int) order2.getPrice();
			if (ascending)
				return diff;
			else
				return -diff;
			
		}
	
	}

}

