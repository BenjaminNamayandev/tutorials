package com.ben.springboot_tutorial.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.ben.springboot_tutorial.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentDAOImpl implements StudentDAO {

  private EntityManager entityManager;

  @Autowired
  public StudentDAOImpl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  @Transactional
  public void save(Student theStudent) {
    entityManager.persist(theStudent);
  }

  @Override
  @Transactional
  public Student findById(int id) {
    Student foundStudent = entityManager.find(Student.class, id);
    return foundStudent;
  }

  @Override
  public List<Student> findAll() {

    TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName DESC", Student.class);
    System.out.printf("TYPED QUERY: %s", theQuery);

    return theQuery.getResultList();
  }

  @Override
  public List<Student> findByLastName(String theLastName) {
    TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName = :data", Student.class);

    theQuery.setParameter("data", theLastName);

    return theQuery.getResultList();
  }

  @Override
  @Transactional
  public void updateStudent(Student student) {
    entityManager.merge(student);
  }

  @Override
  @Transactional
  public void deleteStudent(int id) {
    Student s = entityManager.find(Student.class, id);

    entityManager.remove(s);
  }

  @Override
  @Transactional
  public int deleteAll() {
    int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();

    return numRowsDeleted;
  }
}
