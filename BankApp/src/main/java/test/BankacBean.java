package test;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BankacBean implements Serializable{
	
	private String accno, acchold;
	private double accbal;
	
	public BankacBean() {}
	
	public String getAccno() {
		return accno;
	}
	public void setAccno(String accno) {
		this.accno = accno;
	}
	public String getAcchold() {
		return acchold;
	}
	public void setAcchold(String acchold) {
		this.acchold = acchold;
	}
	public double getAccbal() {
		return accbal;
	}
	public void setAccbal(double accbal) {
		this.accbal = accbal;
	}

	@Override
	public String toString() {
		return "BankacBean [accno=" + accno + ", acchold=" + acchold + ", accbal=" + accbal + "]";
	}
	
	
	
	
	
	

}
