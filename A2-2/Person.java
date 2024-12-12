package A2;

public abstract class Person {
    //我这里使用了抽象类，以此方便后续的Employee和Visitor文件中继承和实现其抽象方法。
    private String name;
    private int age;
    private String gender;
    private String id;

    public Person() {
    }

    public Person(String name, int age, String gender, String id) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    //以上便是该系统中的一个人的最基础的属性。
}
