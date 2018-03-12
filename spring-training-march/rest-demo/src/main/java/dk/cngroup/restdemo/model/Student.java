package dk.cngroup.restdemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Student {
    private long id;
    @NotNull
    @Size(min = 2)
    private String name;
    @Min(1950)
    private int birthYear;

    public Student() {
    }

    public Student(long id, String name, int year) {
        this.id = id;
        this.name = name;
        this.birthYear = year;
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

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }
}
