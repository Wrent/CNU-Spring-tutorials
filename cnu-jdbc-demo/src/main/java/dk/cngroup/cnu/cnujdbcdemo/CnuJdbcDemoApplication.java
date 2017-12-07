package dk.cngroup.cnu.cnujdbcdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
public class CnuJdbcDemoApplication implements CommandLineRunner {

	private JdbcTemplate jdbcTemplate;
	private StudentsRepository studentsRepository;

	public CnuJdbcDemoApplication(JdbcTemplate jdbcTemplate, StudentsRepository studentsRepository) {
		this.jdbcTemplate = jdbcTemplate;
		this.studentsRepository = studentsRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(CnuJdbcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		studentsRepository.save(new Student(0, "Bara"));
		studentsRepository.save(new Student(1, "Karolina"));
		studentsRepository.save(new Student(2, "Dan"));

		System.out.println(studentsRepository.findAll());

		System.out.println(studentsRepository.findByName("Karolina"));
//		jdbcTemplate.execute("CREATE TABLE Students (id SERIAL PRIMARY KEY , name VARCHAR(255))");
//
//		List<Object[]> data = new ArrayList<>();
//		addObject("Dan", data);
//		addObject("Bara", data);
//		addObject("Karolina", data);
//
//		jdbcTemplate.batchUpdate("INSERT INTO Students(id, name) VALUES(?, ?)", data);
//
//		List<Student> result = jdbcTemplate.query("SELECT * FROM Students WHERE name = ?", new Object[]{"Bara"}, new StudentRowMapper());
//
//		System.out.println(result);
//
//		result = jdbcTemplate.query("SELECT * FROM Students", new Object[]{}, (rs, rowNumber) -> {
//			Long id = rs.getLong("id");
//			String name = rs.getString("name");
//			return new Student(id, name);
//		});
//		System.out.println(result);

	}

	private void addObject(String student, List<Object[]> data) {
		Object[] arr = new Object[2];
		arr[0] = data.size();
		arr[1] = student;
		data.add(arr);
	}

	private class StudentRowMapper implements RowMapper<Student> {
		@Override
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			Long id = rs.getLong("id");
			String name = rs.getString("name");
			return new Student(id, name);
		}
	}
}
