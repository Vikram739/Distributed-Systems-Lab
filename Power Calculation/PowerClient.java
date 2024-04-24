import java.rmi.Naming;
import java.util.Scanner;

public class PowerClient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        try {
            PowerCalculator calculator = (PowerCalculator) Naming.lookup("//localhost/PowerCalculatorService");
            int result = calculator.calculatePowerOfTwo(number); // Calculate 2^number
            System.out.println("Result from server: " + result);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
