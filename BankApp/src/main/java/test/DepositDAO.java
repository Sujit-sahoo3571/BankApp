package test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

public class DepositDAO {

	int k ; 
	public int deposit(HttpServletRequest req ) {
		
		try {
			double amount  = Double.parseDouble(req.getParameter("bal"));
			
			if(amount > 0) {
				
				Connection con = DBConnection.getCon();
				PreparedStatement ps = con.prepareStatement(" update bankac55 set accbal = accbal+ ? where accno = ?");
				ServletContext sct = req.getServletContext();
				BankacBean bb = (BankacBean) sct.getAttribute("bacbean");
				ps.setString(1, req.getParameter("bal"));
				ps.setString(2, bb.getAccno());
				System.out.println(bb);
				System.out.println(req.getParameter("bacbean"));
				k   = ps.executeUpdate();
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return k; 
	}
	
}
