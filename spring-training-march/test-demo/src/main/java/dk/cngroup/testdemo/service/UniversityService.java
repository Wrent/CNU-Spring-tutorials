package dk.cngroup.testdemo.service;

import dk.cngroup.testdemo.model.Student;

import java.util.List;
import java.util.Optional;

public interface UniversityService {
    List<Student> getAllStudents();

    Optional<Student> findById(long id);

    Student enroll(Student student);
}
