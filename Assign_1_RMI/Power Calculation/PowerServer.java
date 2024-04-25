import java.rmi.Naming;

public class PowerServer {
    public static void main(String[] args) {
        try {
            PowerCalculatorImpl server = new PowerCalculatorImpl();
            java.rmi.registry.LocateRegistry.createRegistry(1099);
            java.rmi.Naming.rebind("PowerCalculatorService", server);
            System.out.println("Server is running...");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
