// Step 2: Implement the Remote Interface
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AdditionServiceImpl extends UnicastRemoteObject implements AdditionService {
    public AdditionServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public int add(int a, int b) throws RemoteException {
        return a + b;
    }
}
