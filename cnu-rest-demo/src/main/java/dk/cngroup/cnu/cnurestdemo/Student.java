package dk.cngroup.cnu.cnurestdemo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Student {

    @NotNull
    @Size(min = 2)
    private String name;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
