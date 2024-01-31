package com.dultek.ums.service;

import com.dultek.ums.model.*;
import com.dultek.ums.repo.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class EmployeeServiceImplTest {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testSaveEmployee() {
        // Arrange
        Address address = Address.builder()
                .city("Omaha")
                .state("Nebraska")
                .street("123 Main St")
                .zipCode("68111")
                .build();

        Employee employeeToSave = Employee.builder()
                .firstName("John")
                .lastName("Doe")
                .email("johndoe@email.com")
                .address(address)
                .ssn("123-45-6790")
                .build();

        UserRole userRole = new UserRole();
        userRole.setRole(Role.EMPLOYEE);

        UserCredentials userCredentials = UserCredentials.builder()
                .username("doe1")
                .password("password")
                .role(userRole)
                .build();

        // Set associations without creating circular references
        userRole.setEmployee(employeeToSave);
        userCredentials.setEmployee(employeeToSave);

        // Set roles and credentials without circular references
        employeeToSave.setRoles(Collections.singleton(userRole));
        employeeToSave.setCredentials(userCredentials);

        // Act
        Employee savedEmployee = employeeService.saveEmployee(employeeToSave);

        // Assert
        assertNotNull(savedEmployee);
        assertNotNull(savedEmployee.getEmployeeId());
        assertEquals("John", savedEmployee.getFirstName());
        assertEquals("Doe", savedEmployee.getLastName());
        assertEquals(1, savedEmployee.getRoles().size());  // Assuming there is only one role for simplicity

        // Clean up
        // employeeRepository.deleteById(savedEmployee.getEmployeeId());
    }


    @Test
    public void testGetEmployeeById() {
        // Arrange
        Employee employeeToSave = new Employee();
        employeeToSave.setFirstName("Jane");
        employeeToSave.setLastName("Doe");

        Employee savedEmployee = employeeRepository.save(employeeToSave);

        // Act
        Employee retrievedEmployee = employeeService.getEmployeeById(savedEmployee.getEmployeeId());

        // Assert
        assertNotNull(retrievedEmployee);
        assertEquals("Jane", retrievedEmployee.getFirstName());
        assertEquals("Doe", retrievedEmployee.getLastName());
    }

    // Similar tests for getAllEmployees, updateEmployee, deleteEmployeeById
}