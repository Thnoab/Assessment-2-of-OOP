package A2;

// The Employee class inherits from the Person class, representing an employee in the theme park system.
// By inheriting from the Person class, the Employee class gains the basic attributes (such as name, age, gender, and ID),
// allowing the employee object to have these basic properties without the need to redefine them.
public class Employee extends Person {
    private String position;    // The position of the employee, e.g., "Ride Operator"
    private double salary;      // The salary of the employee

    // Default constructor: Calls the parent class constructor to initialize the attributes from the Person class
    public Employee() {
        super();  // Calls the default constructor of the parent class (Person)
    }

    // Parameterized constructor: Initializes all employee properties (including inherited properties from Person and employee-specific properties)
    public Employee(String name, int age, String gender, String id, String position, double salary) {
        super(name, age, gender, id);  // Calls the parameterized constructor of the parent class to initialize inherited properties
        this.position = position;       // Sets the employee's position
        this.salary = salary;           // Sets the employee's salary
    }

    // Gets the position
    public String getPosition() {
        return position;  // Returns the employee's position
    }

    // Sets the position
    public void setPosition(String position) {
        this.position = position;  // Sets the employee's position
    }

    // Gets the salary
    public double getSalary() {
        return salary;  // Returns the employee's salary
    }

    // Sets the salary
    public void setSalary(double salary) {
        this.salary = salary;  // Sets the employee's salary
    }
}


