package com.dultek.ums.service;

import com.dultek.ums.model.Employee;
import com.dultek.ums.repo.AddressRepository;
import com.dultek.ums.repo.EmployeeRepository;
import com.dultek.ums.repo.UserCredentialsRepository;
import com.dultek.ums.repo.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private AddressRepository addressRepository;
    private UserRoleRepository userRoleRepository;
    private UserCredentialsRepository userCredentialsRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository,
                               AddressRepository addressRepository,
                               UserRoleRepository userRoleRepository,
                               UserCredentialsRepository userCredentialsRepository) {
        this.employeeRepository = employeeRepository;
        this.addressRepository = addressRepository;
        this.userRoleRepository = userRoleRepository;
        this.userCredentialsRepository = userCredentialsRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long employeeId) {
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return null;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return null;
    }

    @Override
    public void deleteEmployeeById(Long employeeId) {

    }
}
