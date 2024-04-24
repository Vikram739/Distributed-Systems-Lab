import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class SubtractServerImpl extends UnicastRemoteObject implements SubtractServerInterface {

    protected SubtractServerImpl() throws RemoteException {
        super();
    }

    @Override
    public double subtract(double minuend, double subtrahend) throws RemoteException {
        return minuend - subtrahend;
    }
}
