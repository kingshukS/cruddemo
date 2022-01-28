package com.kingshuk.springboot.cruddemo.service.impl;

import com.kingshuk.springboot.cruddemo.dao.EmployeeDAO;
import com.kingshuk.springboot.cruddemo.entity.Employee;
import com.kingshuk.springboot.cruddemo.exception.EmployeeNotFoundException;
import com.kingshuk.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Transactional
    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Transactional
    @Override
    public Employee findById(int id) {
        Employee employee = employeeDAO.findById(id);
        if(employee == null){
            throw new EmployeeNotFoundException(id);
        }
        return employee;
    }

    @Transactional
    @Override
    public Employee create(Employee employee) {
        employee.setId(0);
        employeeDAO.save(employee);
        return employee;
    }

    @Transactional
    @Override
    public Employee update(Employee employee) {
        employeeDAO.save(employee);
        return employee;
    }

    @Transactional
    @Override
    public Employee deleteById(int id) {

        Employee employee = employeeDAO.findById(id);
        if(employee == null){
            throw new EmployeeNotFoundException(id);
        }else{
            employeeDAO.deleteById(id);
            return employee;
        }
    }
}
