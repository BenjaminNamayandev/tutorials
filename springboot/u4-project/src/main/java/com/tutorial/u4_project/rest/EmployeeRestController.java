package com.tutorial.u4_project.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tutorial.u4_project.entity.Employee;
import com.tutorial.u4_project.service.EmployeeService;

/*
rest controller for the employee services, defines endpoints (/api/*) makes uses of the employee service to have a sort of 
abstaction, instead of just using the dao directly
*/

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

  private EmployeeService employeeService;

  @Autowired
  public EmployeeRestController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @GetMapping("/employees")
  public List<Employee> findAll() {
    return employeeService.findAll();
  }

  @GetMapping("/employees/{id}")
  public Employee getEmployee(@PathVariable int id) {
    Employee employee = employeeService.findById(id);

    if (employee == null) {
      throw new RuntimeException("Employee not found");
    }

    else {
      return employee;
    }
  }

  @PostMapping("/employees")
  public Employee addEmployee(@RequestBody Employee employee) {
    employee.setId(0);

    Employee dbEmployee = employeeService.save(employee);

    return dbEmployee;
  }
}
