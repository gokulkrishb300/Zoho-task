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
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		
		int invalidate =Integer.parseInt(request.getParameter("invalidate"));
		
		if (invalidate ==0) 
		{
			session.invalidate();
			
			RequestDispatcher dispatch = request.getRequestDispatcher("login.jsp");
			
			dispatch.forward(request, response);
		}

	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{		
		try {
			
	    HttpSession session = request.getSession();
			
		String userID=request.getParameter("userid");
		
		int id=Integer.parseInt(userID);
		
		String password=request.getParameter("password");
		
		
		BussinessLayer logic=(BussinessLayer) request.getServletContext().getAttribute("api");
		
		User user=logic.getUserDetails(id);
		
		
			
			if(user != null && password.equals(user.getPassword()))
			{
				if(user.getRoleID()==1)
				
				{	
					
					
					session.setAttribute("session", "session");
					
					RequestDispatcher dispatch=request.getRequestDispatcher("accountbase.jsp");
					
					dispatch.forward(request, response);
						
				}
				else {
					
					int customerId = user.getCustomerID();
					
					session.setAttribute("customerId", customerId);
					
					Map<Integer, Account> map = logic.getCustomerAccounts(customerId);
					
					request.setAttribute("AccountMap", map);
					
					RequestDispatcher dispatch = request.getRequestDispatcher("welcomecustomer.jsp");
					
					dispatch.forward(request, response);
				
				    }
			
				
			}
			else {
				request.setAttribute("error", "Enter valid information");
				
				RequestDispatcher dispatch = request.getRequestDispatcher("login.jsp");
				
				dispatch.forward(request, response);
			}
			
		}
	
		catch (ManualException e) 
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
		
	}
	
}
