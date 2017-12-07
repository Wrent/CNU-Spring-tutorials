package dk.cngroup.cnu.cnurestdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class UniversityController {

    private final University university;

    public UniversityController(University university) {
        this.university = university;
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public List<Student> getStudents() {
        return university.getStudents();
    }

    @RequestMapping(value = "/students/{name}", method = RequestMethod.GET)
    public ResponseEntity<Student> getStudent(@PathVariable("name") String name) {
        Optional<Student> student = university.getStudent(name);
        if (student.isPresent()) {
            return ResponseEntity.ok(student.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public Student addStudent(@Valid @RequestBody Student student) {
        return university.enrollStudent(student);
    }
}
