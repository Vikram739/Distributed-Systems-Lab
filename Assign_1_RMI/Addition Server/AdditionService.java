// Step 1: Define the Remote Interface
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AdditionService extends Remote {
    int add(int a, int b) throws RemoteException;
}



// RMI stands for Remote Method Invocation. It is a mechanism provided by Java that allows objects to invoke methods on remote objects, potentially located on different Java Virtual Machines (JVMs) running on different hosts in a network.

// Here's how it works:

// Interface Definition: You define an interface that declares the methods that can be invoked remotely. This interface must extend the java.rmi.Remote interface, and each method must declare java.rmi.RemoteException in its throws clause.
// Implementation: You create a class that implements the remote interface. This class provides the actual implementation of the methods declared in the interface.
// Server: You create a server program that instantiates and exports the remote object. This server listens for incoming requests from clients.
// Client: You create a client program that looks up the remote object and invokes methods on it as if it were a local object. The client program communicates with the server to execute the remote method calls.
// RMI handles the details of communication between the client and server, including parameter marshalling (converting method parameters and return values into a format suitable for transmission over the network) and handling network-related errors.

// RMI is often used in distributed computing scenarios where you have a client-server architecture and need to invoke methods on objects that reside on remote machines. It provides a convenient way to interact with remote objects as if they were local, simplifying the development of distributed applications in Java.

// The RMI (Remote Method Invocation) is an API that provides a mechanism to create distributed application in java. The RMI allows an object to invoke methods on an object running in another JVM.
