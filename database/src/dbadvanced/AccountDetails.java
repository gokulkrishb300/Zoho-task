package dbadvanced;

public class AccountDetails {
	private int id;
	private long accNum;
	private String accName;
	private String branch;
	private long balance;
	
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getAccNum() {
		return accNum;
	}
	public void setAccNum(long accNum) {
		this.accNum = accNum;
	}
	public String getAccName() {
		return accName;
	}
	public void setAccName(String accName) {
		this.accName = accName;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	@Override
	public String toString() {
		return "AccountDetails [id=" + id + ", accNum=" + accNum + ", accName=" + accName + ", branch=" + branch
				+ ", balance=" + balance + "]";
	}
}
