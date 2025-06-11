package com.ben.springboot_tutorial.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.ben.springboot_tutorial.entity.Student;
import jakarta.persistence.EntityManager;

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
}
