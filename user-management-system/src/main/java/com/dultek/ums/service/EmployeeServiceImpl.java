package com.dultek.ums.service;

import com.dultek.ums.model.Employee;
import com.dultek.ums.repo.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /**
     * Updates the basic information of an existing employee in the database based on the provided employee ID.
     * If an employee with the given employee ID is found, the fields of the existing employee are updated with
     * the values from the provided employee object, and the updated employee is saved to the database.
     *
     * @param updatedEmployee   The employee object containing the updated information.
     * @param employeeId The employee ID used to identify the existing employee in the database.
     * @return The updated employee if found and updated successfully, or null if no employee with the given
     *         employee ID is found in the database.
     * @throws DataAccessException If an error occurs while accessing the database.
     */
    @Override
    public Employee updateEmployeeBasic(Employee updatedEmployee, String employeeId) {
        // Retrieve the existing employee from the database
        Employee existingEmployee = employeeRepository.findByEmployeeId(employeeId)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found"));

        System.out.println(existingEmployee);
        // Update the relevant fields of the existing employee
        existingEmployee.setFirstName(updatedEmployee.getFirstName());
        existingEmployee.setLastName(updatedEmployee.getLastName());
        existingEmployee.setEmail(updatedEmployee.getEmail());

        // ... update other fields ...

        // Save the updated employee
        return employeeRepository.save(existingEmployee);
    }

}
