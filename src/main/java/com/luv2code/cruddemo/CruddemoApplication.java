package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	// inject StudentDAO
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		// The CommandLineRunner is from the Spring Boot Framework, Executed after the Spring Beans have been loaded
		// Java Lambda Expression
		return runner -> {
			//createStudent(studentDAO);
			//createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//queryForStudent(studentDAO);
			queryForStudentsByLastName(studentDAO);
		};

	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		List<Student> theStudents = studentDAO.findByLastName("Miller");

		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudent(StudentDAO studentDAO) {

		// get a list of students
		List<Student> theStudents = studentDAO.findAll();

		// display the list of students
		for(Student tempStudents : theStudents){
			System.out.println(tempStudents);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		// create a student object
		System.out.println("Creating the Student ...");
		Student tempStudent = new Student("Nick","Miller","millern1@luv2code.com");

		// save the student
		System.out.println("Saving the Student");
		studentDAO.save(tempStudent);

		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved Student... + Generating ID " + theId);

		// retrieve  student based on the id: primary key
		System.out.println("Retrieving the student with id: " +theId);
		Student myStudent = studentDAO.findById(theId);

		// display student
		System.out.println("Found the student " + myStudent);

	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		// Create multiple students
		System.out.println("Creating the Student ...");
		Student tempStudent1 = new Student("Betty","Cooper","cooperb1@luv2code.com");
		Student tempStudent2 = new Student("Jughead","Jones","jonesj1@luv2code.com");
		Student tempStudent3 = new Student("Veronica","Lodge","lodgev1@luv2code.com");
		Student tempStudent = new Student("Archie","Andrews","andrewsa1@luv2code.com");
		// save the student objects
		System.out.println("Saving the Student");
		studentDAO.save(tempStudent);
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}


	private void createStudent(StudentDAO studentDAO) {

		// create
		System.out.println("Creating the Student ...");
		Student tempStudent = new Student("Archie","Andrews","andrewsa1@luv2code.com");
		// save
		System.out.println("Saving the Student");
		studentDAO.save(tempStudent);
		// display
		System.out.println("Saved Student.. Generating ID" + tempStudent.getId());
	}

}
