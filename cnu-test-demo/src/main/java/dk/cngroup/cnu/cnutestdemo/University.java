package dk.cngroup.cnu.cnutestdemo;

import java.util.List;

public interface University {
    List<Student> getStudents();
    Student getStudent(String name) throws StudentNotFoundException;
    Student enroll(Student student);
}
