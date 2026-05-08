import java.util.*;

public class Bully {

    static boolean[] alive;
    static int n;

    static void election(int p) {
        System.out.print("Start Election from " + p + " ");

        for (int i = p + 1; i < n; i++) {
            if (alive[i]) {
                System.out.println("(" + p + " -> " + i + ")");
                election(i);
                return;
            }
        }

        System.out.println("\nCoordinator (Bully Leader) = " + p);

        for (int i = 0; i < n; i++) {
            if (i != p && alive[i]) {
                System.out.println(p + " => " + i);
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
        System.out.println("2. DOWN a process: Simulate failure (of a Process");
        System.out.println("3. ELECT leader: Starts Bully election from a process");
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


// Bully Algorithm (Leader Election)
// Idea
//
// Highest ID process becomes coordinator
// Lower processes “challenge” higher ones
//
//⚡ Working
//A process detects leader failure
//It sends ELECTION to all higher ID processes
//If no reply → it becomes leader
//If reply comes → higher process takes over
//Finally highest alive process announces COORDINATOR
// Key Points
//Higher ID = higher priority
//Multiple elections can happen
//Eventually highest alive wins
//⚡ Advantages
//Simple logic
//Fast if few processes
// Disadvantages
//Too many messages
//Not efficient for large systems
//Needs knowledge of all processes


// In distributed systems, a leader (coordinator) is required to manage tasks such as resource
// allocation, synchronization, and communication. However, if the coordinator fails, the system
// must elect a new leader dynamically using election algorithms.
// Each process in the system has a unique ID, and processes are aware of other process IDs.
// Based on system structure, two common election algorithms are used:
//  Bully Algorithm
//  Ring Algorithm


// 1. A process detects that the coordinator has failed
// 2. It sends ELECTION messages to all higher-ID processes
// 3. If no one responds → it becomes the coordinator
// 4. If a higher process responds → that process takes over election
// 5. Winner broadcasts COORDINATOR message to all
// Key Features
//  Highest ID process always wins
//  Fast election process
//  Suitable when all processes can communicate directly
// Advantages
//  Simple and efficient
//  Quick recovery from failure
//  Ensures strongest (highest ID) process leads
// Disadvantages
//  High message overhead
//  Not suitable for large systems
//  Assumes knowledge of all processes
