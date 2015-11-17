import java.util.Comparator;


public class PriceComparator implements Comparator {

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
	public int compare(Object order1, Object order2) {
		if (((TradeOrder)order1).isMarket() && ((TradeOrder)order2).isMarket()) {
			return 0;
		}
		else if (((TradeOrder)order1).isMarket() && ((TradeOrder)order2).isLimit()) {
			return -1;
		}
		else if (((TradeOrder)order1).isLimit() && ((TradeOrder)order2).isMarket()) {
			return 1;
		}
		else {
			int diff = (int) ((TradeOrder)order1).getPrice() - (int) ((TradeOrder)order2).getPrice();
			if (ascending)
				return diff;
			else
				return -diff;
			
		}
	
	}

}

