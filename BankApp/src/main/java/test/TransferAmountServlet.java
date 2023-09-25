package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/trans")
public class TransferAmountServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		int k = new TransferAmountDAO().transfer(req);
		if(k > 0 ) {
			req.setAttribute("msg", "Transfer amount is success" );
			req.getRequestDispatcher("transactionsuccess.jsp").forward(req, resp);
			
		}else {
			req.setAttribute("msg", " negative amount is not allowed");
			req.getRequestDispatcher("transactionfail.jsp").forward(req, resp);
		}
	
	}

}
