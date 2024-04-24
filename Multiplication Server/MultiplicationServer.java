import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class MultiplicationServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            MultiplicationImpl multiplication = new MultiplicationImpl();
            Naming.rebind("rmi://localhost/MultiplicationService", multiplication);
            System.out.println("Server is running...");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
