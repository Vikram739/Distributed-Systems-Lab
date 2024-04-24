import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class SubtractServer {

    public static void main(String[] args) {
        try {
            SubtractServerImpl server = new SubtractServerImpl();
            LocateRegistry.createRegistry(1099); // default RMI registry port
            Naming.rebind("//localhost/SubtractServer", server);
            System.out.println("Server started...");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
