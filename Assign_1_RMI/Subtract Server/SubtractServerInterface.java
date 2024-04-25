import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SubtractServerInterface extends Remote {
    double subtract(double minuend, double subtrahend) throws RemoteException;
}
