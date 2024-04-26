import mpi.*;

public class DistributedSum {
    public static void main(String[] args) throws MPIException {
        MPI.Init(args);
        int rank = MPI.COMM_WORLD.Rank(); // get the rank of the current process
        int size = MPI.COMM_WORLD.Size(); // get the total number of processes

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // sample input array
        int n = array.length; // total number of elements
        int local_n = n / size; // number of elements to be processed by each process
        int remainder = n % size; // number of remaining elements

        int[] local_array = new int[local_n + (rank < remainder ? 1 : 0)]; // local array to hold the elements for each process
        int offset = rank * local_n + Math.min(rank, remainder); // compute the offset for the current process
        for (int i = 0; i < local_array.length; i++) {
            local_array[i] = array[offset + i];
        }

        int local_sum = 0; // compute the sum of the local elements
        for (int i = 0; i < local_array.length; i++) {
            local_sum += local_array[i];
        }

        int[] global_sums = new int[size]; // array to hold the global sum from each process
        MPI.COMM_WORLD.Allgather(new int[]{local_sum}, 0, 1, MPI.INT, global_sums, 0, 1, MPI.INT); // gather the local sums to all processes
         
        if (rank == 0) { // print the intermediate and final sums
        	System.out.println("Number of Processes Entered: "+ size);
        	System.out.println("\nIntermediate Sums:");
            int sum = 0;
            for (int i = 0; i < size; i++) {
                sum += global_sums[i];
                System.out.println("Process " + i + ": " + global_sums[i]);
            }
            System.out.println("\nTotal Sum: " + sum);
        }

        MPI.Finalize();
    }
}

// // MPI stands for Message Passing Interface. It's a standardized and portable message-passing system designed to function on a wide variety of parallel computing architectures. MPI is commonly used for parallel computing in scientific and engineering applications, particularly in distributed-memory systems. It allows processes to communicate with each other by sending and receiving messages. This enables the development of parallel algorithms and programs that can run efficiently across multiple processors or nodes in a computing cluster.
// The working of MPI involves several key concepts and mechanisms:

// 1. **Initialization**: MPI programs typically start with initializing the MPI environment using `MPI_Init`. This sets up communication channels between processes and prepares them for message passing.

// 2. **Process Management**: MPI programs run as a collection of parallel processes, each with its own unique identifier or rank. You can get the total number of processes and the rank of each process using `MPI_Comm_size` and `MPI_Comm_rank`, respectively.

// 3. **Communication**: MPI provides a variety of communication functions for processes to exchange data. The main communication operations include point-to-point communication (sending and receiving messages between specific processes) and collective communication (involving all processes in a communicator). Examples of point-to-point communication functions are `MPI_Send` and `MPI_Recv`, while collective communication functions include `MPI_Bcast` (broadcast) and `MPI_Reduce` (reduce).

// 4. **Blocking and Non-blocking Operations**: MPI supports both blocking and non-blocking communication operations. In blocking communication, the sender and receiver are synchronized until the message is sent or received. Non-blocking operations allow the sender to continue execution without waiting for the completion of the communication.

// 5. **Data Types**: MPI allows communication of data in various formats, including basic data types like integers and floating-point numbers, as well as derived data types like arrays and structures. These data types can be defined using `MPI_Type_create_struct` or other similar functions.

// 6. **Error Handling**: MPI provides error handling mechanisms to detect and handle errors during program execution. Functions like `MPI_Error_string` and `MPI_Abort` are used for error reporting and aborting MPI programs, respectively.

// 7. **Finalization**: Once the MPI program has completed its tasks, it should be finalized using `MPI_Finalize`. This cleans up resources associated with the MPI environment and terminates the MPI execution.

// Overall, MPI enables parallel programming by providing a standardized interface for communication and coordination among parallel processes, allowing developers to create efficient and scalable parallel applications for various parallel computing architectures.
