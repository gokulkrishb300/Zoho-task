package runner;



import accountdeclare.*;
import cache.APILayer;
import input.InputCenter;

public class BankRunner {

	private static void initial() {
		System.out.println();
		System.out.println("1) Login");
		System.out.println("2) Register");
		System.out.println("3) Exit");
		System.out.println();
	}

	private static void intermediate() {
		System.out.println();
		System.out.println("1) Want to create another account ?");
		System.out.println("2) Show Account Details");
		System.out.println("3) Money Transfer");
		System.out.println("4) Balance Enquiry");
		System.out.println("5) Transaction Details");
		System.out.println("6) Loans");
		System.out.println("7) Deposit");
		System.out.println("8) Withdraw");
		System.out.println("9) Entire Account Details");
		System.out.println("10) LogOut");
		System.out.println();
	}
	
	private static void finale() {
		
		System.out.println();
		System.out.println("1) Personal loan");
		System.out.println("2) Home loan");
		System.out.println("3) Car loan");
		System.out.println("4) Two wheeler loan");
		System.out.println("5) Education loan");
		System.out.println("6) Student loan");
		System.out.println("7) Gold loan");
		System.out.println("8) Applied loans");
		System.out.println("9) Go Back");
		System.out.println();
	}

	public static void main(String[] args) throws Exception {
		
		InputCenter input = new InputCenter();
		
		Customer customer = new Customer();

		APILayer api = new APILayer();

		boolean condition = true;

		while (condition) {
			
			initial();     
	    
			int choice = input.number("Enter here...");

			if (choice == 1) {

				int accountId = input.number("Enter account ID ");

				int pwd = input.number("Enter Password ");
					
				try {
				 api.loginVerification(accountId, pwd);
			
						
						boolean conditioner = true;
						
						while (conditioner) {
							
							Account account = new Account();
							
							intermediate();

							int choose = input.number("Enter process here...");

							if (choose == 1) {

								account.setCustomerId(customer.getCustId());
								
								account.setAccType(input.string("Enter Account Type"));

								account.setBranchName(input.string("Enter Branch Name"));
								
								try {

								api.addAccount(account);
								
								System.out.println(account);
								
								} catch (Exception e) {
									System.out.println(e.getMessage());
								}

								
							}

							if (choose == 2) {
								int accNum = input.number("Enter Account No.");

								try {
								api.accountDetails(accNum);
								} catch (Exception e) {
									System.out.println(e.getMessage());
								}

							}
							
							if(choose == 3) {
								
								
								int toAcc = input.number("Enter to AccountId");
								
								double amount = input.doubleVal("Enter amount");
								
								try {
								api.transfer(accountId, toAcc, amount);
								
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
								
							}
							
							if (choose == 4) {
                                  try {
								api.balance(accountId);
								
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}

							}
							
							if(choose == 5 ) {
								
								Transaction transaction = new Transaction();
								
								long millis   = System.currentTimeMillis();
								
							    java.util.Date date = new java.util.Date(millis); 
							    
							    transaction.setTimeAndDate(date);
							    
							}
							
							if(choose == 6) {
								
								boolean conditioning = true;
								
								while(conditioning) {
									
									finale();
									
									int wish = input.number("Enter your wish");
									
									if(wish == 1) {
										
										Loan loan = new Loan();
										
										loan.setAccountId(accountId);
										
										loan.setAadhar(input.longVal("Enter aadhar number"));
										
										loan.setIncomeTax(input.longVal("Enter incomeTax Id"));
										
										loan.setPancard(input.longVal("Enter PanCard"));
										
										loan.setVoterId(input.longVal("Enter voterId"));
										
										loan.setAmount(input.doubleVal("Enter amount"));
										
										loan.setLoanType("Personal Loan");
										
										try {
										api.loan(loan);
										} catch(Exception e) {
											System.out.println(e.getMessage());
										}
									}
									
									if(wish == 2) {
										
										Loan loan = new Loan();
										
										loan.setAccountId(accountId);
										
										loan.setAadhar(input.longVal("Enter aadhar number"));
										
										loan.setIncomeTax(input.longVal("Enter incomeTax Id"));
										
										loan.setPancard(input.longVal("Enter PanCard"));
										
										loan.setVoterId(input.longVal("Enter voterId"));
										
										loan.setAmount(input.doubleVal("Enter amount"));
										
										loan.setLoanType("Home Loan");
										
										try {
										api.loan(loan);
										} catch(Exception e) {
											System.out.println(e.getMessage());
										}
									}
									
									if(wish == 3) {
										
										Loan loan = new Loan();
										
										loan.setAccountId(accountId);
										
										loan.setAadhar(input.longVal("Enter aadhar number"));
										
										loan.setIncomeTax(input.longVal("Enter incomeTax Id"));
										
										loan.setPancard(input.longVal("Enter PanCard"));
										
										loan.setVoterId(input.longVal("Enter voterId"));
										
										loan.setAmount(input.doubleVal("Enter amount"));
										
										loan.setLoanType("Car Loan");
										
										try {
										api.loan(loan);
										} catch(Exception e) {
											System.out.println(e.getMessage());
										}

									}
									
									if(wish == 4) {
										
										Loan loan = new Loan();
										
										loan.setAccountId(accountId);
										
										loan.setAadhar(input.longVal("Enter aadhar number"));
										
										loan.setIncomeTax(input.longVal("Enter incomeTax Id"));
										
										loan.setPancard(input.longVal("Enter PanCard"));
										
										loan.setVoterId(input.longVal("Enter voterId"));
										
										loan.setAmount(input.doubleVal("Enter amount"));
										
										loan.setLoanType("Two Wheeler Loan");
										
										try {
										api.loan(loan);
										} catch(Exception e) {
											System.out.println(e.getMessage());
										}

									}
									
									if(wish == 5) {
										
										Loan loan = new Loan();
										
										loan.setAccountId(accountId);
										
										loan.setAadhar(input.longVal("Enter aadhar number"));
										
										loan.setIncomeTax(input.longVal("Enter incomeTax Id"));
										
										loan.setPancard(input.longVal("Enter PanCard"));
										
										loan.setVoterId(input.longVal("Enter voterId"));
										
										loan.setAmount(input.doubleVal("Enter amount"));
										
										loan.setLoanType("Education Loan");
										
										try {
										api.loan(loan);
										} catch(Exception e) {
											System.out.println(e.getMessage());
										}

									}
									
									if(wish == 6) {
										Loan loan = new Loan();
										
										loan.setAccountId(accountId);
										
										loan.setAadhar(input.longVal("Enter aadhar number"));
										
										loan.setIncomeTax(input.longVal("Enter incomeTax Id"));
										
										loan.setPancard(input.longVal("Enter PanCard"));
										
										loan.setVoterId(input.longVal("Enter voterId"));
										
										loan.setAmount(input.doubleVal("Enter amount"));
										
										loan.setLoanType("Student Loan");
										
										try {
										api.loan(loan);
										} catch(Exception e) {
											System.out.println(e.getMessage());
										}

									}
									
									if(wish == 7) {
										
										Loan loan = new Loan();
										
										loan.setAccountId(accountId);
										
										loan.setAadhar(input.longVal("Enter aadhar number"));
										
										loan.setIncomeTax(input.longVal("Enter incomeTax Id"));
										
										loan.setPancard(input.longVal("Enter PanCard"));
										
										loan.setVoterId(input.longVal("Enter voterId"));
										
										loan.setAmount(input.doubleVal("Enter amount"));
										
										loan.setLoanType("Gold Loan");
										
										try {
										api.loan(loan);
										} catch(Exception e) {
											System.out.println(e.getMessage());
										}

									}
									
									if(wish == 8) {
										
										try {
											api.appliedLoan();
										} 
										catch(Exception e) {
											System.out.println(e.getMessage());
										}
									}
									
									if(wish == 9) {
										
										conditioning = false;
										
										System.out.println("-- Returned to main menu --");
									}
									
								}
								
							}
							
							if(choose == 7) {
					
								double amount = input.doubleVal("Enter deposit amount");
					
								try {
								api.deposit(accountId, amount);
								}
								catch (Exception e) {
									System.out.println(e.getMessage());
								}
								
							}
							
							if(choose == 8) {
								double amount = input.doubleVal("Enter Withdraw amount");
								
								try {
									api.withDraw(accountId, amount);
								}
								catch(Exception e) {
									System.out.println(e.getMessage());
								}
							}
							
							if(choose == 9) {
								
								
								int customerId = customer.getCustId();
								try {
									api.entireAccountDetails(customerId);
								} 
								catch(Exception e) {
									System.out.println(e.getMessage());
								}
								
							}
							if (choose == 10) {
								
								conditioner = false;
								
								System.out.println("--- Logged Out Success ---");
							}

						}
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}

			if (choice == 2) {
				
				Account account = new Account();
				
				customer.setName(input.string("Your name"));

				customer.setAddress(input.string("Address"));

				customer.setEmail_ID(input.string("Email-ID"));

				customer.setMobile(input.longVal("Mobile Number"));
				
				account.setAccType(input.string("Account Type"));

				account.setBranchName(input.string("Enter bank branch name"));
				
				try {
				api.register(customer,account);
				
				System.out.println(account);
				}
				
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
				
			}

			if (choice == 3) {
				
				condition = false;
				
				System.out.println("--- Have a nice day ---");
			}
			if (choice > 3 || choice < 0) {
				
				System.out.println("-- Enter the following process only --");
			}
		}
	}
}
