package dk.cngroup.cnu.cnuspringdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CNUniversity implements University {
    private List<Student> students = new ArrayList<>();
    private Tutor tutor;
    @Autowired
    @Qualifier("expensiveCoffeeMachine")
    private CoffeeMachine coffeeMachine;

    @Value("${cnuniversity.length}")
    private int length;

    public CNUniversity(Tutor tutor) {
        this.tutor = tutor;
    }

    @Override
    public void enroll(Student student) {
        System.out.println("New student " + student.getFirstName() + " is here to learn " + tutor.getKnowledge());
        students.add(student);
        coffeeMachine.serveCoffee(student);
        System.out.println("Student will be here for "+ length + " years.");
    }

    @Override
    public List<Student> getStudents() {
        return students;
    }

    @Override
    public void fireAllStudents() {
        students.clear();
    }
}
