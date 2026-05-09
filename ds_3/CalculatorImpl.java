package ds_3;


import org.omg.CORBA.ORB;
import CalculatorApp.CalculatorPOA;


public class CalculatorImpl extends CalculatorPOA{
	private ORB orb;
	
	public CalculatorImpl(ORB orb) {
		this.orb = orb;
	}
	
	public double add(double x, double y) {
		return x+y;
	}
	
	public double subtract(double x, double y) {
		return x-y;
	}
	
	public double multiply(double x, double y) {
		return x*y;
	}
	
	public double divide(double x, double y) {
		return x/y;
	}
	
	
	public void shutdown() {
		orb.shutdown(false);
	}
	
	
}