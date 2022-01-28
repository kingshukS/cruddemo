package com.kingshuk.springboot.cruddemo.service;

import com.kingshuk.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();

    public Employee findById(int id);

    public Employee create(Employee employee);

    public Employee update(Employee employee);

    public Employee deleteById(int id);
}
