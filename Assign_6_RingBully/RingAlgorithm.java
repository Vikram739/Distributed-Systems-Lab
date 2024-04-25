import java.util.*;

public class RingAlgorithm {
    static int numProcesses;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of processes: ");
        numProcesses = scanner.nextInt();

        System.out.println("\nLeader Election using Ring Algorithm:");
        int coordinator = electLeader();
        System.out.println("\nCoordinator elected: Process " + coordinator);
    }

    static int electLeader() {
        Random random = new Random();
        int initiator = random.nextInt(numProcesses); // Randomly select initiator

        System.out.println("Initiator: Process " + initiator);

        int currentProcess = initiator;
        int nextProcess = (initiator + 1) % numProcesses;

        while (true) {
            System.out.println("Process " + currentProcess + " sends message to Process " + nextProcess);

            // Simulate message sending and receiving
            if (receiveMessage(nextProcess)) {
                if (nextProcess == initiator) {
                    System.out.println("Coordinator elected: Process " + currentProcess);
                    return currentProcess;
                } else {
                    currentProcess = nextProcess;
                    nextProcess = (nextProcess + 1) % numProcesses;
                }
            } else {
                nextProcess = (nextProcess + 1) % numProcesses;
            }
        }
    }

    static boolean receiveMessage(int sender) {
        // Simulate message receiving
        Random random = new Random();
        return random.nextBoolean(); // Random response (true = message received)
    }
}

