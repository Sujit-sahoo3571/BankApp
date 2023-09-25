package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


@SuppressWarnings("serial")
@WebServlet("/login")
public class AccounLogInServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw =resp.getWriter();
		resp.setContentType("text/html");
		
		HttpSession hs = req.getSession();
		if(hs == null ) {
			req.setAttribute("msg", "Session Expired ");
			req.getRequestDispatcher("home.jsp").forward(req, resp);
			
		}else {
			
			
			ServletContext sct = req.getServletContext();
			
			
			BankacBean bb = new AccountLoginDAO().login(req);
			if(bb == null ) {
				pw.print("Invalid Login Credential ");
			}else {
				req.setAttribute("msg", "Login success!");
				req.setAttribute("bacbean", bb);
				sct.setAttribute("bacbean", bb);
				req.getRequestDispatcher("loginsuccess.jsp").forward(req, resp);
				
			}
		
		}
		
	}

}
