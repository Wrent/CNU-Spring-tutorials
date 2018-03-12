package dk.cngroup.testdemo.repository;

import dk.cngroup.testdemo.model.Student;

import java.util.List;

public interface StudentRepository {

    List<Student> getStudents();
    Student findById(long id);
    Student save(Student student);
}
