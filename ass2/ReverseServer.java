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
