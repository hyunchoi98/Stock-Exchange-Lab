
public class Trader {

	
	//Constructs a new trader, affiliated with a given brockerage, 
	//with a given screen name and password.
	public Trader(Brokerage brokerage, String name, String pswd)
	{}
	
	//Returns the screen name for this trader.
	public String getName(){}
	
	//Returns the password for this trader.
	public String getPassword(){}
	
	//Compares this trader to another by comparing
	//their screen names case blind.
	public int compareTo(Trader other){}
	
	//Indicates whether some other trader is "equal to" this one, based 
	//on comparing their screen names case blind. 
	public boolean equals(Object other){}
	
	//Creates a new TraderWindow for this trader and saves a reference 
	//to it in myWindow. Removes and displays all the messages, if any, 
	//from this trader's mailbox by calling myWindow.show(msg) for each message.
	public void openWindow(){}
	
	//Returns true if this trader has any messages in its mailbox.
	public boolean hasMessages(){}
	
	//Adds msg to this trader's mailbox and displays all messages. 
	//If this trader is logged in (myWindow is not null) removes and 
	//shows all the messages in the mailbox by calling myWindow.showMessage(msg)
	//for each msg in the mailbox.
	public void receiveMessage (String msg){}
	
	
	//Requests a quote for a given stock symbol from the brokerage by calling 
	//brokerage's getQuote.
	public void getQuote(String symbol){}
	
	//Places a given order with the brokerage by calling brokerage's placeOrder.
	public void placeOrder(TradeOrder order)
	
	//Logs out this trader. Calls brokerage's logout for this trader. 
	//Sets myWindow to null, called when window closed
	public void quit(){}
	
	
	
	
}
