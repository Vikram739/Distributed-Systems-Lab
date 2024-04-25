import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class PowerCalculatorImpl extends UnicastRemoteObject implements PowerCalculator {
    protected PowerCalculatorImpl() throws RemoteException {
        super();
    }

    @Override
    public int calculatePowerOfTwo(int number) throws RemoteException {
        return (int) Math.pow(2, number);
    }
}
