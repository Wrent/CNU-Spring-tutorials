package dk.cngroup.restdemo.controller;

import dk.cngroup.restdemo.exception.StudentTooOldException;
import dk.cngroup.restdemo.model.Student;
import dk.cngroup.restdemo.service.UniversityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class UniversityController {
    private final UniversityService service;

    public UniversityController(UniversityService service) {
        this.service = service;
    }

    @RequestMapping(path = "/students", method = RequestMethod.GET)
    List<Student> getStudents() {
        return service.getStudents();
    }

    @RequestMapping(path = "/students/{id}", method = RequestMethod.GET)
    ResponseEntity<Student> getStudentById(@PathVariable("id") int id) {
        Optional<Student> studentById = service.getStudentById(id);
        if (studentById.isPresent()) {
            return ResponseEntity.ok(studentById.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(path = "/students", method = RequestMethod.POST)
    ResponseEntity<Student> enrollStudent(@RequestBody @Valid Student student) {
        try {
            return ResponseEntity.ok(service.enroll(student));
        } catch (StudentTooOldException e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
