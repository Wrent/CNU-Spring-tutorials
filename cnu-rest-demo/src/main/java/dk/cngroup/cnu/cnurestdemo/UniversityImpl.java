package dk.cngroup.cnu.cnurestdemo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UniversityImpl implements University {

    private final List<Student> students;

    public UniversityImpl() {
        this.students = new ArrayList<>();
        students.add(new Student("Dan"));
        students.add(new Student("Bara"));
        students.add(new Student("Karolina"));
    }

    @Override
    public List<Student> getStudents() {
        return students;
    }

    @Override
    public Optional<Student> getStudent(String name) {
        for (Student student : students) {
            if (student.getName().equals(name)) {
                return Optional.of(student);
            }
        }
        return Optional.empty();

        //        return students.stream()
//                .filter(student -> student.getName().equals(name))
//                .findFirst();
    }

    @Override
    public Student enrollStudent(Student student) {
        students.add(student);
        return student;
    }
}
