package accountdeclare;

public class Transaction {
	private int fromAcc;
	private int toAcc;
	private double money;
	private String timeAndDate;
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
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getTimeAndDate() {
		return timeAndDate;
	}
	public void setTimeAndDate(String timeAndDate) {
		this.timeAndDate = timeAndDate;
	}
	@Override
	public String toString() {
		return "Transaction [fromAcc=" + fromAcc + ", toAcc=" + toAcc + ", money=" + money + ", timeAndDate="
				+ timeAndDate + "]";
	}
}
