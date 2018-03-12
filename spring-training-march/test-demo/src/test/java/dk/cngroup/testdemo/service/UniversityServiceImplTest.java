package dk.cngroup.testdemo.service;

import dk.cngroup.testdemo.model.Student;
import dk.cngroup.testdemo.repository.StudentRepository;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class UniversityServiceImplTest {
    private UniversityService service;
    private StudentRepository repository;

    private List<Student> students;

    @Before
    public void setUp() throws Exception {
        repository = mock(StudentRepository.class);

        service = new UniversityServiceImpl(repository);

        students = new ArrayList<>();
        students.add(new Student("Adam", 1992));
        students.add(new Student("Walid", 1985));
    }

    @Test
    public void testGetStudents() {
        when(repository.getStudents()).thenReturn(students);

        List<Student> allStudents = service.getAllStudents();
        assertThat(allStudents, hasSize(2));
        assertThat(allStudents.get(0).getName(), is("Adam"));

        verify(repository, times(1)).getStudents();
    }

    @Test
    public void testGetStudentsNoStudentsAvailable() {
        when(repository.getStudents()).thenReturn(new ArrayList<>());

        List<Student> allStudents = service.getAllStudents();
        assertThat(allStudents, hasSize(0));

        verify(repository, times(1)).getStudents();
    }

    @Test
    public void testGetStudentByIdAvailable() {
        when(repository.findById(12)).thenReturn(students.get(0));

        Optional<Student> student = service.findById(12);

        assertTrue(student.isPresent());
        assertThat(student.get().getName(), is("Adam"));

        verify(repository, times(1)).findById(anyLong());
    }

    @Test
    public void testGetStudentByIdNotAvailable() {
        Optional<Student> student = service.findById(15);

        assertFalse(student.isPresent());

        verify(repository, times(1)).findById(anyLong());
    }

    @Test
    public void testEnrollHappyPath() {
        Student tomas = new Student("Tomas", 1955);
        when(repository.save(any(Student.class))).thenReturn(tomas);

        List<Student> anotherList = new ArrayList<>(students);
        anotherList.add(tomas);
        when(repository.getStudents()).thenReturn(anotherList);

        Student student = tomas;

        Student enroll = service.enroll(student);

        assertThat(enroll.getName(), is("Tomas"));
        assertThat(service.getAllStudents(), hasSize(3));
    }
}
