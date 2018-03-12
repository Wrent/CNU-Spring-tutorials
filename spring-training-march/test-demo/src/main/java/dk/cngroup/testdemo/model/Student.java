package dk.cngroup.testdemo.model;

public class Student {
    private long id;
    private String name;
    private int birthYear;

    public Student() {
    }

    public Student(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthYear=" + birthYear +
                '}';
    }
}
