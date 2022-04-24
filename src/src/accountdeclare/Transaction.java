package accountdeclare;

public class Transaction {
	private int transId;
	private int accId;
	private int toAcc;
	private double transferredAmount;
	private double balance;
	private String type;
	private boolean status;
	private Object timeAndDate;
	private String result;
	public int getTransId() {
		return transId;
	}
	public void setTransId(int transId) {
		this.transId = transId;
	}
	public int getAccId() {
		return accId;
	}
	public void setAccId(int accId) {
		this.accId = accId;
	}
	public int getToAcc() {
		return toAcc;
	}
	public void setToAcc(int toAcc) {
		this.toAcc = toAcc;
	}
	public double getTransferredAmount() {
		return transferredAmount;
	}
	public void setTransferredAmount(double transferredAmount) {
		this.transferredAmount = transferredAmount;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Object getTimeAndDate() {
		return timeAndDate;
	}
	public void setTimeAndDate(Object timeAndDate) {
		this.timeAndDate = timeAndDate;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "Transaction [transId=" + transId + ", accId=" + accId + ", toAcc=" + toAcc + ", transferAmount="
				+ transferredAmount + ", balance=" + balance + ", type=" + type + ", status=" + status
				+ ", timeAndDate=" + timeAndDate + ", result=" + result + "]";
	}


}
