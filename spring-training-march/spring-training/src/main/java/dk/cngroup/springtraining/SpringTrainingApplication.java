package dk.cngroup.springtraining;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringTrainingApplication implements CommandLineRunner {

	@Autowired
	private University university;

	public static void main(String[] args) {
		SpringApplication.run(SpringTrainingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello world");

		university.enroll(new Student("Walid", 1985));
		university.enroll(new Student("Adam", 1992));

		System.out.println(university.getStudents());
	}
}
