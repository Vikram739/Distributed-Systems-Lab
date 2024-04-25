import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DivisionServerInterface extends Remote {
    double divide(double dividend, double divisor) throws RemoteException;
}
