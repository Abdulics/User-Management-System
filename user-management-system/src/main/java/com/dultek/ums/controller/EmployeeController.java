package com.dultek.ums.controller;

import com.dultek.ums.model.Employee;
import com.dultek.ums.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employees/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

//    @GetMapping("/{employeeId}")
//    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long employeeId) {
//        Employee employee = employeeService.getEmployeeById(employeeId);
//        return new ResponseEntity<>(employee, HttpStatus.OK);
//    }

    @GetMapping("/list")
    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        System.out.println("list called:");
        System.out.println(employees.toString());
         //new ResponseEntity<>(employees, HttpStatus.OK);
        return employees;
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long employeeId, @RequestBody Employee employee) {
        employee.setEmployeeId(employeeId);
        Employee updatedEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable Long employeeId) {
        employeeService.deleteEmployeeById(employeeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

