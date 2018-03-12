package dk.cngroup.restdemo.service;

import dk.cngroup.restdemo.exception.StudentTooOldException;
import dk.cngroup.restdemo.model.Student;

import java.util.List;
import java.util.Optional;

public interface UniversityService {
    List<Student> getStudents();
    Optional<Student> getStudentById(long id);
    Student enroll(Student student) throws StudentTooOldException;
}
