package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		HttpSession session=request.getSession();
		if(session.getAttribute("session")==null)
	    {
	    	RequestDispatcher dispatch = request.getRequestDispatcher("login.jsp");
			
			dispatch.forward(request, response);
	    }
	    String customerId=request.getParameter("customerID");
	    
		
		int accountID = Integer.parseInt(request.getParameter("accountID"));
		
		System.out.println("AccountID: " + accountID);

		String branch= request.getParameter("branch");
		
		double balance = Double.parseDouble(request.getParameter("balance"));
		
        BussinessLayer logic=(BussinessLayer) request.getServletContext().getAttribute("api");
		
		Account account = new Account();
		
		if(accountID==0) {
			
			   if(customerId.equals(" ")) {
			    	
			    	request.setAttribute("error", "CustomerID can't be empty");
					
					RequestDispatcher dispatch = request.getRequestDispatcher("addaccount.jsp?accountID=0");
					
					dispatch.forward(request, response);
			   }
			    
			   int customerID = Integer.parseInt(customerId);   
		account.setCustomerID(customerID);
		
		account.setBranchName(branch);
		
		account.setBankBalance(balance);
			   
		try {
			logic.putAccountDetails(account);
		} catch (ManualException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("accountbase.jsp");
		
		dispatcher.forward(request, response);
	
				
	} else {
		
		   if(customerId.equals(" ")) {
		    	
		    	request.setAttribute("error", "CustomerID can't be empty");
				
				RequestDispatcher dispatch = request.getRequestDispatcher("addaccount.jsp?accountID=<%=account.getAccountID()%>&customerID=<%=account.getCustomerID()%>&branch=<%=account.getBranchName()%>&bal=<%=account.getBankBalance()%>");
				
				dispatch.forward(request, response);
				
		    }
		   int customerID = Integer.parseInt(customerId);
		account.setAccountID(accountID);
	
		account.setCustomerID(customerID);
		
		account.setBranchName(branch);
		
		account.setBankBalance(balance);
		
		try {
			logic.updateAccountDetails(account);
			} catch (ManualException e) 
		{
				RequestDispatcher dispatch = request.getRequestDispatcher("error.jsp");
				
				dispatch.forward(request, response);
				
				e.printStackTrace();
			}
			catch (Exception e) 
			{
				RequestDispatcher dispatch = request.getRequestDispatcher("error.jsp");
				
				dispatch.forward(request, response);
				
				e.printStackTrace();
			}	
	RequestDispatcher dispatcher = request.getRequestDispatcher("accountbase.jsp");
		
		dispatcher.forward(request, response);
	
	}

}
	
}
