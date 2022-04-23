package accountdeclare;

public class Transaction {
	private int accId;

	private int fromAcc;
	private int toAcc;
	private int transferredAmount;
	private int balance;
	private String type;
	private Object timeAndDate;
	
	public int getAccId() {
		return accId;
	}
	public void setAccId(int accId) {
		this.accId = accId;
	}
	public int getFromAcc() {
		return fromAcc;
	}
	public void setFromAcc(int fromAcc) {
		this.fromAcc = fromAcc;
	}
	public int getToAcc() {
		return toAcc;
	}
	public void setToAcc(int toAcc) {
		this.toAcc = toAcc;
	}
	public int getTransferredAmount() {
		return transferredAmount;
	}
	public void setTransferredAmount(int transferredAmount) {
		this.transferredAmount = transferredAmount;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Object getTimeAndDate() {
		return timeAndDate;
	}
	public void setTimeAndDate(Object timeAndDate) {
		this.timeAndDate = timeAndDate;
	}
	@Override
	public String toString() {
		return "Transaction [accId=" + accId + ", fromAcc=" + fromAcc + ", toAcc=" + toAcc + ", transferredAmount="
				+ transferredAmount + ", balance=" + balance + ", type=" + type + ", timeAndDate=" + timeAndDate + "]";
	}

}
