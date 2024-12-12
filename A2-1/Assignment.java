package A2;

public class Assignment {
    public static void main(String[] args) {
        Employee operator = new Employee("Alice", 30, "Female", "E123", "Ride Operator", 3000);
        Visitor visitor1 = new Visitor("Bob", 25, "Male", "V001", "VIP", "2024-11-26");
        Visitor visitor2 = new Visitor("Charlie", 28, "Male", "V002", "Standard", "2024-11-26");

        Ride rollerCoaster = new Ride("Roller Coaster", 3);
        rollerCoaster.assignOperator(operator);

        rollerCoaster.addVisitorToQueue(visitor1);
        rollerCoaster.addVisitorToQueue(visitor2);

        rollerCoaster.printQueue();
        rollerCoaster.runOneCycle();
        rollerCoaster.printQueue();
    }
}

