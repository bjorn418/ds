import ReverseModule.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;

class ReverseServer {
    public static void main(String args[]) {
        try {
            ORB orb = ORB.init(args, null);

            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            ReverseImpl obj = new ReverseImpl();

            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(obj);
            Reverse href = ReverseHelper.narrow(ref);

            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            ncRef.rebind(ncRef.to_name("Reverse"), href);

            System.out.println("Server ready...");
            orb.run();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}




//idlj -fall Reverse.idl
//javac *.java ReverseModule/*.java
//orbd -ORBInitialPort 1050
//java ReverseServer -ORBInitialPort 1050 -ORBInitialHost localhost
//java ReverseClient -ORBInitialPort 1050 -ORBInitialHost localhost


//1. What is CORBA?
//CORBA stands for Common Object Request Broker Architecture used for
//communication between distributed objects.
//        2. Who developed CORBA?
//OMG (Object Management Group).
//        3. What is ORB?
//ORB (Object Request Broker) handles communication between client and server
//objects.
//4. What is IDL?
//IDL (Interface Definition Language) defines interfaces for distributed objects.
//        5. Why is IDL important?
//It allows communication between applications written in different languages.
//6. What is IIOP?
//Internet Inter-ORB Protocol used for communication between ORBs.
//7. What is a stub in CORBA?
//Client-side proxy object.
//8. What is a skeleton in CORBA?
//Server-side object that receives requests.
//9. What is POA?
//Portable Object Adapter used to connect object implementation with ORB.
//        10. What is naming service?
//It maps object names to object references.
//11. Command to generate Java files from IDL?
//idlj -fall Hello.idl
//12. What is orbd?
//ORB daemon process providing naming service.
//        13. Difference between RMI and CORBA?
//         RMI is Java-specific
// CORBA supports multiple languages
//14. What are helper classes?
//Classes used for narrowing and stream operations.
//        15. What are holder classes?
//Used for out and inout parameters.
//        16. Advantages of CORBA?
//         Language independent
// Platform independent
// Supports distributed computing
//17. What is object reference?
//Unique identifier used to access CORBA objects.
//18. What is static invocation?
//Invocation using pre-generated stubs and skeletons.
//        19. What is distributed object computing?
//Objects communicate over network transparently.
//20. Why is CORBA used?
//To integrate heterogeneous distributed systems.



// Distributed Application using CORBA – Summary
// CORBA (Common Object Request Broker Architecture) is a vendor-independent
// distributed computing framework developed by the Object Management Group (OMG). It
// enables communication between applications written in different programming languages and
// running on different platforms. This makes it highly useful for integrating heterogeneous systems
// in a distributed environment.
// CORBA uses an Object Request Broker (ORB), which acts as a middleware that allows clients
// to invoke methods on remote objects as if they were local. This provides location transparency
// and simplifies distributed communication.
// Key Components of CORBA
// 1. ORB (Object Request Broker)
//  Core component of CORBA
//  Handles communication between client and server
//  Locates objects and forwards requests
// 2. IDL (Interface Definition Language)
//  Defines interfaces between client and server
//  Language-independent
//  Used to generate stubs and skeletons
// 3. Stub and Skeleton
//  Stub (Client-side proxy) → Sends request to server
//  Skeleton (Server-side proxy) → Receives request and calls method
// These components ensure seamless communication in distributed systems.
// Working of CORBA
// 1. Client requests a remote method
// 2. Stub converts request into ORB format
// 3. ORB forwards request using IIOP protocol
// 4. Skeleton receives request on server
// 5. Server executes method
// 6. Response is sent back via ORB
// This process allows remote method invocation (RMI-like behavior) across different systems.
// Java Support for CORBA
// Java provides built-in support for CORBA using:
//  Java IDL → API for CORBA integration
//  idlj compiler → Converts IDL to Java code
//  ORBD → Naming service daemon
// Java + CORBA provides:
//  Network transparency (CORBA)
//  Platform independence (Java)
// Steps to Develop CORBA Application
// 1. Define Interface (IDL)
// Write interface using IDL specifying methods and data types.
// 2. Generate Java Code
// Use idlj -fall file.idl to generate:
//  Interface
//  Stub
//  Skeleton
//  Helper & Holder classes
// 3. Implement Server
//  Extend generated skeleton class
//  Implement methods
//  Register object with naming service
// 4. Implement Client
//  Initialize ORB
//  Get object reference from naming service
//  Call remote methods
// Execution Steps
// 1. Compile IDL → generate classes
// 2. Compile Java files
// 3. Start naming service (orbd)
// 4. Run server
// 5. Run client
// The client invokes remote methods and receives results from server.
// Example: Hello World CORBA
//  Server implements sayHello() method
//  Client calls method remotely
//  Output: “Hello World!”
// This demonstrates remote communication using CORBA architecture.
// Advantages of CORBA
//  Platform and language independent
//  Supports distributed systems
//  Promotes interoperability
//  Scalable and flexible architecture
