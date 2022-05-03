package accountdeclare;

public class Ticket {

	private int ticket;
	private int noOfPassenger;
	private long time;
	private double amount;
	private String ticketType;
	public int getTicket() {
		return ticket;
	}
	public void setTicket(int ticket) {
		this.ticket = ticket;
	}
	public int getNoOfPassenger() {
		return noOfPassenger;
	}
	public void setNoOfPassenger(int noOfPassenger) {
		this.noOfPassenger = noOfPassenger;
	}
	public long getTime() {
		java.util.Date date = new java.util.Date(time);
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getTicketType() {
		return ticketType;
	}
	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}
	
	java.util.Date date = new java.util.Date(time);
	
	@Override
	public String toString() {
		return "Ticket [ticket=" + ticket + ", noOfPassenger=" + noOfPassenger + ", time=" + date + ", amount=" + amount
				+ ", ticketType=" + ticketType + "]";
	}
	
}
