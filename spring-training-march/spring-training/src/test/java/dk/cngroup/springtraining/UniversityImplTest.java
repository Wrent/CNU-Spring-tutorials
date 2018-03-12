package dk.cngroup.springtraining;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

public class UniversityImplTest {

    private University university = new UniversityImpl(new CheapCoffeeMachine());

    @Before
    public void setUp() throws Exception {
        university.fireAll();
    }

    @Test
    public void testEnroll() {
        assertThat(university.getStudents(), hasSize(0));

        Student student = new Student("Petr", 1593);
        university.enroll(student);

        assertThat(university.getStudents(), hasSize(1));
    }
}
