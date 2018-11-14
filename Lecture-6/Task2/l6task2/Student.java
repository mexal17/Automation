package l6task2;

public class Student {

    private final int id;
    private final String firstName;
    private final String lastName;
    private final int age;

    public Student(int id, String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "id = " + id + ", " + firstName + " " + lastName + ", age = " + age;
    }
}
