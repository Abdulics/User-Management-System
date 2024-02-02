package com.dultek.ums.service;

import com.dultek.ums.exception.*;
import com.dultek.ums.model.Employee;
import com.dultek.ums.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /**
     * Saves an employee to the database.
     *
     * @param employee The employee object to be saved.
     * @return The saved employee with the assigned database-generated ID.
     * @throws DataAccessException If an exception occurs while accessing the data store.
     */
    @Override
    public Employee saveEmployee(Employee employee) {
        try {
            return employeeRepository.save(employee);
        } catch (DataAccessException e) {
            // Handle exceptions related to data access, e.g., database connectivity issues
            throw new DataAccessResourceFailureException("Error occurred while saving employee to the database.", e);
        }
    }


    /**
     * Retrieves an employee from the database based on the provided employee ID.
     * Uses a fetch join to eagerly load associated entities.
     *
     * @param employeeId The unique identifier of the employee to be retrieved.
     * @return The employee with the specified ID.
     * @throws EmployeeNotFoundException If no employee is found with the provided employee ID.
     * @throws DataAccessException If an exception occurs while accessing the data store.
     */
    @Override
    public Employee getEmployeeById(Long employeeId) {
        try {
            // Using a fetch join to load the associated entities eagerly
            return employeeRepository.findEmployeeWithDetailsById(employeeId)
                    .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with ID: " + employeeId));
        } catch (DataAccessException e) {
            // Handle exceptions related to data access, e.g., database connectivity issues
            throw new DataAccessResourceFailureException("Error occurred while retrieving employee from the database.", e);
        }
    }


    /**
     * Retrieves a list of all employees from the database.
     *
     * @return A list containing all employees present in the database.
     * @throws DataAccessException If an exception occurs while accessing the data store.
     */
    @Override
    public List<Employee> getAllEmployees() {
        try {
            return employeeRepository.findAll();
        } catch (DataAccessException e) {
            // Handle exceptions related to data access, e.g., database connectivity issues
            throw new DataAccessResourceFailureException("Error occurred while retrieving employees from the database.", e);
        }
    }


    /**
     * Updates an existing employee's information based on the provided employee object.
     *
     * @param employee The employee object containing the updated information.
     * @return The updated employee after the changes are applied and saved to the database.
     * @throws IllegalArgumentException If the provided employee has a null employee ID.
     * @throws EmployeeNotFoundException If no employee is found in the database with the provided employee ID.
     */
    @Override
    public Employee updateEmployee(Employee employee) {
        // Check if the employee has a valid ID
        if (employee.getEmployeeId() == null) {
            throw new IllegalArgumentException("Employee ID cannot be null for update.");
        }

        // Retrieve the existing employee from the database
        Optional<Employee> existingEmployeeOptional = employeeRepository.findById(employee.getEmployeeId());

        if (existingEmployeeOptional.isPresent()) {
            // Update the existing employee with the new values
            Employee existingEmployee = existingEmployeeOptional.get();
            existingEmployee.setFirstName(employee.getFirstName());
            existingEmployee.setLastName(employee.getLastName());
            existingEmployee.setEmail(employee.getEmail());
            existingEmployee.setSsn(employee.getSsn());

            // Save the updated employee back to the database
            return employeeRepository.save(existingEmployee);
        } else {
            // Handle the case where the employee with the given ID is not found
            throw new EmployeeNotFoundException("Employee not found with ID: " + employee.getEmployeeId());
        }
    }

    /**
     * Deletes an employee from the database based on the provided employee ID.
     *
     * @param employeeId The unique identifier of the employee to be deleted.
     * @throws EmptyResultDataAccessException If no employee is found with the provided ID for deletion.
     *                                      This exception is thrown when attempting to delete a non-existing entity.
     */
    @Override
    public void deleteEmployeeById(Long employeeId) {
        try {
            // Attempt to delete the employee with the given ID
            employeeRepository.deleteById(employeeId);
        } catch (EmptyResultDataAccessException e) {
            // Handle the case where no employee is found with the provided ID
            throw new EmployeeNotFoundException("Employee not found with ID: " + employeeId);
        }
    }

}
