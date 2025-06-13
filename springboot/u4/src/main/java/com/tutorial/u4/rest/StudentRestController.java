package com.tutorial.u4.rest;

import java.util.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.u4.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {

  private List<Student> students = new ArrayList<>();

  @PostConstruct
  public void loadData() {
    Student s1 = new Student("ben", "nam");
    Student s2 = new Student("p", "j");
    Student s3 = new Student("n", "m");

    students.add(s1);
    students.add(s2);
    students.add(s3);
  }

  @GetMapping("/students")
  public List<Student> getStudents() {
    return students;
  }

  // path variable for student
  @GetMapping("/students/{studentId}")
  public Student getStudent(@PathVariable int studentId) {
    return students.get(studentId);
  }
}
