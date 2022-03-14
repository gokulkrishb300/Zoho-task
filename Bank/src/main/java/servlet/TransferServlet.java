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
		
		HttpSession session=request.getSession();
		if(session.getAttribute("session")==null)
	    {
	    	RequestDispatcher dispatch = request.getRequestDispatcher("login.jsp");
			
			dispatch.forward(request, response);
	    }
		
		
		
		try {
			
		int value=Integer.parseInt(request.getParameter("value"));
		
		String senderID=request.getParameter("from");
		
		String receiverID=request.getParameter("to");
		
		
		

		
		String transfer = request.getParameter("amount");
		
		double amount = Double.parseDouble(transfer);
		
		BussinessLayer bus=(BussinessLayer) request.getServletContext().getAttribute("api");
		
		DBLogic db = (DBLogic) request.getServletContext().getAttribute("api1");
	
		
			
			if(value==1) 
			{
				
		        if(senderID.startsWith("S") ||  receiverID.startsWith("R")) {
					
					request.setAttribute("error", "From & To can't be string");
					
					RequestDispatcher dispatch = request.getRequestDispatcher("transfer.jsp?refsan=0");
					
					dispatch.forward(request, response);
				}
				
				
				int fromID=Integer.parseInt(senderID);
				
				int toID = Integer.parseInt(receiverID);
				
				if(fromID!=toID) {
				 System.out.println(bus.withdraw(db.getCustomerId(fromID), fromID, amount));
					
					System.out.println(bus.deposit(db.getCustomerId(toID), toID, amount));
		
					RequestDispatcher dispatch=request.getRequestDispatcher("accountbase.jsp");
					
					dispatch.forward(request, response);
				} else {
					request.setAttribute("error", "From & To Can't be same");
					
					RequestDispatcher dispatch = request.getRequestDispatcher("transfer.jsp?refsan=0");
					
					dispatch.forward(request, response);
				}
			
			}
			
			else if(value==0) {
				

		        if(senderID.startsWith("S") ||  receiverID.startsWith("R")) {
					
					request.setAttribute("error", "From & To can't be string");
					
					RequestDispatcher dispatch = request.getRequestDispatcher("transfer.jsp?refsan=1");
					
					dispatch.forward(request, response);
				}
				
                int fromID=Integer.parseInt(senderID);
				
				int toID = Integer.parseInt(receiverID);
				
				if(fromID!=toID) {
				
              bus.withdraw(db.getCustomerId(fromID), fromID, amount);
				
				bus.deposit(db.getCustomerId(toID), toID, amount);
				
				Map<Integer, Account> map = bus.getCustomerAccounts((int)session.getAttribute("customerId"));
				
				request.setAttribute("AccountMap", map);
				
				RequestDispatcher dispatch=request.getRequestDispatcher("welcomecustomer.jsp");
				
				dispatch.forward(request, response);
				}
				else {
					request.setAttribute("error", "From & To Can't be same");
					
					RequestDispatcher dispatch = request.getRequestDispatcher("transfer.jsp?refsan=1");
					
					dispatch.forward(request, response);
				}
				
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


