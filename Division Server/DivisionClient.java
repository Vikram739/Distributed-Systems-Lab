import java.rmi.Naming;
import java.util.Scanner;

public class DivisionClient {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double num1 = sc.nextFloat();
        System.out.print("Enter second number: ");
        double num2 = sc.nextFloat();

        try {
            DivisionServerInterface server = (DivisionServerInterface) Naming.lookup("//localhost/DivisionServer");
            double result = server.divide(num1, num2);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
