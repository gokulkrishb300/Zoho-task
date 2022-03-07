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
		
		String senderID=request.getParameter("from");
		
		int fromID=Integer.parseInt(senderID);
		
	
		
		String receiverID=request.getParameter("to");
	
		int toID = Integer.parseInt(receiverID);
		
		
		
		String transfer = request.getParameter("amount");
		
		double amount = Double.parseDouble(transfer);
		
	
		
		BussinessLayer bus=(BussinessLayer) request.getServletContext().getAttribute("api");
		
		DBLogic db = (DBLogic) request.getServletContext().getAttribute("api1");
	
		try {
			bus.withdraw(db.getCustomerId(fromID), fromID, amount);
			
			bus.deposit(db.getCustomerId(toID), toID, amount);

		
			
		} catch (ManualException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatch=request.getRequestDispatcher("accountbase.jsp");
		
		dispatch.forward(request, response);
		
		
		
	
	}
}


