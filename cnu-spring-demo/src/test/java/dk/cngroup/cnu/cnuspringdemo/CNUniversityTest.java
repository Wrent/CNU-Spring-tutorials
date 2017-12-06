package dk.cngroup.cnu.cnuspringdemo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CNUniversityTest {

    @Autowired
    private University university;

    @MockBean(name = "expensiveCoffeeMachine")
    private CoffeeMachine machine;


    @Before
    public void setUp() throws Exception {
        university.fireAllStudents();
    }

    @Test
    public void testUniversity() throws Exception {
        university.enroll(new Student("test", "test"));

        verify(machine, times(1)).serveCoffee(Matchers.any());

        List<Student> students = university.getStudents();

        assertThat(students, hasSize(1));
    }
}
