package A2;

public interface RideInterface {
    void addVisitorToQueue(Visitor visitor);          // Add visitor to the queue
    void removeVisitorFromQueue(Visitor visitor);     // Remove visitor from the queue
    void printQueue();                                // Print the current queue of visitors
    void runOneCycle();                               // Run one cycle of the ride
    void addVisitorToHistory(Visitor visitor);        // Add visitor to the ride history
    boolean checkVisitorFromHistory(Visitor visitor); // Check if the visitor has ridden the ride before
    int numberOfVisitors();                           // Return the number of visitors who have ridden the ride
    void printRideHistory();                          // Print the ride history
    void backupRideHistory();                         // Backup the ride history to a file
}

// The RideInterface is an interface for the ride, providing standardized methods for all types of ride classes.
// Through the interface, the system achieves consistency, polymorphism, and extensibility in functionality.
// The interface ensures that the core operations of the system (such as queuing, ride operations, history records, etc.)
// remain consistent, even if the specific ride types change, and new types of rides can be easily added.

