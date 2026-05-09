package ds_3;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.*;
import org.omg.PortableServer.*;

import CalculatorApp.Calculator;
import CalculatorApp.CalculatorHelper;

public class Server{
	public static void main(String[] args) {
		try {
			ORB orb = ORB.init(args, null);
			
			
			POA rootPOA = POAHelper.narrow(
					orb.resolve_initial_references("RootPOA")
			);
			
			rootPOA.the_POAManager().activate();
			
			
			CalculatorImpl obj = new CalculatorImpl(orb);
			
			org.omg.CORBA.Object ref = rootPOA.servant_to_reference(obj);
			
			Calculator  href = CalculatorHelper.narrow(ref);
			
			
			
						
			NamingContextExt ncRef = NamingContextExtHelper.narrow( orb.resolve_initial_references("NameService"));
			
			ncRef.rebind(ncRef.to_name("ABC"), href);
			
			System.out.println("Server is ready and waiting...");
			
			orb.run();
			
		}catch (Exception e) {
			System.out.println(e);
		}
	}
}