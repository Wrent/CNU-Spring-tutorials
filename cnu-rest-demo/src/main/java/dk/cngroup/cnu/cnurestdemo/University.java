package dk.cngroup.cnu.cnurestdemo;

import java.util.List;
import java.util.Optional;

public interface University {

    List<Student> getStudents();
    Optional<Student> getStudent(String name);
    Student enrollStudent(Student student);
}
