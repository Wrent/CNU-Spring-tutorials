package dk.cngroup.cnu.cnuspringdemo;

public class Student {
    private final String firstName;
    private final String lastName;
    private boolean happy = false;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public boolean isHappy() {
        return happy;
    }

    public void makeHappy() {
        happy = true;
    }
}
