package servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import accountdeclare.Customer;
import logic.BussinessLayer;
import manualexception.ManualException;

/**
 * Servlet implementation class AddCustomer
 */
@WebServlet("/AddCustomer")
public class AddCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public AddCustomer() {
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
		
		BussinessLayer logic=(BussinessLayer) request.getServletContext().getAttribute("api");
		
		int customerID = Integer.parseInt(request.getParameter("customerID"));
		
		System.out.println("CustomerID: "+customerID);
		
		if(customerID==0) {
		
		String name = request.getParameter("name");
		
		String address = request.getParameter("address");
		
		long mobile = Long.parseLong(request.getParameter("mobile"));
		
		Customer customer = new Customer();
		
		customer.setCustomerName(name);
		
		customer.setAddress(address);
		
		customer.setMobile(mobile);
	
		try {
			logic.putCustomerDetails(customer);
		} catch (ManualException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("customerbase.jsp");
	}
		
		else {
			
			String name = request.getParameter("name");
			
			String address = request.getParameter("address");
			
			long mobile = Long.parseLong(request.getParameter("mobile"));
			
			Customer customer = new Customer();
			
			customer.setCustomerId(customerID);
			
			customer.setCustomerName(name);
			
			customer.setAddress(address);
			
			customer.setMobile(mobile);
		
			try {
				logic.updateCustomerDetails(customer);
			} catch (ManualException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			response.sendRedirect("customerbase.jsp");
			
		}
	}
	

}
