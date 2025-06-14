package com.tutorial.u4_project.dao;

import java.util.List;

import com.tutorial.u4_project.entity.Employee;

/*
This code defines the interface for the employee dao, it basically saying that the implementation
of this interface must have a findAll method 
*/

public interface EmployeeDAO {
  List<Employee> findAll();

  void deleteById(int id);

  Employee findById(int id);

  Employee save(Employee employee);
}
