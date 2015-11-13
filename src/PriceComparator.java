
public class PriceComparator {

	//Constructs a price comparator that compares two orders 
	//in ascending order.
	PriceComparator() {}
	
	//Constructs a price comparator that compares two orders
	//in ascending or descending order.
	PriceComparator(boolean asc){}
	
	//0 if both orders are market orders.
	//-1 if order1 is market and order2 is limit.
	//1 if order1 is limit and order2 is market.
	//if both are limit orders, convert to cents and take 
	//the difference
	public int compare(TradeOrder order1,
            TradeOrder order2) {}

}

