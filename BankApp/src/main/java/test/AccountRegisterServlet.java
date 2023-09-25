package test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/reg")
public class AccountRegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	PrintWriter pw = resp.getWriter();
	resp.setContentType("text/html");
	int k = new AccountRegDAO().register(req);
	
	if(k>0) {
		
		req.getRequestDispatcher("login.html").forward(req, resp);
	}else {
		pw.print("something went wrong");
	}
	
	
	}
	
}
