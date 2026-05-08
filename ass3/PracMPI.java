import mpi.*;
import java.util.Random;

public class PracMPI {
    public static void main(String args[]) throws Exception {
        MPI.Init(args);

        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size(); // it is the value we pass during execution of the code

        int[] send = null;
        int n = 8; // MUST be divisible by size 
        int chunkSize = n / size;

        int[] recv = new int[chunkSize];

        // ROOT initializes array
        if (rank == 0) {
            
            send = new int[]{1,2,3,4,5,6,7,8};

            // INCASE OF RANDOMLY GENERATED ARRAY
            /*
            send = new int[n];
            Random rand = new Random();

            for (int i = 0; i < n; i++)
                send[i] = rand.nextInt(10);
            */

        } else {
            send = new int[n]; // dummy array for other processes
        }

        // SCATTER
        MPI.COMM_WORLD.Scatter(send, 0, chunkSize, MPI.INT, recv, 0, chunkSize, MPI.INT, 0);

        // SUM (2.1)
        
        int sum = 0;
        for (int i = 0; i < recv.length; i++)
            sum += recv[i];

        System.out.println("Process " + rank + " Sum: " + sum);
        
        
        // -----------------------------------------------------------------------------------------------------

        // MULTIPLICATION (2.2)
        /*
        int prod = 1;
        for (int i = 0; i < recv.length; i++)
            prod *= recv[i];

        System.out.println("Process " + rank + " Product: " + prod);
        */
        // -----------------------------------------------------------------------------------------------------

        // AVERAGE (2.3)
        /*
        double localSum = 0;

        // each process computes sum of its chunk
        for (int i = 0; i < recv.length; i++)
            localSum += recv[i];

        // local average
        double localAvg = localSum / recv.length;
        System.out.println("Process " + rank + " Local Avg: " + localAvg);

        // gather all local averages at root
        double[] gathered = new double[size];
        MPI.COMM_WORLD.Gather(new double[]{localAvg}, 0, 1, MPI.DOUBLE, gathered, 0, 1, MPI.DOUBLE, 0);

        // root computes final average
        if (rank == 0) {
            double finalSum = 0;
            for (int i = 0; i < gathered.length; i++)
                finalSum += gathered[i];

            double finalAvg = finalSum / size;

            System.out.println("Final Average: " + finalAvg);
        }
        */
        // -----------------------------------------------------------------------------------------------------
        
        // RECIPROCAL (2.4)
        /*
        // create a recArr array that stores reciprocals of the elements of recv array
        double[] recArr = new double[recv.length];

        for (int i = 0; i < recv.length; i++)
            recArr[i] = 1.0 / recv[i];

        // Gather results at root
        double[] result = new double[n];
        MPI.COMM_WORLD.Gather(recArr, 0, chunkSize, MPI.DOUBLE, result, 0, chunkSize, MPI.DOUBLE, 0);

        // Root prints final array
        if (rank == 0) {
            System.out.print("Reciprocal Array: ");
            for (int i = 0; i < result.length; i++)
                System.out.print(result[i] + " ");
            System.out.println();
        }
        */
        // -----------------------------------------------------------------------------------------------------

        MPI.Finalize();
    }
}

// javac -source 1.8 -target 1.8 -cp ".;C:\Users\91942\Downloads\mpj-v0_44\mpj-v0_44\lib\mpj.jar" PracMPI.java
// javac  PracMPI.java
//mpjrun.bat -np 4 PracMPI


//What is MPI?
//MPI stands for Message Passing Interface used for parallel computing.
//        2. What is MPJ Express?
//Java implementation of MPI.
//        3. What is parallel computing?
//Multiple processors execute tasks simultaneously.
//4. What is communicator?
//Group of processes communicating together.
//5. What is MPI_COMM_WORLD?
//Default communicator containing all processes.
//6. What is rank?
//Unique ID assigned to each process.
//        7. What is process size?
//Total number of processes in communicator.
//        8. Function to get process rank?
//MPI_Comm_rank()
//9. Function to get total processes?
//MPI_Comm_size()
//10. What is scatter operation?
//Distributes data among processes.
//        11. What is gather operation?
//Collects data from processes.
//        12. What is SPMD?
//Single Program Multiple Data model.
//13. What is multicore configuration?
//Execution on multiple cores of same machine.
//14. What is message passing?
//Processes communicate by sending messages.
//15. Why MPI is used?
//For high-performance parallel processing.
//16. What is synchronization in MPI?
//Coordination among parallel processes.
//        17. What is MPI_Send?
//Function to send messages.
//        18. What is MPI_Recv?
//Function to receive messages.
//        19. Advantages of MPJ Express?
//         Portable
// Scalable
// Efficient parallel execution
//20. Command to run MPJ program?
//mpjrun.sh -np 4 Asign2


// Distributed System using MPI (MPJ Express) – Summary
// Message Passing Interface (MPI) is a widely used parallel programming model that enables
// communication between multiple processes in a distributed system. It follows a
// message-passing mechanism, where processes exchange data to perform computations
// collaboratively. In Java, MPI is implemented using libraries like MPJ Express, which allows
// execution of parallel programs on multicore systems and clusters.
// MPI follows a Single Program Multiple Data (SPMD) model, where multiple processes execute
// the same program but operate on different portions of data. This improves performance and
// efficiency for computational tasks like summation of large arrays.
// Basic Concepts of MPI
// 1. Initialization & Finalization
//  MPI_Init() → Starts MPI environment
//  MPI_Finalize() → Ends execution
// 2. Communicator
//  Group of processes that communicate with each other
//  Default communicator: MPI_COMM_WORLD
// 3. Rank and Size
//  Rank → Unique ID of each process
//  Size → Total number of processes
// These are essential for identifying and managing processes.
// Message Passing Operations
// 1. Send Operation
// Used to send data from one process to another:
// MPI_Send()
// 2. Receive Operation
// Used to receive data from another process:
// MPI_Recv()
// These operations enable communication between distributed processes.
// Collective Communication
// MPI supports group communication operations:
//  Scatter → Divides data into parts and distributes to processes
//  Gather → Collects results from all processes
// In this assignment, the array is divided among processes using scatter, and partial sums are
// combined using gather.
// Working of the Program
// 1. Input array of size N
// 2. Divide array into N/n parts
// 3. Distribute parts to n processors
// 4. Each processor calculates partial sum
// 5. Intermediate sums are displayed
// 6. Final sum is computed by combining results
// This demonstrates parallel computation using MPI.
// MPJ Express
// MPJ Express is a Java-based MPI library used for:
//  Parallel programming
//  Multicore execution
//  Cluster computing
// It acts as middleware to manage communication between processes and supports scalable
// applications.
// Implementation Steps
// 1. Install MPJ Express and set environment variables
// 2. Write Java program (e.g., ScatterGather.java)
// 3. Compile using:
// javac -cp mpj.jar filename.java
// 4. Execute using:
// mpjrun.sh -np <no_of_processes> filename
// Advantages of MPI
//  Efficient parallel processing
//  Scalable to large systems
//  Supports distributed and shared memory
//  Improves performance of computation-heavy tasks
