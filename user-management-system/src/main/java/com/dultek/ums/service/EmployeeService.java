package com.dultek.ums.service;

import com.dultek.ums.model.Employee;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
    public Employee updateEmployeeBasic(Employee user, String employeeId);

}
