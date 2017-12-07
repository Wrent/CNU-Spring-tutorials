package dk.cngroup.cnu.cnutestdemo;

import java.util.ArrayList;
import java.util.List;

public class UniversityImpl implements University {

    private final UniversityDAO dao;

    public UniversityImpl(UniversityDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<Student> getStudents() {
        List<Student> students = dao.getStudents();
        List<Student> engineers = new ArrayList<>();

        for (Student s : students) {
            engineers.add(addIng(s));
        }
        return engineers;
    }

    private Student addIng(Student s) {
        return new Student("Ing. " + s.getName());
    }

    @Override
    public Student getStudent(String name) throws StudentNotFoundException {
        Student student = dao.getStudent(name);

        if (student == null) {
            throw new StudentNotFoundException();
        }
        return addIng(student);
    }

    @Override
    public Student enroll(Student student) {
       return dao.addStudent(student);
    }
}
