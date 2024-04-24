// Step 1: Define the Remote Interface
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AdditionService extends Remote {
    int add(int a, int b) throws RemoteException;
}
