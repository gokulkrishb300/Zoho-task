package servletlogin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		PrintWriter pw = response.getWriter();
	
		pw.println(name);
		pw.println(password);
		
		
		if((name.equals("customer")) && (password.equals("customer"))) {
			response.sendRedirect("welcomecustomer.jsp");
		} 
		
		else if((name.equals("admin")) && (password.equals("admin"))) {
			response.sendRedirect("welcomeadmin.jsp");
		}
	}

	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
