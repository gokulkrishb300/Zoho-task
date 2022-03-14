package accountdeclare;

import java.io.Serializable;

public class Account implements Serializable
{
	private int accountID;
	private int customerID;
	private String branchName;
	
	private double bankBalance;
	private boolean status=true;
	
	public int getAccountID() {
		return accountID;
	}
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public double getBankBalance() {
		return bankBalance;
	}
	public void setBankBalance(double bankBalance) {
		this.bankBalance = bankBalance;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Account [accountID=" + accountID + ", customerID=" + customerID + ", branchName=" + branchName
				+ ", bankBalance=" + bankBalance + ", status=" + status + "]";
	}
	
	
}
