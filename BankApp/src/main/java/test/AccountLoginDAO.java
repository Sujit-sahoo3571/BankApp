package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

public class AccountLoginDAO {

	BankacBean bb =  null; 
	public BankacBean login(HttpServletRequest req) {
		
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement(" select * from bankac55 where accno = ? and acchold = ?");
			ps.setString(1, req.getParameter("accno"));
			ps.setString(2, req.getParameter("acchold"));
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				bb = new BankacBean();
				bb.setAccno(rs.getString(1));
				bb.setAcchold(rs.getString(2));
				bb.setAccbal(rs.getDouble(3));		
				
			}else {
				System.out.print("no record found ");
			}
			
			
		} catch (Exception e) {
		e.printStackTrace();
		}
		
		
		return bb; 
	}
	
	
}
