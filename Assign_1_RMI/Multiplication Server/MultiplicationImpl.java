import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MultiplicationImpl extends UnicastRemoteObject implements Multiplication {
    protected MultiplicationImpl() throws RemoteException {
        super();
    }

    @Override
    public int multiply(int a, int b) throws RemoteException {
        return a * b;
    }
}
