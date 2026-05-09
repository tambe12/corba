package ds_3;


import java.util.Scanner;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.*;


import CalculatorApp.Calculator;
import CalculatorApp.CalculatorHelper;

public class Client{
	public static void main(String[] args) {
		
		try {
		
		ORB orb = ORB.init(args, null);
		
		NamingContextExt ncRef = NamingContextExtHelper.narrow(
				orb.resolve_initial_references("NameService"));
		
		Calculator calculator = CalculatorHelper.narrow(
				ncRef.resolve_str("ABC")
				);
		Scanner sc = new Scanner(System.in);

        System.out.println("===== CORBA Calculator =====");

        while (true) {
            System.out.println("\n1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            if (choice == 5) break;

            System.out.print("Enter first number: ");
            double x = sc.nextDouble();

            System.out.print("Enter second number: ");
            double y = sc.nextDouble();

            switch (choice) {
                case 1:
                    System.out.println("Result = " + calculator.add(x, y));
                    break;
                case 2:
                    System.out.println("Result = " + calculator.subtract(x, y));
                    break;
                case 3:
                    System.out.println("Result = " + calculator.multiply(x, y));
                    break;
                case 4:
                    System.out.println("Result = " + calculator.divide(x, y));
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }

        sc.close();
		}catch(Exception e) {
			System.out.println(e);
		}

		
	}
}


// this assignemnt requires the java version 8 to run. 
//steps to run this code
// store Calculatoe.idl inside the src
// run command idlj -fall Calculator.idl
// this will create new .java filese which will be getting used in the project

// now again inside the src, run command : tnameserv -ORBInitialPort 1050
// then run server and client as :
// java Server -ORBInitialPort 1050
// java client --ORBInitialPort 1-50

