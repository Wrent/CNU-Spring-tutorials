package dk.cngroup.cnu.cnutestdemo;

import java.util.List;

public interface UniversityDAO {
    List<Student> getStudents();

    Student getStudent(String name);

    Student addStudent(Student student);
}
