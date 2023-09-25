package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession hs = req.getSession(false);
		if(hs == null ) {
			req.setAttribute("msg", "Session Expired ");
			req.getRequestDispatcher("home.jsp").forward(req, resp);
		
		}else {
			ServletContext sct = req.getServletContext();
			sct.removeAttribute("bacbean");
			hs.invalidate();
			req.setAttribute("msg", "Logout Successfully");
			req.getRequestDispatcher("home.jsp").forward(req, resp);
		}
	
	}

}
