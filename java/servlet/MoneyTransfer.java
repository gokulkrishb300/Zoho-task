package servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import accountdeclare.Account;
import logic.BussinessLayer;
import manualexception.ManualException;

/**
 * Servlet implementation class TransferMoney
 */
@WebServlet("/TransferMoney")
public class MoneyTransfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoneyTransfer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			String condition=request.getParameter("data");
			System.out.println(condition);
			if(condition.equals("admin"))
			{
				RequestDispatcher dispatch=request.getRequestDispatcher("adminhomepage.jsp");
				dispatch.forward(request, response);
			}
			else
			{
				BussinessLayer logic=(BussinessLayer) request.getServletContext().getAttribute("api");
				HttpSession session=request.getSession();
				int customerId=(int) session.getAttribute("customerId");
				Map <Integer,Account> map=logic.getCustomerAccounts(customerId);
				request.setAttribute("AccountMap",map);
				RequestDispatcher dispatch=request.getRequestDispatcher("userhomepage.jsp");
				dispatch.forward(request, response);
			}
		}
		catch(ManualException e)
		{
			e.printStackTrace();
		}
	}

}
