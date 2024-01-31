package com.dultek.ums.service;

import com.dultek.ums.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    Employee getEmployeeById(Long employeeId);
    List<Employee> getAllEmployees();
    Employee updateEmployee(Employee employee);
    void deleteEmployeeById(Long employeeId);
}

