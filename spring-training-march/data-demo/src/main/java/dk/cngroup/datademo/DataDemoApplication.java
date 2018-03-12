package dk.cngroup.datademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataDemoApplication implements CommandLineRunner {

	@Autowired
	private StudentRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(DataDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repository.save(new Student("Adam", 1992));
		repository.save(new Student("Walid", 1985));

		System.out.println(repository.findAll());

		System.out.println(repository.findByName("Walid"));
	}
}
