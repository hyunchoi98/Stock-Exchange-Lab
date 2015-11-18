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
	Queue<TradeOrder> buy;
	Queue<TradeOrder> sell;

	// Constructs a new stock with a given symbol,
	// company name, and starting price.
	// creates a priority queue to sell and buy orders both with
	// PriceComparator method
	public Stock(String symbol, String name, double price) {
		stockSymbol = symbol;
		companyName = name;
		lowestSell = price;
		highestSell = price;
		stockPrice = price;
		volumeDay = 0;
		buy = new PriorityQueue<TradeOrder>(10, new PriceComparator(false)); //largest prices first
		sell = new PriorityQueue<TradeOrder>(10, new PriceComparator(false));
	}

	// Returns a quote string for this stock.
	// includes company name, stock symbol, last sale price
	// lowest and highest day prices, lowest price in a sell order,
	// the number of shares in it, highest price in buy order and num shares
	// in it

	public String getQuote() {
		// sample output
		// Giggle.com (GGGL) Price: 12.00 hi: 14.50 lo: 9.00 vol:
		// 500 Ask: none Bid: 12.50 size: 200
		
		
		
		String str = companyName + " (" + stockSymbol + ")" + " Price: "
				+ stockPrice + "\nhi: " + highestSell + " low: " + lowestSell
				+ " vol: " + volumeDay + "\nAsk: "   ;

		if (sell.peek() != null) {
			str += sell.peek().getPrice();
			str += " Size: ";
			str += sell.peek().getShares();
		} else {
			str += "None ";
		}

		str += " Bid: ";
		if (buy.peek() != null) {
			str += buy.peek().getPrice();
			str += " Size: ";
			str += buy.peek().getShares();
		} else {
			str += "None";
		}

		return str;

	}

	// Places a trading order, adds order to apporpirate priority
	// queue depending on if it is a buy or sell. Notifies the trader
	// that placed the order that it has been placed by sending a message
	public void placeOrder(TradeOrder order) {
		if (order.isSell())
		{
			sell.add(order);
		

		Trader trader = order.getTrader();
		trader.receiveMessage("Your order to sell " + order.getShares() + ""
				+ " shares of " +   order.getSymbol()
				+ " has been placed");
		}
		if (order.isBuy())
		{
			buy.add(order);
			Trader trader = order.getTrader();
			trader.receiveMessage("Your order to buy " + order.getShares() + ""
					+ " shares of " +   order.getSymbol()
					+ " has been placed");
		}
		/**
		 * if (order.isSell()) if (buy.size() > 0) executeOrder(order); if
		 * (order.isBuy()) if (sell.size() > 0) executeOrder(order);
		 */
		executeOrders();

	}

	private void executeOrders() {
		if (sell.isEmpty() || buy.isEmpty()) 
			return;
		
		outerloop:
		while (!sell.isEmpty()) {
			System.out.println("FIRST WHILE");
			double sellPrice = 0;
			boolean finishedSell = false;;
			
			if (sell.peek().isMarket()) {
				sellPrice = lowestSell;
			}    			
			else {
				sellPrice = sell.peek().getPrice();
			}
			
			
			
			while (!buy.isEmpty()) {
				System.out.println("SECOND WHILE");
				double buyPrice = 0;
				
				if (buy.peek().isMarket()) {
					buyPrice = highestSell;
				}
				else {
					buyPrice = buy.peek().getPrice();
				}
				
				if (sellPrice <= buyPrice) {
					System.out.println("buy price >= sellprice");
					System.out.println(sell.peek());
					int numSells = sell.peek().getShares();
					int numBuys = buy.peek().getShares();
					
					if (numBuys > numSells) {
						System.out.println("More buys");
						buy.peek().subtractShares(numSells);
						volumeDay += numSells;
						finishedSell = true;
						tradeMsg(buy.peek(), numSells, buy.peek().getSymbol(), buyPrice);
						tradeMsg(sell.peek(), numSells, buy.peek().getSymbol(), buyPrice);
						
						//messages
					}
					else if (numBuys < numSells) {
						System.out.println("More sells");
						sell.peek().subtractShares(numBuys);
						volumeDay += numBuys;
						
						
						tradeMsg(buy.peek(), numBuys, buy.peek().getSymbol(), buyPrice);
						tradeMsg(sell.peek(), numBuys, buy.peek().getSymbol(), buyPrice);
						buy.remove();
						//message
					}
					else {
						System.out.println("SAME NUM");
						volumeDay += numBuys;
						finishedSell = true;
						
						tradeMsg(buy.peek(), numSells, buy.peek().getSymbol(), buyPrice);
						tradeMsg(sell.peek(), numSells, buy.peek().getSymbol(), buyPrice);
						buy.remove();
						//message
					}
					if (finishedSell) {
						sell.remove();
					}
					
					
				}
				else { //no cheap enough sell order
					break outerloop;
				}
				
				
				
			}
			
			//need to remove
		}
		
		
		
		
		
		/**
		int shares = order.getShares();
		System.out.println(shares);
		if (order.isSell()) {
			for (TradeOrder price : buy) {
				if (order.getPrice() <= price.getPrice()) {

					TradeOrder toSell = buy.remove();

					toSell.subtractShares(shares);

					if (toSell.getShares() > 0)
						buy.add(toSell);

					Trader seller = order.getTrader();
					seller.receiveMessage("You sold " + shares + " shares of "
							+ stockSymbol + " for " + order.getPrice()
							+ "$ a share");

					Trader buyer = price.getTrader();
					buyer.receiveMessage("You bought " + shares + " shares of "
							+ stockSymbol + " for " + order.getPrice()
							+ "$ a share");
				}
			}
		}
		if (order.isBuy()){
			for (TradeOrder price : sell) {
				if (order.getPrice() <= price.getPrice()) {
					TradeOrder toBuy = sell.remove();

					toBuy.subtractShares(shares);

					if (toBuy.getShares() > 0)
						sell.add(toBuy);

					Trader buyer = order.getTrader();
					buyer.receiveMessage("You bought " + shares
							+ " shares of " + stockSymbol);

					Trader seller = price.getTrader();
					seller.receiveMessage("You sold " + shares
							+ " shares of " + stockSymbol + " for "
							+ order.getPrice() + "$ a share");
				}

			}
		}
		*/

		
	}
	
	private void tradeMsg (TradeOrder order, int shares, String symbol, double price) {
		String str = "";
		
		if (order.isSell())
			str += "You sold ";
		else 
			str += "You bought ";
			
		str += shares + " shares of " + symbol + " at $" + price + " - amt: " + (price * shares);
		
		order.getTrader().receiveMessage(str);
		
		
	}
	
}
