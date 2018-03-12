package dk.cngroup.springtraining;

import java.util.List;

public interface University {
    List<Student> getStudents();
    void enroll(Student student);

    void fireAll();
}
