package com.kingshuk.springboot.cruddemo.rest;

import com.kingshuk.springboot.cruddemo.dao.EmployeeDAO;
import com.kingshuk.springboot.cruddemo.entity.Employee;
import com.kingshuk.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> findAllEmployee(){

        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee findEmployee(@PathVariable("id") int id){

        return employeeService.findById(id);
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){

        return employeeService.create(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){

         return employeeService.update(employee);
    }

    @DeleteMapping("/employees/{id}")
    public Employee deleteEmployee(@PathVariable("id") int id){

        return employeeService.deleteById(id);
    }
}
