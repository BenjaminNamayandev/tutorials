package com.ben.springboot_tutorial.dao;

import java.util.List;

import com.ben.springboot_tutorial.entity.Student;

public interface StudentDAO {
  public void save(Student theStudent);

  public Student findById(int id);

  public List<Student> findAll();

  public List<Student> findByLastName(String theLastName);

  public void updateStudent(Student student);

  public void deleteStudent(int id);

  public int deleteAll();
}
