package servlet;

import java.io.IOException;
import java.io.PrintWriter;
//import java.util.ArrayList;
//import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import accountdeclare.Account;
import accountdeclare.User;
import logic.BussinessLayer;
import manualexception.ManualException;


/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
		
		PrintWriter out = response.getWriter();
		
		String userID=request.getParameter("userid");
		
		int id=Integer.parseInt(userID);
		
		String password=request.getParameter("password");
		
		BussinessLayer logic=(BussinessLayer) request.getServletContext().getAttribute("api");
		
		User user=null;
		
		try 
		{
			user=logic.getUserDetails(id);
		
			int customerId=user.getCustomerID();
			System.out.println(customerId);
			
			request.setAttribute("customerId",customerId);
			
			
			if(password.equals(user.getPassword()))
			{
				if(user.getRoleID()==1)
				
				{	
					RequestDispatcher dispatch=request.getRequestDispatcher("accountbase.jsp");
					
					dispatch.forward(request, response);
						
				}
				else if(user.getRoleID()==2) {
					
                    RequestDispatcher dispatch=request.getRequestDispatcher("welcomecustomer.jsp");
					
					dispatch.forward(request, response);
				
				}
			
				
			}
			else {
			      out.println("Neither Customer nor Admin");
			}
			
		}
		catch (ManualException e) 
		{
			
			e.printStackTrace();
		}
		
	}
	
}
