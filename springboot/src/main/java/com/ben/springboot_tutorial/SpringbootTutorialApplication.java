package com.ben.springboot_tutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ben.springboot_tutorial.dao.StudentDAO;
import com.ben.springboot_tutorial.entity.Student;

import java.util.List;

import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class SpringbootTutorialApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringbootTutorialApplication.class, args);
  }

  @Bean
  public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
    return runner -> {
      // createStudent(studentDAO);
      // createMultiStudent(studentDAO);
      // readStudent(studentDAO);
      // queryForStudents(studentDAO);
      queryForStudentsByLastName(studentDAO);
    };
  }

  private void createStudent(StudentDAO studentDAO) {
    System.out.println("CREATING NEW STUDENT OBJ");
    Student tempStudent = new Student("Ben", "Doe", "hello@world.com");

    System.out.println("SAVING THE STUDENT");
    studentDAO.save(tempStudent);

    System.out.printf("ID OF THE STUDENT: %d\n", tempStudent.getId());
  }

  private void createMultiStudent(StudentDAO studentDAO) {
    Student student1 = new Student("Manny", "Heffley", "evil@brother.com");
    Student student2 = new Student("Brock", "Lesner", "brocklesner@yahoo.com");
    Student student3 = new Student("Obama", "Care", "obamac@whitehouse.com");

    studentDAO.save(student1);
    studentDAO.save(student2);
    studentDAO.save(student3);
  }

  private void readStudent(StudentDAO studentDAO) {
    Student student4 = new Student("Daffy", "Duck", "daffy@duck.com");

    studentDAO.save(student4);

    System.out.println(student4.getId());

    Student myStudent = studentDAO.findById(student4.getId());

    System.out.println(myStudent);
  }

  private void queryForStudents(StudentDAO studentDAO) {
    for (Student s : studentDAO.findAll()) {
      System.out.println(s);
    }
  }

  private void queryForStudentsByLastName(StudentDAO studentDAO) {
    List<Student> theStudents = studentDAO.findByLastName("Doe");
    System.out.println(theStudents);
  }
}
