
//DS Assignment 6: Implement Bully and Ring algorithm for leader election.

 
import java.util.Scanner;

// create process class for creating a process having id and status  
class Process {
	public int id;
	public String status;

	public Process(int id) {
		this.id = id;
		this.status = "active";
	}
}

public class BullyRing {

	Scanner sc;
	Process[] processes;
	int n;

	// initialize Scanner class object in constructor
	public BullyRing() {
		sc = new Scanner(System.in);
	}

	// create ring() method for initializing the ring
	public void ring() {

		// get input from the user for processes
		System.out.print("Enter total number of processes: ");
		n = sc.nextInt();

		// initialize processes array
		processes = new Process[n];
		for (int i = 0; i < n; i++) {
			processes[i] = new Process(i);
		}
	}

	// create election() method for electing process
	public void performElection() {

		// we use the sleep() method to stop the execution of the current thread
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		// show failed process
		System.out.println("Process " + processes[getMaxValue()].id + " fails");

		// change status to Inactive of the failed process
		processes[getMaxValue()].status = "Inactive";

		int idOfInitiator = 0;
		boolean overStatus = true;

		while (overStatus) {

			boolean higherProcesses = false;

			// iterate all the processes
			System.out.println();
			for (int i = idOfInitiator + 1; i < n; i++) {
				if (processes[i].status == "active") {
					System.out.println("Process " + idOfInitiator + " Passes Election(" + idOfInitiator	+ ") message to Process " + i);
					higherProcesses = true;
				}
			}

			// check for higher process
			if (higherProcesses) {
				
				System.out.println();
				for (int i = idOfInitiator + 1; i < n; i++) {
					if (processes[i].status == "active") {
						System.out.println("Process " + i + " passes Ok(" + i + ") message to Process " + idOfInitiator);
					}
				}
				idOfInitiator++;
			}

			else {
				// get the last process from the processes that will become coordinator
				int coord = processes[getMaxValue()].id;

				// show process that becomes the coordinator
				System.out.println("Finally Process " + coord + " Becomes Coordinator");

				for (int i = coord - 1; i >= 0; i--) {
					if (processes[i].status == "active") {
						System.out.println("Process " + coord + " passes Coordinator(" + coord + ") message to Process " + i);
					}
				}
				System.out.println("\nEnd of Election");
				overStatus = false;
				break;
			}
		}
	}

	// create getMaxValue() method that returns index of max process
	public int getMaxValue() {
		int mxId = -99;
		int mxIdIndex = 0;
		for (int i = 0; i < processes.length; i++) {
			if (processes[i].status == "active" && processes[i].id > mxId) {
				mxId = processes[i].id;
				mxIdIndex = i;
			}
		}
		return mxIdIndex;
	}

	public static void main(String[] args) {

		BullyRing bully = new BullyRing();

		bully.ring();
		bully.performElection();
	}
}
/* Output: 
Enter total number of processes: 6
Process 5 fails

Process 0 Passes Election(0) message to Process 1
Process 0 Passes Election(0) message to Process 2
Process 0 Passes Election(0) message to Process 3
Process 0 Passes Election(0) message to Process 4

Process 1 passes Ok(1) message to Process 0
Process 2 passes Ok(2) message to Process 0
Process 3 passes Ok(3) message to Process 0
Process 4 passes Ok(4) message to Process 0

Process 1 Passes Election(1) message to Process 2
Process 1 Passes Election(1) message to Process 3
Process 1 Passes Election(1) message to Process 4

Process 2 passes Ok(2) message to Process 1
Process 3 passes Ok(3) message to Process 1
Process 4 passes Ok(4) message to Process 1

Process 2 Passes Election(2) message to Process 3
Process 2 Passes Election(2) message to Process 4

Process 3 passes Ok(3) message to Process 2
Process 4 passes Ok(4) message to Process 2

Process 3 Passes Election(3) message to Process 4

Process 4 passes Ok(4) message to Process 3

Finally Process 4 Becomes Coordinator
Process 4 passes Coordinator(4) message to Process 3
Process 4 passes Coordinator(4) message to Process 2
Process 4 passes Coordinator(4) message to Process 1
Process 4 passes Coordinator(4) message to Process 0

End of Election

 */


// Both the Bully Algorithm and the Ring Algorithm are used for leader election in distributed systems. They are designed to allow a set of processes to elect a leader among themselves, typically to coordinate activities or make decisions in a decentralized manner. Let's delve into each algorithm:

// ### Bully Algorithm:

