package l8task3;

public class Student {
    private int id;
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String phoneNumber;
    private final String email;

    public Student(int id, String firstName, String lastName, int age, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.email = email;
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
        return " | " + firstName + " " + lastName + ", age = " + age + ", id = " + id + ", phoneNumber = "+ phoneNumber+", email = "+email;
    }
}

