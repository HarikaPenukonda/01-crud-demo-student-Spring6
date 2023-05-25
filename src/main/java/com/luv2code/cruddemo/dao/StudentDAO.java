package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id); // returns the student

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

}
