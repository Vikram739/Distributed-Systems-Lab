// Step 4: Create the Client
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class AdditionClient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();
        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();

        try {
            Registry registry = LocateRegistry.getRegistry("localhost");
            AdditionService additionService = (AdditionService) registry.lookup("AdditionService");
            int result = additionService.add(num1, num2);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}