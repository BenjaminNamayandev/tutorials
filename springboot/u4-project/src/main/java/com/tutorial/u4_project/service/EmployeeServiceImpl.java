package com.tutorial.u4_project.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tutorial.u4_project.dao.EmployeeDAO;
import com.tutorial.u4_project.entity.Employee;

/*
injects the employeeDAO, and makes use of the methods defined there, basically this injects the DAO,
which injects the entityManger, which then queries the DB.
*/

@Service
public class EmployeeServiceImpl implements EmployeeService {

  private EmployeeDAO employeeDAO;

  @Autowired
  public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }

  @Override
  public List<Employee> findAll() {
    return employeeDAO.findAll();
  }

  @Override // only use @Transactional when moding the db
  public Employee findById(int id) {
    return employeeDAO.findById(id);
  }

  @Transactional
  @Override
  public void deleteById(int id) {
    employeeDAO.deleteById(id);
  }

  @Transactional
  @Override
  public Employee save(Employee employee) {
    return employeeDAO.save(employee);
  }
}
