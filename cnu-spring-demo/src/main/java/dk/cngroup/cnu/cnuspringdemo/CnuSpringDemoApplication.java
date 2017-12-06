package dk.cngroup.cnu.cnuspringdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CnuSpringDemoApplication implements CommandLineRunner {

	private University university;

	public CnuSpringDemoApplication(University university) {
		this.university = university;
	}

	public static void main(String[] args) {
		SpringApplication.run(CnuSpringDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Student bara = new Student("bara", "m");
		Student karolina = new Student("karolina", "m");
		Student dan = new Student("dan", "r");
		university.enroll(bara);
		university.enroll(karolina);
		university.enroll(dan);

		System.out.println(university.getStudents());
	}
}
