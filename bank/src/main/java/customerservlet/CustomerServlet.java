package customerservlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import customerinfo.CustomerInfo;
import databaselayer.DataBaseLayer;
import proexception.ProException;


public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<Integer, CustomerInfo> customerMap = new HashMap<>();
		
		DataBaseLayer db = new DataBaseLayer();
	try {
		customerMap = db.readCustomer();
	} catch (ProException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	request.setAttribute("CustomerDetails", customerMap);
	System.out.println(customerMap);
	RequestDispatcher rd = request.getRequestDispatcher("welcomecustomer.jsp");
	rd.forward(request, response);
	
	}
	

}
