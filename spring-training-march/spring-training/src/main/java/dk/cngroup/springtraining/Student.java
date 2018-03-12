package dk.cngroup.springtraining;

public class Student {
    private final String name;
    private final int birthYear;

    private boolean isHappy;

    public Student(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
        this.isHappy = false;
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
                "name='" + name + '\'' +
                ", birthYear=" + birthYear +
                ", isHappy=" + isHappy +
                '}';
    }

    public void makeHappy() {
        isHappy = true;
    }
}
