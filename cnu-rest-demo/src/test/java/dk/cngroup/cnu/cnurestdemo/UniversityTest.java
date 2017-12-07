package dk.cngroup.cnu.cnurestdemo;


import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UniversityTest {

    private University university;

    @Before
    public void setUp() throws Exception {
        university = new UniversityImpl();
    }

    @Test
    public void testGetStudents() throws Exception {
        List<Student> students = university.getStudents();
        assertThat(students, hasSize(3));
    }

    @Test
    public void testGetStudent() throws Exception {
        assertTrue(university.getStudent("Bara").isPresent());
        assertFalse(university.getStudent("Adam").isPresent());
    }

    @Test
    public void testEnrollStudent() throws Exception {
        Student student = university.enrollStudent(new Student("Krystof"));
        assertThat(student.getName(), is("Krystof"));
        assertThat(university.getStudents(), hasSize(4));
    }
}
