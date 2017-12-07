package dk.cngroup.cnu.cnujdbcdemo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;


@Repository
public interface StudentsRepository extends CrudRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE s.name = ?1")
    Student findByName(String name);
}
