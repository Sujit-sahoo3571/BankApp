package test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

public class AccountRegDAO {
	
	int k ; 
	public int register(HttpServletRequest req ) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("insert into bankac55 values(?,?,? )");
			ps.setString(1, req.getParameter("accno"));
			ps.setString(2, req.getParameter("acchold"));
			ps.setDouble(3, Double.parseDouble(req.getParameter("accbal")));
			k  = ps.executeUpdate();
			
		} catch (Exception e) {
		e.printStackTrace();
		
		
		}
		
		return k; 
	}

}
