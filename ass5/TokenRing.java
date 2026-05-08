import java.util.*;

public class TokenRing {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Number Of Nodes: ");
        int n = sc.nextInt();

        System.out.println("Ring:");
        for (int i = 0; i < n; i++)
            System.out.print(i + " -> ");
        System.out.println("0");


        int token = 0; // token starts at 0

        int choice = 1;   // start loop

        while (choice == 1) {

            System.out.println("\nCurrent Token at Process: " + token);

            System.out.print("Enter Sender: "); int sender = sc.nextInt();
            System.out.print("Enter Receiver: "); int receiver = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Data: "); String data = sc.nextLine();

            // move token until it reaches sender
            System.out.println("\nToken Passing:");
            while (token != sender) {
                System.out.print(token + " -> ");
                token = (token + 1) % n;
            }
            System.out.println(sender);

            // critical section
            System.out.println("\nProcess " + sender + " ENTERS Critical Section");
            System.out.println("Sending Data: " + data);

            // data forwarding
            int i = sender;
            while (i != receiver) {
                System.out.println("Data forwarded By " + i + " To " + (i+1)%n);
                i = (i + 1) % n;
            }

            System.out.println("Receiver " + receiver + " received data: " + data);
            System.out.println("Process " + sender + " EXITS Critical Section");

            // pass token
            token = (sender + 1) % n;

            System.out.print("\nEnter 1 to continue, 0 to stop: ");
            choice = sc.nextInt();
        }
    }
}

//javac  TokenRing.java
//java TokenRing



//1. What is mutual exclusion?
//Ensuring only one process accesses critical section at a time.
//        2. What is Token Ring Algorithm?
//Distributed mutual exclusion algorithm using a token.
//3. What is a token?
//Special permission message allowing access to critical section.
//        4. What is ring topology?
//Processes connected in circular manner.
//5. Which process enters critical section?
//Only process holding token.
//        6. What happens after execution?
//Token passed to next process.
//7. What is critical section?
//Code accessing shared resource.
//        8. Advantages of token ring?
//         Fairness
// No starvation
//9. Disadvantage of token ring?
//Token loss causes failure.
//        10. What is starvation?
//Process waits indefinitely.
//11. What is fairness?
//Every process gets equal chance.
//12. What is liveness?
//System continues making progress.
//        13. What is safety?
//Only one process enters critical section.
//        14. Why synchronization needed?
//Avoid data inconsistency.
//15. What if token is duplicated?
//Multiple processes may enter critical section.
//        16. How token loss handled?
//Generate new token using recovery algorithm.
//        17. Difference between centralized and distributed mutual exclusion?
//Centralized uses coordinator, distributed does not.
//18. What is deadlock?
//Processes wait forever for resources.
//19. Real-life example?
//Single printer shared among users.
//20. Main benefit of token ring?
//Guaranteed mutual exclusion with orderly access



// In distributed systems, process synchronization ensures that multiple processes coordinate
// properly while accessing shared resources. When a resource must be accessed by only one
// process at a time, the concept of mutual exclusion is used. It guarantees that no two
// processes enter the critical section simultaneously.
// A good mutual exclusion algorithm must satisfy:
//  Safety → Only one process accesses resource at a time
//  Liveness → Processes eventually get access
//  Fairness → No starvation; equal opportunity for all
// Types of Mutual Exclusion Algorithms
// 1. Centralized Algorithm → Uses a coordinator
// 2. Token-Based Algorithm → Uses a circulating token
// 3. Contention-Based Algorithm → Resolves conflicts dynamically
// The Token Ring Algorithm belongs to the token-based category.
// Token Ring Algorithm Overview
// In this algorithm, processes are arranged in a logical ring structure. A special message called
// a token is passed from one process to another in a fixed order.
//  Only the process holding the token can enter the critical section
//  After completing its task, the process passes the token to the next process
// Working of Token Ring Algorithm
// 1. Initialization
// ○ Token is initially given to process 0
// 2. Token Passing
// ○ Token moves in ring order:
// Process i → Process (i+1) mod n
// 3. Critical Section Access
// ○ If a process needs resource → it uses token
// ○ Executes critical section
// 4. Release & Forward Token
// ○ After execution, process passes token to next
// 5. Idle Case
// ○ If process doesn’t need resource → directly passes token
// Key Characteristics
//  Ensures mutual exclusion (only one token exists)
//  Provides fair access (round-robin order)
//  No need for a central coordinator
//  Simple and easy to implement
// Advantages
//  No starvation due to fixed order
//  Predictable and fair scheduling
//  Fully distributed (no single point of failure like centralized system)
// Disadvantages
//  Token loss problem → system halts if token is lost
//  Detecting lost token is difficult
//  Delay increases with large number of processes
// Not efficient if many processes don’t need resource
// Comparison with Centralized Approach
// Feature Token Ring Centralized
// Control Distributed Single coordinator
// Failure Token loss
// issue
// Single point failure
// Fairness High Queue-based
// Complexity Moderate Simple
