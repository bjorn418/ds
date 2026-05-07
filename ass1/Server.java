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
//        ● Remote Interface
//● Implementation class
//● Server class
//● Client class
//17. Command to generate stub?
//rmic AddServerImpl
//18. Command to start registry?
//rmiregistry
//19. Advantages of RMI?
//        ● Easy distributed programming
//● Object-oriented communication
//● Platform independence
//20. Limitations of RMI?
//        ● Java dependent
//● Slower due to network overhead