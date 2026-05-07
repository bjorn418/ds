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