// Step 3: Create the Server
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class AdditionServer {
    public static void main(String[] args) {
        try {
            AdditionService additionService = new AdditionServiceImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("AdditionService", additionService);
            System.out.println("Server is running...");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
