import java.util.*;

public class TokenRing {

    static boolean[] alive;
    static int n;

    static void election(int start) {
        System.out.println("Start Election from " + start);

        int leader = start;

        for (int k = 0; k < n; k++) {
            int i = (start + k) % n;   // ring traversal

            if (alive[i]) {
//                System.out.println("(" + start + " -> " + i + ")");
                if (i > leader) {
                    leader = i;
                }
            }
        }

        System.out.println("\nCoordinator (Ring Leader) = " + leader);

        for (int i = (leader + 1) % n; i != leader; i = (i + 1) % n) {
            if (alive[i]) {
                System.out.println(leader + " => " + i);
            }
        }
    }

    static void showStatus() {
        System.out.print("Status: ");
        for (int i = 0; i < n; i++) {
            System.out.print(i + (alive[i] ? "(UP) " : "(DOWN) "));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter total number of processes: ");
        n = sc.nextInt();

        alive = new boolean[n];
        Arrays.fill(alive, true);

        int choice;

        System.out.println("\n========= MENU =========");
        System.out.println("1. UP a process: activate a deactivated Process");
        System.out.println("2. DOWN a process: Simulate failure of a Process");
        System.out.println("3. ELECT leader: Starts Token Ring election");
        System.out.println("4. SHOW STATUS: Displays which processes are UP/DOWN");
        System.out.println("5. EXIT");

        do {
            System.out.print("\nEnter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Process to UP (0-" + (n - 1) + "): ");
                    alive[sc.nextInt()] = true;
                    break;

                case 2:
                    System.out.print("Process to DOWN (0-" + (n - 1) + "): ");
                    alive[sc.nextInt()] = false;
                    break;

                case 3:
                    System.out.print("Start election from process (0-" + (n - 1) + "): ");
                    int p = sc.nextInt();

                    if (!alive[p]) {
                        System.out.println("This Process is DOWN");
                    } else {
                        election(p);
                    }
                    break;

                case 4:
                    showStatus();
                    break;

                case 5:
                    System.out.println("Exit");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 5);
    }
}

// Idea
//
// Processes arranged in ring
// Message (token) circulates
//
//⚡ Working (Election)
//A process starts election
//Passes message around ring
//Each process adds its ID
//After full round → highest ID selected
//Leader announced to all
//⚡ Working (Mutual Exclusion)
//Token circulates continuously
//Process with token enters critical section
//After work → passes token
// Key Points
//Ring structure
//Only one token exists
//No direct communication with all
//⚡ Advantages
//No message flooding
//Fair (everyone gets chance)
// Disadvantages
//Slow (wait for token)
//Token loss = problem
//Ring failure breaks system




// The Ring Algorithm works in systems where processes are arranged in a logical ring.
// Working
// 1. A process detects coordinator failure
// 2. It sends an ELECTION message to next active process
// 3. Each process adds its ID to the message
// 4. Message circulates the ring
// 5. Initiator selects process with highest ID
// 6. Coordinator is announced to all
// Key Features
//  Works in ring topology
//  Uses message passing in sequence
//  No central control required
// Advantages
//  Less message overhead than Bully
//  Fair and structured
//  Works well in large systems
// Disadvantages
//  Slower than Bully algorithm
//  Depends on ring structure
//  Failure handling can be complex
