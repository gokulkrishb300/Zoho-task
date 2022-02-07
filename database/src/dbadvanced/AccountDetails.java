package dbadvanced;

public class AccountDetails {
	private int custId;
	private int accId;
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
		return accId;
	}
	public void setId(int id) {
		this.accId = id;
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
	
	public int getAccId() {
		return accId;
	}
	public void setAccId(int accId) {
		this.accId = accId;
	}
	
	@Override
	public String toString() {
		return "AccountDetails [custId=" + custId + ", accId=" + accId + ", accNum=" + accNum + ", accName=" + accName
				+ ", branch=" + branch + ", balance=" + balance + "]";
	}
}
