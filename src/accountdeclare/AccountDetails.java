package accountdeclare;

public class AccountDetails {
	private int custId;
	private int accId;
	private long accNum;
	private String accType;
	private String branch;
	private long balance;
	private boolean status;
	
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}

	public int getAccId() {
		return accId;
	}
	public void setAccId(int accId) {
		this.accId = accId;
	}
	public long getAccNum() {
		return accNum;
	}
	public void setAccNum(long accNum) {
		this.accNum = accNum;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "AccountDetails [custId=" + custId + ", accId=" + accId + ", accNum=" + accNum + 
				", accType=" + accType + ", branch=" + branch + ", balance=" + balance+  " ]";
	}
    
	
	
}