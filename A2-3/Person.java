package A2;

// The abstract class Person defines the basic attributes and behaviors of every individual in the system.
// Using an abstract class allows Employee and Visitor classes to inherit from it and implement their specific logic.
public abstract class Person {
    private String name;    // The name of the person, used for identification or display.
    private int age;        // The age of the person, used for age validation or categorization.
    private String gender;  // The gender of the person, useful for statistics and management.
    private String id;      // The unique identifier, used to distinguish between different Person objects.

    // Default constructor: Allows the creation of an empty object, with properties set later via setter methods.
    public Person() {
    }

    // Parameterized constructor: Initializes the object with all properties set.
    public Person(String name, int age, String gender, String id) {
        this.name = name;  // Initializes the name.
        this.age = age;    // Initializes the age.
        this.gender = gender;  // Initializes the gender.
        this.id = id;      // Initializes the unique identifier.
    }

    // Getter and Setter methods: Provide access and modification of private properties.
    public String getName() {
        return name;  // Returns the name.
    }

    public void setName(String name) {
        this.name = name;  // Sets the name.
    }

    public int getAge() {
        return age;  // Returns the age.
    }

    public void setAge(int age) {
        this.age = age;  // Sets the age.
    }

    public String getGender() {
        return gender;  // Returns the gender.
    }

    public void setGender(String gender) {
        this.gender = gender;  // Sets the gender.
    }

    public String getId() {
        return id;  // Returns the unique identifier.
    }

    public void setId(String id) {
        this.id = id;  // Sets the unique identifier.
    }

    // These are the basic attributes of every individual in the system.
    // Through these attributes, we can define common characteristics for different types of people (such as employees and visitors).
}

