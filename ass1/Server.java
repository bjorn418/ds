import java.rmi.*;

public class Server{
    public static void main(String[] args){
        try{
            ServerImpl simp = new ServerImpl(); //Stub
            Naming.rebind("Server", simp);
        }
        catch(Exception e){
            System.out.println("Exception at Server: " + e.getMessage());
        }
    }
}


//javac  *.java
//rmiregistry
//java Server
//        java Client



//1. What is RMI?
//RMI (Remote Method Invocation) is a Java technology that allows a Java object running
//on one machine to invoke methods on an object running on another machine.
//2. Why is RMI used?
//RMI is used to build distributed applications where objects communicate remotely over
//a network.
//        3. What is a remote object?
//A remote object is an object whose methods can be accessed from another JVM over a
//network.
//4. What is a remote interface?
//A remote interface defines methods that can be called remotely. It extends the Remote
//interface.
//        5. Why do remote methods throw RemoteException?
//Because network communication may fail during remote calls.
//        6. What is a stub?
//A stub is a client-side proxy object that forwards requests to the remote server object.
//7. What is a skeleton?
//A skeleton is a server-side object that receives requests from the stub and invokes
//actual methods.
//        8. What is the role of rmiregistry?
//It stores remote object references and helps clients locate remote objects.
//9. What is marshalling?
//Marshalling means converting objects/data into a stream for network transmission.
//        10. What is unmarshalling?
//It is the process of reconstructing transmitted data back into objects.
//11. Which package is used for RMI?
//java.rmi
//12. Why does remote object extend UnicastRemoteObject?
//To make the object available for remote communication.
//        13. What is Naming.rebind()?
//It binds or registers a remote object with the RMI registry.
//14. Difference between local and remote method invocation?
//Local invocation occurs within same JVM, remote invocation occurs across different
//JVMs/machines.
//15. What is serialization in RMI?
//It converts objects into byte streams for transmission.
//16. What files are required in RMI?
//         Remote Interface
// Implementation class
// Server class
// Client class
//17. Command to generate stub?
//rmic AddServerImpl
//18. Command to start registry?
//rmiregistry
//19. Advantages of RMI?
//         Easy distributed programming
// Object-oriented communication
// Platform independence
//20. Limitations of RMI?
//         Java dependent
// Slower due to network overhead






// RMI (Remote Method Invocation) – Summary
// Remote Method Invocation (RMI) is a Java technology that enables
// communication between Java applications running on different machines
// in a distributed environment. Using RMI, an object in one JVM can invoke
// methods of an object located in another JVM as if it were a local object.
// This helps in developing distributed client-server applications.
// RMI architecture consists of client, server, stub, skeleton, and RMI registry.
// The RMI registry acts as a naming service that allows clients to locate
// remote objects available on the server.
// Key Components of RMI
// 1. Remote Object
// An object whose methods can be invoked remotely by another application.
// 2. Remote Interface
// Defines methods available for remote access.
//  Extends java.rmi.Remote
//  Methods throw RemoteException
// 3. Stub
// A client-side proxy object.
// Responsibilities:
//  Establish connection with remote JVM
//  Marshal parameters
//  Send request and receive response
// 4. Skeleton
// A server-side gateway.
// Responsibilities:
//  Receive request from stub
//  Invoke actual method
//  Return result to client
// 5. RMI Registry
// A naming service that binds remote objects to names so clients can locate
// them.
// Working of RMI
// 1. Client requests remote method
// 2. Stub receives request and sends it over network
// 3. Skeleton on server receives request
// 4. Actual remote method executes
// 5. Result is sent back to client
// This creates transparent communication between distributed applications.
// Implementation Steps
// 1. Create Remote Interface
// Defines remote methods like add().
// 2. Implement Remote Interface
// Server class implements the interface and extends
// UnicastRemoteObject.
// 3. Create Server Program
//  Creates remote object
// Registers it using Naming.rebind()
// 4. Create Client Program
//  Uses Naming.lookup()
//  Invokes remote methods
// Stub Generation
// Generate stub using:
// rmic AddServerImpl
// This creates:
// ● AddServerImpl_Stub.class
// Execution Steps
// Start RMI Registry
// start rmiregistry
// Run Server
// java AddServer
// Run Client
// java AddClient <serverIP> num1 num2
// Example:
// java AddClient 192.168.1.1 7 8
// The server computes the addition and returns the result to the client.
// Advantages of RMI
//  Supports distributed computing
//  Easy remote communication
//  Object-oriented approach
//  Simplifies client-server applications
// Applications of RMI
//  Distributed systems
//  Client-server applications
//  Enterprise systems
// Remote database access
