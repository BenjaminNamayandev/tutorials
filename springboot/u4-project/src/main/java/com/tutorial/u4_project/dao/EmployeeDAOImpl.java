package com.tutorial.u4_project.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.tutorial.u4_project.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

/*
This is the implementation of the employee data access object, it dependancy injects the entityManager,
and then uses it to write the SELECT * query, returning a list of employees
*/

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

  private EntityManager entityManager;

  @Autowired
  public EmployeeDAOImpl(EntityManager theEntityManager) {
    this.entityManager = theEntityManager;
  }

  @Override
  public List<Employee> findAll() {
    TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);

    List<Employee> results = query.getResultList();

    return results;
  }

  @Override
  public void deleteById(int id) {
    entityManager.remove(entityManager.find(Employee.class, id)); // remove takes in the actual entity, find it first,
                                                                  // then delete
  }

  @Override
  public Employee findById(int id) {
    return entityManager.find(Employee.class, id); // finds employee by finding the class, and the primary key (id)
  }

  @Override
  public Employee save(Employee employee) {
    Employee dbEmployee = entityManager.merge(employee);

    return dbEmployee;
  }
}
