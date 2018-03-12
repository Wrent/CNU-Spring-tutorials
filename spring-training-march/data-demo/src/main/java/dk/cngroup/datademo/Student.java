package dk.cngroup.datademo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    @GeneratedValue
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
