package com.ben.springboot_tutorial.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {
  // define fields
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "email")
  private String email;

  // define constructors
  public Student(String firstName, String lastName, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  public Student() {
    this.firstName = "N/A";
    this.lastName = "N/A";
    this.email = "N/A";
  }

  // define getters and setters
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  // define toString()
  @Override
  public String toString() {
    return String.format("id: %d name: %s %s, email: %s", id, firstName, lastName, email);
  }

}
