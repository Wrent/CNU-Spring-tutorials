package dk.cngroup.testdemo.service;

import dk.cngroup.testdemo.model.Student;
import dk.cngroup.testdemo.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

public class UniversityServiceImpl implements UniversityService {
    private final StudentRepository repository;

    public UniversityServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Student> getAllStudents() {
        return repository.getStudents();
    }

    @Override
    public Optional<Student> findById(long id) {
        return Optional.ofNullable(repository.findById(id));
    }

    @Override
    public Student enroll(Student student) {
        return repository.save(student);
    }
}
