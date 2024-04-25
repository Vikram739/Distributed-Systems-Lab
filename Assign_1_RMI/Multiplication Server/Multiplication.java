import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Multiplication extends Remote {
    int multiply(int a, int b) throws RemoteException;
}
