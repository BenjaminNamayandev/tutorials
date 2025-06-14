package com.tutorial.u4_project.service;

import java.util.List;
import com.tutorial.u4_project.entity.Employee;

/*
Same idea as the dao interface, says that any implementation of this service needs the method to findAll Employees
*/

public interface EmployeeService {
  List<Employee> findAll();

  void deleteById(int id);

  Employee findById(int id);

  Employee save(Employee employee);
}
