package com.tutorial.u4_project.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
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
  private ObjectMapper objectMapper;

  @Autowired
  public EmployeeRestController(EmployeeService employeeService, ObjectMapper objectMapper) {
    this.employeeService = employeeService;
    this.objectMapper = objectMapper;
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

  @PutMapping("/employees")
  public Employee save(@RequestBody Employee employee) {
    return employeeService.save(employee);
  }

  @DeleteMapping("/employees/{id}")
  public void deleteEmployee(@PathVariable int id) {
    employeeService.deleteById(id);
  }

  @PatchMapping("/employees/{id}")
  public Employee patchEmployee(@PathVariable int id, @RequestBody Map<String, Object> patchPayload) {
    Employee employee = employeeService.findById(id);

    // throw err if employee not found
    if (employee == null) {
      throw new RuntimeException("Emplpyee not found in database");
    }

    // throw err if user tries to change id (primary keys shouldn't be editted)
    if (patchPayload.containsKey("id")) {
      throw new RuntimeException("Cannot patch employee id, as it is a primary key");
    }

    Employee patchEmployee = apply(patchPayload, employee);

    Employee dbEmployee = employeeService.save(patchEmployee);

    return dbEmployee;
  }

  private Employee apply(Map<String, Object> patchPayload, Employee employee) {
    // covert employee to json object node
    ObjectNode employeeNode = objectMapper.convertValue(employee, ObjectNode.class);
    // convert patch payload to json object node
    ObjectNode patchPayloadNode = objectMapper.convertValue(patchPayload, ObjectNode.class);
    // return merged object
    employeeNode.setAll(patchPayloadNode);

    return objectMapper.convertValue(employeeNode, Employee.class); // conver it back to an employee classtype.
                                                                    // Essentially, it does operations in json, and we
                                                                    // return the employee object
  }
}
