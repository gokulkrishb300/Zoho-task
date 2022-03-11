package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

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
import cache.CacheLayer;
import logic.DBLogic;
import manualexception.ManualException;


public class TransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public TransferServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

    public void init(ServletConfig config)
    {
    	try
    	{
    		BussinessLayer logic=new BussinessLayer(true);
    		
    		DBLogic db = new DBLogic();
    		
    		config.getServletContext().setAttribute("api", logic);
    		
    		config.getServletContext().setAttribute("api1", db);
    		
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		
		try {
			
		int value=Integer.parseInt(request.getParameter("value"));
		
		String senderID=request.getParameter("from");
		
		int fromID=Integer.parseInt(senderID);
		
	 
		
		String receiverID=request.getParameter("to");
	
		int toID = Integer.parseInt(receiverID);
		

		
		String transfer = request.getParameter("amount");
		
		double amount = Double.parseDouble(transfer);
		
		BussinessLayer bus=(BussinessLayer) request.getServletContext().getAttribute("api");
		
		DBLogic db = (DBLogic) request.getServletContext().getAttribute("api1");
	
		
			
			if(value==1) 
			{
				 System.out.println(bus.withdraw(db.getCustomerId(fromID), fromID, amount));
					
					System.out.println(bus.deposit(db.getCustomerId(toID), toID, amount));
		
					RequestDispatcher dispatch=request.getRequestDispatcher("accountbase.jsp");
					
					dispatch.forward(request, response);
			
			}
			
			else if(value==0) {
				
              bus.withdraw(db.getCustomerId(fromID), fromID, amount);
				
				bus.deposit(db.getCustomerId(toID), toID, amount);
				
				HttpSession session = request.getSession();
				
				Map<Integer, Account> map = bus.getCustomerAccounts((int)session.getAttribute("customerId"));
				
				request.setAttribute("AccountMap", map);
				
				RequestDispatcher dispatch=request.getRequestDispatcher("welcomecustomer.jsp");
				
				dispatch.forward(request, response);
				
			}

		
			
		} catch (ManualException e) {
			// TODO Auto-generated catch block
			RequestDispatcher dispatch = request.getRequestDispatcher("error.jsp");
			
			dispatch.forward(request, response);
			
			e.printStackTrace();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			RequestDispatcher dispatch = request.getRequestDispatcher("error.jsp");
			
			dispatch.forward(request, response);
			
			e.printStackTrace();
		}
		
		
		
		
	
	}
}


