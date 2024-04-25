import java.rmi.Naming;
import java.util.Scanner;
public class SubtractClient {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();
        
        try {
            SubtractServerInterface server = (SubtractServerInterface) Naming.lookup("//localhost/SubtractServer");
            double result = server.subtract(num1,num2);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
