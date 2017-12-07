package dk.cngroup.cnu.cnurestdemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
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
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UniversityControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @MockBean
    private University university;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

        List<Student> students = Arrays.asList(new Student("Roman"), new Student("Petr"));
        when(university.getStudents()).thenReturn(students);
        when(university.getStudent("Roman")).thenReturn(Optional.of(students.get(0)));
        when(university.getStudent("Tomas")).thenReturn(Optional.empty());

        when(university.enrollStudent(any())).thenReturn(new Student("Eva"));
    }

    @Test
    public void testGetAllStudents() throws Exception {
        mockMvc.perform(get("/students"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is("Roman")));
    }

    @Test
    public void testAddStudent() throws Exception {
        Student student = new Student("Eva");

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(student);

        mockMvc.perform(post("/students")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Eva")));
    }

    @Test
    public void testGetStudent() throws Exception {
        mockMvc.perform(get("/students/Roman"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Roman")));

        mockMvc.perform(get("/students/Tomas"))
                .andExpect(status().isNotFound());
    }
}
