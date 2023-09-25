package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/selection")
public class SelectionServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String button_name = req.getParameter("select");
		if(button_name.equals("deposit")) {
			req.getRequestDispatcher("deposit.html").forward(req, resp);
			
		}else {
			//transfer
			req.getRequestDispatcher("transfer.html").forward(req, resp);
		}
		
		
	}

}
