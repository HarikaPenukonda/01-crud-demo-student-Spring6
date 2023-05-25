package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
			createMultipleStudents(studentDAO);
		};

	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		// Create multiple students
		System.out.println("Creating the Student ...");
		Student tempStudent1 = new Student("Betty","Cooper","cooperb1@luv2code.com");
		Student tempStudent2 = new Student("Jughead","Jones","jonesj1@luv2code.com");
		Student tempStudent3 = new Student("Veronica","Lodge","lodgev1@luv2code.com");
		// save the student objects
		System.out.println("Saving the Student");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}


//	private void createStudent(StudentDAO studentDAO) {
//
//		// create
//		System.out.println("Creating the Student ...");
//		Student tempStudent = new Student("Archie","Andrews","andrewsa1@luv2code.com");
//		// save
//		System.out.println("Saving the Student");
//		studentDAO.save(tempStudent);
//		// display
//		System.out.println("Saved Student.. Generating ID" + tempStudent.getId());
//	}

}
