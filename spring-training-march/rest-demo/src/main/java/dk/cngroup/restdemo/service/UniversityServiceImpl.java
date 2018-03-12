package dk.cngroup.restdemo.service;

import dk.cngroup.restdemo.exception.StudentTooOldException;
import dk.cngroup.restdemo.model.Student;
import dk.cngroup.restdemo.repository.StudentRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UniversityServiceImpl implements UniversityService {
    private final StudentRepository repository;

    public UniversityServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Student> getStudents() {
        return repository.getStudents();
    }

    @Override
    public Optional<Student> getStudentById(long id) {
        return repository.findById(id);

//        for (Student student : students) {
//            if (student.getId() == id) {
//                return Optional.of(student);
//            }
//        }
//        return Optional.empty();
    }

    @Override
    public Student enroll(Student student) throws StudentTooOldException {
        validateStudent(student);

        student.setId(repository.count());
        repository.save(student);
        return student;
    }

    private void validateStudent(Student student) throws StudentTooOldException {
        if (student.getBirthYear() < 1950) {
            throw new StudentTooOldException();
        }

        if (student.getName() == null) {
            throw new StudentTooOldException();
        }

        if (student.getName().length() < 2) {
            throw new StudentTooOldException();
        }
    }
}
