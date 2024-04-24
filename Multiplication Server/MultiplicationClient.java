import java.rmi.Naming;
import java.util.Scanner;

public class MultiplicationClient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();
        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();
        
        try {
            Multiplication multiplication = (Multiplication) Naming.lookup("rmi://localhost/MultiplicationService");
            int result = multiplication.multiply(num1, num2);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
