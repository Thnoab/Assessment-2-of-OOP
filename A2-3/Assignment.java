package A2;

public class Assignment {
    public static void main(String[] args) {
        // Create operator objects
        Employee operator1 = new Employee("Diana Moriarty", 22, "Female", "E001", "Ride Operator", 10000);
        Employee operator2 = new Employee("François de Clermont", 30, "Male", "E002", "Ride Operator", 12000);

        // Create visitor objects
        Visitor visitor1 = new Visitor("Enrique de Pessoa", 25, "Male", "V001", "Standard", "2024-11-26");
        Visitor visitor2 = new Visitor("H. P. Lovecraft", 46, "Male", "V002", "VIP", "2024-11-26");
        Visitor visitor3 = new Visitor("Berthold Speer", 30, "Male", "V003", "VIP", "2024-11-26");
        Visitor visitor4 = new Visitor("Loli Zeppelin", 22, "Female", "V004", "Standard", "2024-11-26");
        Visitor visitor5 = new Visitor("Anna Komneni", 23, "Female", "V005", "Standard", "2024-11-26");

        // Create two ride objects
        Ride rollerCoaster = new Ride("Roller Coaster", 2);  // Ride with 2 seats
        Ride thunderstorm = new Ride("Thunderstorm", 4);     // Ride with 4 seats

        // Assign operators to the rides
        rollerCoaster.assignOperator(operator1);
        thunderstorm.assignOperator(operator2);

        // Add visitors to the ride queues (only add once)
        rollerCoaster.addVisitorToQueue(visitor1);
        rollerCoaster.addVisitorToQueue(visitor2);
        rollerCoaster.addVisitorToQueue(visitor3);
        rollerCoaster.addVisitorToQueue(visitor4);
        rollerCoaster.addVisitorToQueue(visitor5);

        thunderstorm.addVisitorToQueue(visitor1);
        thunderstorm.addVisitorToQueue(visitor2);
        thunderstorm.addVisitorToQueue(visitor3);
        thunderstorm.addVisitorToQueue(visitor4);
        thunderstorm.addVisitorToQueue(visitor5);

        // -------------------------------------
        // Part 3: Queue Interface
        partThree(rollerCoaster);  // Call the partThree method for "Roller Coaster"
        partThree(thunderstorm);   // Call the partThree method for "Thunderstorm"

        // -------------------------------------
        // Part 4A: Collection Class (LinkedList)
        partFourA(rollerCoaster);
        partFourA(thunderstorm);

        // -------------------------------------
        // Part 4B: Sorting the Collection
        partFourB(rollerCoaster);
        partFourB(thunderstorm);

        // -------------------------------------
        // Part 5: Run a Ride Cycle
        partFive(rollerCoaster);
        partFive(thunderstorm);

        // -------------------------------------
        // Part 6: Writing to a File
        partSix(rollerCoaster);
        partSix(thunderstorm);

        // -------------------------------------
        // Part 7: Reading from a File
        partSeven(rollerCoaster);
        partSeven(thunderstorm);
    }

    // Part 3: Queue Interface
    // This method demonstrates how to operate the queue: adding visitors, removing visitors, and printing the queue
    public static void partThree(Ride ride) {
        System.out.println("=== Part 3: Queue Interface ===");

        // Create a visitor and add them to the queue (avoid adding duplicates)
        Visitor visitor6 = new Visitor("John Doe", 28, "Male", "V006", "Standard", "2024-11-26");
        ride.addVisitorToQueue(visitor6);  // Add a new visitor to the queue

        System.out.println("Visitors in queue before removal:");
        ride.printQueue();  // Print the current visitor queue information

        // Remove the first visitor from the queue
        ride.removeVisitorFromQueue(ride.getQueue().peek());  // Remove the first visitor from the queue
        System.out.println("Visitor removed from the queue: " + visitor6.getName());  // Print the removed visitor's name

        // Print the updated queue information
        System.out.println("Visitors in queue after removing the first visitor:");
        ride.printQueue();  // Print the updated queue information
        System.out.println("------------------------------");
    }

    // Part 4A: Collection Class (LinkedList)
    // This method demonstrates how to add a visitor to the ride history, check if a visitor is in the history, and print the history
    public static void partFourA(Ride ride) {
        System.out.println("=== Part 4A: Collection Class (LinkedList) ===");
        System.out.println("Adding visitors to the ride history, checking if a visitor is in the history, and printing the history...");
        ride.addVisitorToHistory(ride.getQueue().peek());  // Add the first visitor from the queue to the ride history
        ride.printRideHistory();  // Print the ride history
        System.out.println("------------------------------");
    }

    // Part 4B: Sorting the Collection
    // This method demonstrates how to sort the history by name
    public static void partFourB(Ride ride) {
        System.out.println("=== Part 4B: Sorting the Collection ===");
        System.out.println("Before sorting:");
        ride.printRideHistory();  // Print the history before sorting
        ride.sortRideHistoryByName();  // Sort the history by visitor name
        System.out.println("After sorting:");
        ride.printRideHistory();  // Print the history after sorting
        System.out.println("------------------------------");
    }

    // Part 5: Run a Ride Cycle
    // This method demonstrates how to run a ride cycle, adding visitors and printing the updated queue and history
    public static void partFive(Ride ride) {
        System.out.println("=== Part 5: Run a Ride Cycle ===");
        System.out.println("Adding visitors to the queue and running the cycle...");
        ride.runOneCycle();  // Run a cycle of the ride
        ride.printQueue();  // Print the queue
        ride.printRideHistory();  // Print the ride history
        System.out.println("------------------------------");
    }

    // Part 6: Writing to a File
    // This method demonstrates how to export the ride history to a CSV file
    public static void partSix(Ride ride) {
        System.out.println("=== Part 6: Writing to a File ===");
        System.out.println("Exporting ride history to CSV file...");
        ride.backupRideHistory();  // Export the history to a CSV file
        System.out.println("------------------------------");
    }

    // Part 7: Reading from a File
    // This method demonstrates how to import the ride history from a CSV file
    public static void partSeven(Ride ride) {
        System.out.println("=== Part 7: Reading from a File ===");
        System.out.println("Importing ride history from CSV file...");
        ride.importRideHistory(ride.getHistoryFileName());  // Import the history using the correct file name
        ride.printRideHistory();  // Print the imported history
        System.out.println("------------------------------");
    }
}














