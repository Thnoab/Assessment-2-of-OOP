package A2;

// The Visitor class inherits from the Person class, representing a visitor in the theme park.
// It adds visitor-specific properties, such as ticket type and visit date.
public class Visitor extends Person {
    private String ticketType;  // The type of ticket for the visitor, e.g., VIP ticket, regular ticket.
    private String visitDate;   // The date the visitor visits the park.

    // Default constructor: Calls the parent's default constructor and initializes subclass properties.
    public Visitor() {
        super();  // Calls the default constructor of the Person class.
    }

    // Parameterized constructor: Initializes all visitor properties, including both parent and subclass properties.
    public Visitor(String name, int age, String gender, String id, String ticketType, String visitDate) {
        super(name, age, gender, id);  // Calls the constructor of the parent class to set common properties.
        this.ticketType = ticketType;  // Initializes the ticket type.
        this.visitDate = visitDate;    // Initializes the visit date.
    }

    // Getter and Setter methods: Used to access and modify the visitor's ticket type.
    public String getTicketType() {
        return ticketType;  // Returns the ticket type.
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;  // Sets the ticket type.
    }

    // Getter and Setter methods: Used to access and modify the visitor's visit date.
    public String getVisitDate() {
        return visitDate;  // Returns the visit date.
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;  // Sets the visit date.
    }

    // The Visitor class provides additional properties specific to visitors, which are important for managing and analyzing visitor behavior.
}


