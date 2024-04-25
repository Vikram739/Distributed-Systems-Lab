import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PowerCalculator extends Remote {
    int calculatePowerOfTwo(int number) throws RemoteException;
}
