package dk.cngroup.springtraining;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UniversityImpl implements University {
    private final List<Student> students;
    private final CoffeeMachine coffeeMachine;

    @Value("${university.name}")
    private String name;

    public UniversityImpl(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
        this.students = new ArrayList<>();
    }

    @Override
    public List<Student> getStudents() {
        System.out.println("getting "+ name);
        return students;
    }

    @Override
    public void enroll(Student student) {
        students.add(student);
        coffeeMachine.serveCoffee(student);
    }

    @Override
    public void fireAll() {
        students.clear();
    }
}
