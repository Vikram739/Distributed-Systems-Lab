import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class DivisionServer {

    public static void main(String[] args) {
        try {
            DivisionServerImpl server = new DivisionServerImpl();
            LocateRegistry.createRegistry(1099); // default RMI registry port
            Naming.rebind("//localhost/DivisionServer", server);
            System.out.println("Server started...");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
