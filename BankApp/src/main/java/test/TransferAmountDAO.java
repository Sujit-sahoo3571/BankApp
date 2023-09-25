package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

public class TransferAmountDAO {
	
	int k ; 
	public int transfer(HttpServletRequest req) {
		
		try {
			
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("insert into banktr55 values(?, ?, ?, ? )");
			PreparedStatement ps2 = con.prepareStatement("update bankac55 set accbal = accbal-? where accno = ? ");
			
			ServletContext sct = req.getServletContext();
			BankacBean bb = (BankacBean) sct.getAttribute("bacbean");
			System.out.print(bb);
			double amount = Double.parseDouble(req.getParameter("amount")); 
			if(bb.getAccbal() >= amount ) {
				
				ps.setString(1,bb.getAccno() );
				ps.setString(2, req.getParameter("tacno"));
				ps.setDouble(3, amount);
				ps.setDate(4, new Date(System.currentTimeMillis()) );
				
				k = ps.executeUpdate();
				if(k > 0) {
					ps2.setDouble(1, amount);
					ps2.setString(2, bb.getAccno());
					k = ps2.executeUpdate();
				}	
				
			}
			
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		return k; 
	}

}