// 1. **Initialization**: Each process in the system has a unique ID. Initially, all processes are in a passive state.
  
// 2. **Election Trigger**: If a process detects that the current leader has failed (e.g., due to a timeout or unresponsive message), it starts an election process by sending an election message to all processes with higher IDs.

// 3. **Election Message Handling**:
//    - Upon receiving an election message, a process with a higher ID responds by sending an "OK" message and starts its own election.
//    - If a process does not receive any response within a timeout period, it assumes that it has the highest ID and declares itself as the new leader.

// 4. **New Leader Notification**: The newly elected leader sends a coordinator message to all processes, informing them of its leadership status.

// 5. **Handling Process Failures**: If a process fails during the election process, other processes detect this failure and may trigger a new election to elect a new leader.

// ### Ring Algorithm:

// 1. **Ring Formation**: Processes are logically arranged in a ring topology. Each process knows the identity of its neighbor(s) in the ring.

// 2. **Election Trigger**: If a process detects that the current leader has failed, it initiates an election process by sending an election message to its neighbor(s) in the ring.

// 3. **Election Message Propagation**:
//    - Upon receiving an election message, a process checks if it has already seen the message or if it has a higher priority.
//    - If not, it forwards the election message to its neighbor(s).
//    - If a process receives its own election message, it knows that the message has traversed the entire ring, and it declares itself as the leader.

// 4. **New Leader Notification**: The newly elected leader sends a coordinator message to all processes, informing them of its leadership status.

// 5. **Handling Process Failures**: If a process fails during the election process, the election message continues to propagate around the ring until a new leader is elected.

// Both algorithms have their advantages and disadvantages. The Bully Algorithm has a faster convergence time in scenarios where the failed leader has a higher ID, but it requires a mechanism to handle the absence of processes with higher IDs. The Ring Algorithm is simpler to implement and is more robust to network partitions but may have slower convergence time in larger networks. The choice between the two algorithms depends on the specific requirements and constraints of the distributed system.



 // Difference between bully and ring
// The Bully Algorithm and the Ring Algorithm are both used for leader election in distributed systems, but they differ in their approach, communication patterns, and fault tolerance mechanisms. Here are the key differences between the two algorithms:

// ### 1. Communication Pattern:

// - **Bully Algorithm**:
//   - In the Bully Algorithm, the election process is initiated by a process detecting the failure of the current leader.
//   - The process then sends election messages to all processes with higher IDs, which respond with "OK" messages if they are still alive.
//   - If no response is received within a timeout period, the initiating process assumes leadership.

// - **Ring Algorithm**:
//   - In the Ring Algorithm, the election process is initiated by a process detecting the failure of the current leader.
//   - The process sends an election message to its neighbor(s) in the logical ring, which in turn propagate the message until it reaches all processes in the ring.
//   - The process that initially sent the election message receives it again, indicating that it has traversed the entire ring, and declares itself as the new leader.

// ### 2. Topology and Coordination:

// - **Bully Algorithm**:
//   - The Bully Algorithm does not rely on a specific network topology; it is typically implemented in a peer-to-peer manner where processes communicate directly with each other.
//   - The coordination process involves sending messages to processes with higher IDs, which may lead to more network traffic in larger systems.

// - **Ring Algorithm**:
//   - The Ring Algorithm assumes a logical ring topology where each process knows its neighbors.
//   - The coordination process involves passing an election message around the ring until it reaches the initiator again, which reduces the amount of network traffic compared to the Bully Algorithm.

// ### 3. Fault Tolerance:

// - **Bully Algorithm**:
//   - The Bully Algorithm requires processes to handle the absence of processes with higher IDs gracefully.
//   - If a process fails during the election process, the Bully Algorithm may need to restart the election from the beginning.

// - **Ring Algorithm**:
//   - The Ring Algorithm is more robust to failures during the election process.
//   - If a process fails during the election process, the election message continues to propagate around the ring until a new leader is elected.

// ### 4. Convergence Time:

// - **Bully Algorithm**:
//   - The Bully Algorithm typically has faster convergence time in scenarios where the failed leader has a higher ID.
//   - However, it may have longer convergence time if there are many processes with higher IDs that need to respond.

// - **Ring Algorithm**:
//   - The Ring Algorithm may have slower convergence time, especially in larger networks, due to the propagation of the election message around the ring.

// In summary, while both algorithms serve the same purpose of leader election in distributed systems, they differ in their communication patterns, fault tolerance mechanisms, and convergence time, making them suitable for different types of distributed environments and requirements.