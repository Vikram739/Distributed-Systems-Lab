import java.util.*;

public class BullyAlgorithm {
    static int numProcesses;
    static boolean[] activeProcesses;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of processes: ");
        numProcesses = scanner.nextInt();

        activeProcesses = new boolean[numProcesses];
        Arrays.fill(activeProcesses, true);

        System.out.println("\nLeader Election using Bully Algorithm:");
        int coordinator = electLeader();
        System.out.println("\nCoordinator elected: Process " + coordinator);
    }

    static int electLeader() {
        int highestId = 0;
        for (int i = 1; i < numProcesses; i++) {
            if (activeProcesses[i])
                highestId = i;
        }

        System.out.println("Process " + highestId + " sends election messages to higher numbered processes...");

        int coordinator = highestId;
        for (int i = highestId + 1; i < numProcesses; i++) {
            if (activeProcesses[i]) {
                System.out.println("Process " + highestId + " sends election message to Process " + i);
                if (sendElectionMessage(i)) {
                    coordinator = i;
                }
            }
        }

        System.out.println("Process " + coordinator + " becomes the coordinator.");

        return coordinator;
    }

    static boolean sendElectionMessage(int processId) {
        // Simulate message sending and receiving
        Random random = new Random();
        return random.nextBoolean(); // Random response (true = process accepted election)
    }
}

