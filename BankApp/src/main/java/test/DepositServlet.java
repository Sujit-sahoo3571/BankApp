package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/depo")
public class DepositServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		
		
		if(Double.parseDouble(req.getParameter("bal")) > 0.0) {
			int k = new DepositDAO().deposit(req);
			req.setAttribute("msg", "Deposit Successfull " );
			req.getRequestDispatcher("transactionsuccess.jsp").forward(req, resp);
			
		}else {
			req.setAttribute("msg","-ve amount for deposit is not allowed ");
			req.getRequestDispatcher("transactionfail.jsp").forward(req, resp);
			
		}
		
		
	}

}
