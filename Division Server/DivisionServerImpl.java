import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class DivisionServerImpl extends UnicastRemoteObject implements DivisionServerInterface {

    protected DivisionServerImpl() throws RemoteException {
        super();
    }

    @Override
    public double divide(double dividend, double divisor) throws RemoteException {
        if (divisor == 0) {
            throw new RemoteException("Division by zero!");
        }
        return dividend / divisor;
    }
}
