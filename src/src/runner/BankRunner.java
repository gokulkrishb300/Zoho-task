package runner;

import java.util.HashMap;
import java.util.Map;

import accountdeclare.*;
import cache.APILayer;
import input.InputCenter;
	
public class BankRunner {
	public static void main(String[] args) throws Exception {
		InputCenter input = new InputCenter();
		Account account = new Account();
		Customer customer = new Customer();
		APILayer api = new APILayer();

		boolean condition = true;

		while (condition) {
			System.out.println("1) Login");
			System.out.println("2) Register");
			System.out.println("3) Exit");

			int choice = input.number("Enter here...");

			if (choice == 1) {

				int userId = input.number("Enter user ID ");

				int pwd = input.number("Enter Password ");
				try {
					if (api.loginVerification(userId, pwd)) {
						boolean conditioner = true;
						while (conditioner) {
							System.out.println("1) Create Account");
							System.out.println("2) Show Account Details");
							System.out.println("3) Money Transfer");
							System.out.println("4) Balance Enquiry");
							System.out.println("5) Transaction Details");
							System.out.println("6) Loans");
							System.out.println("7) Deposit");
							System.out.println("8) Withdraw");
							System.out.println("9) LogOut");

							int choose = input.number("Enter process here...");

							if (choose == 1) {
								
								account.setBranchName(input.string("Enter Branch Name"));

								api.addAccount(account);

								System.out.println(account);
							}
							
							if(choose == 2) {
								int accNum = input.number("Enter Account No.");
								
								
							}
							if (choose == 4) {
								int accNum = input.number("Enter Account No.");

								api.balance(account,accNum);

							}
							if (choose == 9) {
								conditioner = false;
								System.out.println("--- Logged Out Success ---");
							}

						}
					}

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}

			if (choice == 2) {

				customer.setName(input.string("Your name"));

				customer.setAddress(input.string("Address"));

				customer.setEmail_ID(input.string("Email-ID"));

				customer.setMobile(input.longVal("mobile number"));

				if (api.customerRegister(customer)) {

					System.out.println("--- Registration Completed ---");

					account.setCustomerId(customer.getCustId());

					account.setBranchName(input.string("Enter bank branch name"));

				    api.addAccount(account);

					System.out.println(account);

					System.out.println("--- Account Created ---");
				} else {
					System.out.println("Customer Register Failed");
				}
			}

			if (choice == 3) {
				condition = false;
				System.out.println("See You Soon..");
			}
			if (choice > 3) {
				System.out.println("Enter the following process only");
			}
		}
	}
}
