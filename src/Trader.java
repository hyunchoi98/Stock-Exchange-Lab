import java.util.LinkedList;
import java.util.Queue;


public class Trader implements Comparable {

	Brokerage brokerage;
	String name, pswd;
	Queue<String> mailbox;	
	TraderWindow myWindow;
	
	//Constructs a new trader, affiliated with a given brokerage, 
	//with a given screen name and password.
	public Trader(Brokerage brokerage, String name, String pswd) {
		this.brokerage = brokerage;
		this.name = name;
		this.pswd = pswd;
		this.mailbox = new LinkedList<String> ();
		
	}
	
	//Returns the screen name for this trader.
	public String getName(){
		return name;
	}
	
	//Returns the password for this trader.
	public String getPassword(){
		return pswd;
	}
	
	//Compares this trader to another by comparing
	//their screen names case blind.
	public int compareTo(Trader other){
		return name.compareToIgnoreCase(other.getName());
	}
	
	//Indicates whether some other trader is "equal to" this one, based 
	//on comparing their screen names case blind. 
	public boolean equals(Object other){
		return name.equalsIgnoreCase(((Trader) other).getName());
	}
	
	//Creates a new TraderWindow for this trader and saves a reference 
	//to it in myWindow. Removes and displays all the messages, if any, 
	//from this trader's mailbox by calling myWindow.show(msg) for each message.
	public void openWindow(){
		myWindow = new TraderWindow(this);
	}
	
	//Returns true if this trader has any messages in its mailbox.
	public boolean hasMessages() {
		return !mailbox.isEmpty();
	}
	
	//Adds msg to this trader's mailbox and displays all messages. 
	//If this trader is logged in (myWindow is not null) removes and 
	//shows all the messages in the mailbox by calling myWindow.showMessage(msg)
	//for each msg in the mailbox.
	public void receiveMessage (String msg) {
		mailbox.add(msg);
		
		if (myWindow != null) {
			for (String str: mailbox) {
				myWindow.showMessage(str);
			}
			while (mailbox.size() >0) {
				mailbox.remove();
			}
		}
		
		/**
		if (myWindow!=null) {
			while(!mailbox.isEmpty()) {
				myWindow.showMessage(mailbox.remove());
			}
		}
		*/
	}
	
	
	//Requests a quote for a given stock symbol from the brokerage by calling 
	//brokerage's getQuote.
	public void getQuote(String symbol) {
		brokerage.getQuote(symbol, this);
	}
	
	//Places a given order with the brokerage by calling brokerage's placeOrder.
	public void placeOrder(TradeOrder order) {
		brokerage.placeOrder(order);
	}
	
	//Logs out this trader. Calls brokerage's logout for this trader. 
	//Sets myWindow to null, called when window closed
	public void quit() {
		brokerage.logout(this);
		myWindow = null;
	}

	@Override
	public int compareTo(Object o) {
		return name.compareTo(((Trader)o).getName());
		
	}
	
	
	
	
}
