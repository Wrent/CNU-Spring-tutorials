package dk.cngroup.cnu.cnutestdemo;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class UniversityImplTest {

    private University university;
    private UniversityDAO mockDao;

    private List<Student> students;
    @Before
    public void setUp() throws Exception {
        mockDao = EasyMock.createMock(UniversityDAO.class);
        university = new UniversityImpl(mockDao);

        students = Arrays.asList(new Student("Pepa"), new Student("Karel"));
    }

    @Test
    public void testGetStudents() throws Exception {
        expect(mockDao.getStudents()).andReturn(students).times(1);

        replay(mockDao);

        List<Student> students = university.getStudents();
        assertEquals(students.size(), 2);
        assertTrue(students.get(0).getName().startsWith("Ing."));

        verify(mockDao);
    }

    @Test
    public void testGetStudentPresent() throws Exception {
        expect(mockDao.getStudent(eq("Pepa"))).andReturn(students.get(0));

        replay(mockDao);

        assertEquals("Ing. Pepa", university.getStudent("Pepa").getName());

        verify(mockDao);
    }

    @Test(expected = StudentNotFoundException.class)
    public void testGetStudentNotPresent() throws Exception {
        expect(mockDao.getStudent(eq("Milos"))).andReturn(null);

        replay(mockDao);

        university.getStudent("Milos");

        verify(mockDao);
    }

    @Test
    public void testEnrollStudent() throws Exception {
        expect(mockDao.addStudent(anyObject())).andReturn(new Student("Jitka"));

        replay(mockDao);

        assertEquals("Jitka", university.enroll(new Student("Jitka")).getName());

        verify(mockDao);
    }
}
