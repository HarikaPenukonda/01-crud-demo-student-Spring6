package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
   //@Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent); // saves the student
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        // create query
        //TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class); // Default: sort ascending

        // return query results
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {

        // create a query
        // JPQL Named parameters are prefixed with a colon :, Think of this as placeholder that is filled in later
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student where lastName=:theData", Student.class);

        // set query parameters
        theQuery.setParameter("theData",theLastName);

        // return query results
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }


}

