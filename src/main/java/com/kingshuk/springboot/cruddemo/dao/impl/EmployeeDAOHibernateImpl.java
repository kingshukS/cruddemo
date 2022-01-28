package com.kingshuk.springboot.cruddemo.dao.impl;

import com.kingshuk.springboot.cruddemo.dao.EmployeeDAO;
import com.kingshuk.springboot.cruddemo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;


import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOHibernateImpl implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> findAll() {
        List<Employee> employeeList = new ArrayList<>();
        Session session = entityManager.unwrap(Session.class);
        Query<Employee> query = session.createQuery("from Employee",Employee.class);
        employeeList = query.getResultList();
        return employeeList;
    }

    @Override
    public Employee findById(int id) {
        Session session = entityManager.unwrap(Session.class);
        Employee employee = session.get(Employee.class,id);
        return employee;
    }

    @Override
    public void save(Employee employee) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(employee);
    }

    @Override
    public void deleteById(int id) {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("delete from Employee where id=:empId");
        query.setParameter("empId", id);
        query.executeUpdate();
    }
}
