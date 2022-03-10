package servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import accountdeclare.Account;
import logic.BussinessLayer;
import manualexception.ManualException;

@WebServlet("/Adate")
public class Adate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Adate() {
        super();
        // TODO Auto-generated constructor stub
    }


    public void init(ServletConfig config)
    {
    	try
    	{
    		BussinessLayer logic=new BussinessLayer(true);
    		
    		config.getServletContext().setAttribute("api", logic);
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int customerID = Integer.parseInt(request.getParameter("customerID"));
		
		int accountID = Integer.parseInt(request.getParameter("accountID"));
		
		System.out.println("AccountID: " + accountID);

		String branch= request.getParameter("branch");
		
		double balance = Double.parseDouble(request.getParameter("balance"));
		
        BussinessLayer logic=(BussinessLayer) request.getServletContext().getAttribute("api");
		
		Account account = new Account();
		
		if(accountID==0) {
		
		account.setCustomerID(customerID);
		
		account.setBranchName(branch);
		
		account.setBankBalance(balance);
		
		try {
			logic.putAccountDetails(account);
		} catch (ManualException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("accountbase.jsp");
				
	} else {
		
		account.setAccountID(accountID);
	
		account.setCustomerID(customerID);
		
		account.setBranchName(branch);
		
		account.setBankBalance(balance);
		
		try {
			logic.updateAccountDetails(account);
			} catch (ManualException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("accountbase.jsp");
	}

}
	
}
