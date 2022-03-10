package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		PrintWriter out = response.getWriter();
		
		System.out.println(request.getParameter("value"));
		
		int value=Integer.parseInt(request.getParameter("value"));
		
		String senderID=request.getParameter("from");
		
		int fromID=Integer.parseInt(senderID);
		
	    System.out.println(fromID);
		
		String receiverID=request.getParameter("to");
	
		int toID = Integer.parseInt(receiverID);
		
		System.out.println(toID);
		
		String transfer = request.getParameter("amount");
		
		double amount = Double.parseDouble(transfer);
		
	    System.out.println(amount);
		
		BussinessLayer bus=(BussinessLayer) request.getServletContext().getAttribute("api");
		
		DBLogic db = (DBLogic) request.getServletContext().getAttribute("api1");
	
		try {
			System.out.println(bus.withdraw(db.getCustomerId(fromID), fromID, amount));
			
			System.out.println(bus.deposit(db.getCustomerId(toID), toID, amount));

		
			
		} catch (ManualException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(value==1) 
		{
	        response.sendRedirect("accountbase.jsp");
		
		
		}
		else if(value==0) {
			response.sendRedirect("welcomecustomer.jsp");
			
			RequestDispatcher req=request.getRequestDispatcher(transfer);
		}
		else {
			
			out.print("Invalid Transaction");
		}
		
		
	
	}
}


