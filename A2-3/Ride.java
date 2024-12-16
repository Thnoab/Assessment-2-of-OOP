package A2;

import java.io.*;
import java.util.*;

/**
 * The Ride class represents a ride in the theme park, including details such as the ride's name,
 * its maximum capacity, the ride operator, the queue of visitors waiting for the ride, and the
 * ride's history of visitors. It implements the RideInterface to manage the functionality of
 * adding visitors to the queue, running a cycle, managing the ride history, and backing up
 * the ride history to a CSV file.
 */
public class Ride implements RideInterface {
    private String rideName;              // The name of the ride, used for identification.
    private int maxRiders;                // The maximum number of riders the ride can accommodate per cycle.
    private Employee operator;            // The employee operating the ride.
    private Queue<Visitor> queue;         // The queue of visitors waiting to take the ride.
    private LinkedList<Visitor> rideHistory;  // A record of visitors who have taken the ride.
    private String historyFileName;       // The name of the CSV file used to back up the ride history.

    // Constructor to create a new Ride object.
    public Ride(String rideName, int maxRiders) {
        this.rideName = rideName;  // Initializes the name of the ride.
        this.maxRiders = maxRiders;  // Initializes the maximum riders.
        this.queue = new LinkedList<>();  // Initializes the queue for visitors.
        this.rideHistory = new LinkedList<>();  // Initializes the ride history.
        this.historyFileName = rideName.replace(" ", "") + "_History.csv";  // Generates a file name based on the ride's name.
    }

    // Assigns an operator to the ride.
    public void assignOperator(Employee operator) {
        this.operator = operator;
        System.out.println(operator.getName() + " is now the operator of " + rideName);
    }

    // Adds a visitor to the queue for the ride.
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        queue.offer(visitor);
        System.out.println(visitor.getName() + " added to the queue.");
    }

    // Removes a visitor from the queue.
    @Override
    public void removeVisitorFromQueue(Visitor visitor) {
        if (queue.remove(visitor)) {
            System.out.println(visitor.getName() + " removed from the queue.");
        } else {
            System.out.println("Visitor not found in the queue.");
        }
    }

    // Prints the current list of visitors in the queue.
    @Override
    public void printQueue() {
        if (queue.isEmpty()) {
            System.out.println("No visitors in the queue for " + rideName + ".");
            return;
        }

        System.out.println("Visitors in queue for " + rideName + ": ");
        for (Visitor v : queue) {
            System.out.println("Name: " + v.getName() + ", Age: " + v.getAge() + ", Gender: " + v.getGender() + ", ID: " + v.getId());
        }

        if (operator != null) {
            System.out.println("Operator: " + operator.getName() + ", Position: " + operator.getPosition() + ", ID: " + operator.getId());
        } else {
            System.out.println("No operator assigned.");
        }
    }

    // Runs the ride for one cycle, allowing the maximum number of riders to board the ride.
    @Override
    public void runOneCycle() {
        if (operator == null) {
            System.out.println("No operator assigned to the ride.");
            return;
        }

        if (queue.isEmpty()) {
            System.out.println("No visitors in the queue. Ride will not run.");
            return;
        }

        int cycleCount = Math.min(queue.size(), maxRiders);  // Limits the number of riders based on maxRiders.
        for (int i = 0; i < cycleCount; i++) {
            Visitor v = queue.poll();  // Removes the visitor from the queue.
            if (!rideHistory.contains(v)) {  // Ensures no duplicate history entries.
                rideHistory.add(v);  // Adds the visitor to the ride history.
            }
            System.out.println(v.getName() + " is riding the " + rideName);
        }

        // Backs up the ride history after the cycle.
        backupRideHistory();
    }

    // Adds a visitor to the ride history.
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (!rideHistory.contains(visitor)) {  // Ensures no duplicate history entries.
            rideHistory.add(visitor);
        }
    }

    // Checks if a visitor is in the ride history.
    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        return rideHistory.contains(visitor);
    }

    // Returns the number of visitors who have taken the ride.
    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }

    // Prints the ride history, displaying all visitors who have ridden the ride.
    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("No visitors have taken the ride yet.");
            return;
        }

        System.out.println("Ride history for " + rideName + ": ");
        for (Visitor v : rideHistory) {
            System.out.println(v.getName());
        }
    }

    // Backs up the ride history to a CSV file. If the file does not exist, it is created.
    @Override
    public void backupRideHistory() {
        try {
            File file = new File(historyFileName);

            // If the file doesn't exist, create a new one and write the header.
            if (!file.exists()) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(historyFileName))) {
                    writer.append("Name,Age,Gender,ID\n");  // Writes the header to the CSV file.
                    System.out.println("Created new file: " + historyFileName);
                }
            }

            // Appends the ride history to the existing CSV file.
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(historyFileName, true))) {
                for (Visitor v : rideHistory) {
                    writer.append(v.getName() + "," + v.getAge() + "," + v.getGender() + "," + v.getId() + "\n");
                }
                System.out.println("Ride history appended to " + historyFileName);
            }
        } catch (IOException e) {
            System.out.println("Error while backing up ride history: " + e.getMessage());
        }
    }

    // Imports ride history from a CSV file and adds the visitors to the ride history.
    public void importRideHistory(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("File not found: " + fileName);
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            reader.readLine();  // Skips the header row.

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                String gender = data[2];
                String id = data[3];

                // Creates a visitor object and adds it to the ride history.
                Visitor visitor = new Visitor(name, age, gender, id, "", "");
                if (!rideHistory.contains(visitor)) {  // Ensures no duplicate history entries.
                    rideHistory.add(visitor);
                }
            }

            System.out.println("Ride history imported from " + fileName);
        } catch (IOException e) {
            System.out.println("Error while importing ride history: " + e.getMessage());
        }
    }

    // Provides a string representation of the ride, including its name, max capacity, and operator.
    @Override
    public String toString() {
        return "Ride: " + rideName + ", Max Riders: " + maxRiders + ", Operator: " + (operator != null ? operator.getName() : "None");
    }

    // Compares two Ride objects for equality, checking if their names and max riders are the same.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Ride ride = (Ride) obj;
        return maxRiders == ride.maxRiders && rideName.equals(ride.rideName);
    }

    // Returns the hash code for this Ride object based on its name and max capacity.
    @Override
    public int hashCode() {
        return Objects.hash(rideName, maxRiders);
    }

    // Sorts the ride history by visitor name in alphabetical order.
    public void sortRideHistoryByName() {
        Collections.sort(rideHistory, new VisitorComparator());  // Uses a custom comparator to sort by name.
        System.out.println("Ride history sorted by visitor name.");
    }

    // Provides a public method to access the queue.
    public Queue<Visitor> getQueue() {
        return queue;
    }

    // Provides a public method to access the ride history.
    public LinkedList<Visitor> getRideHistory() {
        return rideHistory;
    }

    // Provides a public method to access the history file name.
    public String getHistoryFileName() {
        return historyFileName;
    }
}

















