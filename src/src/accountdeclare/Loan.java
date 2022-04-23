package accountdeclare;

public class Loan {
	private int accountId;
	private long voterId;
	private long aadhar;
	private long pancard;
	private long incomeTax;
	private String loanType;
	private double amount;
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public long getVoterId() {
		return voterId;
	}
	public void setVoterId(long voterId) {
		this.voterId = voterId;
	}
	public long getAadhar() {
		return aadhar;
	}
	public void setAadhar(long aadhar) {
		this.aadhar = aadhar;
	}
	public long getPancard() {
		return pancard;
	}
	public void setPancard(long pancard) {
		this.pancard = pancard;
	}
	public long getIncomeTax() {
		return incomeTax;
	}
	public void setIncomeTax(long incomeTax) {
		this.incomeTax = incomeTax;
	}
	@Override
	public String toString() {
		return "Loan [accountId=" + accountId + ", voterId=" + voterId + ", aadhar=" + aadhar + ", pancard=" + pancard
				+ ", incomeTax=" + incomeTax + ", loanType=" + loanType + ", amount=" + amount + "]";
	}

	
		
}
