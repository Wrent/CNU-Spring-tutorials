package dk.cngroup.cnu.cnuspringdemo;

import java.util.List;

public interface University {
    void enroll(Student student);
    List<Student> getStudents();

    void fireAllStudents();
}
