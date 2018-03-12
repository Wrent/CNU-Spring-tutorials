package dk.cngroup.restdemo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dk.cngroup.restdemo.model.Student;
import dk.cngroup.restdemo.service.UniversityService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UniversityControllerTest {
    @Autowired
    WebApplicationContext wac;

    MockMvc mockMvc;

    @MockBean
    private UniversityService service;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Martin", 1983));
        students.add(new Student(2, "Jana", 1992));

        when(service.getStudents()).thenReturn(students);
        when(service.getStudentById(1)).thenReturn(Optional.of(students.get(0)));
        when(service.getStudentById(15266)).thenReturn(Optional.empty());
        when(service.enroll(any(Student.class))).thenReturn(new Student(5, "Adam", 1992));
    }

    @Test
    public void testGetStudents() throws Exception {
        mockMvc.perform(get("/students"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is("Martin")));
    }

    @Test
    public void testGetStudentFound() throws Exception {
        mockMvc.perform(get("/students/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Martin")));
    }

    @Test
    public void testGetStudentNotFound() throws Exception {
        mockMvc.perform(get("/students/15266"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testEnrollStudentValid() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Student student = new Student(5, "Adam", 1992);

        String studentJson = objectMapper.writeValueAsString(student);

        mockMvc.perform(post("/students")
                .content(studentJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Adam")));
    }

    @Test
    public void testEnrollStudentInvalid() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Student student = new Student(5, "Adam", 1942);

        String studentJson = objectMapper.writeValueAsString(student);

        mockMvc.perform(post("/students")
                .content(studentJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}
