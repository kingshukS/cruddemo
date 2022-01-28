package com.kingshuk.springboot.cruddemo.dao.impl;

import com.kingshuk.springboot.cruddemo.dao.EmployeeDAO;
import com.kingshuk.springboot.cruddemo.entity.Employee;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOJpaImpl implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> findAll() {
        List<Employee> employeeList = new ArrayList<>();
        TypedQuery<Employee> query = entityManager.createQuery("from Employee",Employee.class);
        employeeList = query.getResultList();
        return employeeList;
    }

    @Override
    public Employee findById(int id) {
        Employee employee = entityManager.find(Employee.class,id);
        return employee;
    }

    @Override
    public void save(Employee employee) {
       Employee dbEmployee = entityManager.merge(employee);
       employee.setId(dbEmployee.getId());
    }

    @Override
    public void deleteById(int id) {
        Query query = entityManager.createQuery("delete from Employee where id=:empId");
        query.setParameter("empId", id);
        query.executeUpdate();
    }
}
