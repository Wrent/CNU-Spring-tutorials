package dk.cngroup.testdemo;

import dk.cngroup.testdemo.model.Student;
import dk.cngroup.testdemo.repository.StudentRepository;

import java.util.List;

public class MockRepository implements StudentRepository {
    @Override
    public List<Student> getStudents() {
        return null;
    }

    @Override
    public Student findById(long id) {
        return null;
    }

    @Override
    public Student save(Student student) {
        return null;
    }
}
