package dk.cngroup.restdemo.repository;

import dk.cngroup.restdemo.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

    @Query("Select s from Student s where s.name = ?1")
    List<Student> findByName(String name);

    List<Student> getStudents();
}
