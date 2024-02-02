package com.dultek.ums.service;

import com.dultek.ums.exception.EmployeeNotFoundException;
import com.dultek.ums.model.*;
import com.dultek.ums.repo.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class EmployeeServiceImplTest {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    Employee employeeToSave;
    private Employee employeeToSave1;
    private Employee employeeToSave2;
    @BeforeEach
    public void setUp() {
        // Create a sample employee before each test case
        employeeToSave = EmployeeTestUtils.createSampleEmployee();
        employeeToSave1 = EmployeeTestUtils.createSampleEmployee();
    }
    @Test
    public void testSaveEmployee() {
        // Act
        Employee savedEmployee = employeeService.saveEmployee(employeeToSave);

        // Assert
        assertNotNull(savedEmployee);
        assertNotNull(savedEmployee.getEmployeeId());
        assertEquals("John", savedEmployee.getFirstName());
        assertEquals("Doe", savedEmployee.getLastName());
        assertEquals(1, savedEmployee.getRoles().size());  // Assuming there is only one role for simplicity

        // Clean up
        cleanUp(savedEmployee.getEmployeeId());
    }

    @Test
    public void testGetEmployeeById() {
        Employee savedEmployee = employeeService.saveEmployee(employeeToSave);
        // Retrieve the employee by ID
        Long employeeId = savedEmployee.getEmployeeId();
        Employee retrievedEmployee = employeeService.getEmployeeById(employeeId);

        // Assert
        assertNotNull(retrievedEmployee);
        assertEquals(employeeId, retrievedEmployee.getEmployeeId());
        assertEquals("John", retrievedEmployee.getFirstName());
        assertEquals("Doe", retrievedEmployee.getLastName());
        assertEquals("johndoe@email.com", retrievedEmployee.getEmail());

        // Assert Address
        Address retrievedAddress = retrievedEmployee.getAddress();
        assertNotNull(retrievedAddress);
        assertEquals("Omaha", retrievedAddress.getCity());
        assertEquals("Nebraska", retrievedAddress.getState());
        assertEquals("123 Main St", retrievedAddress.getStreet());
        assertEquals("68111", retrievedAddress.getZipCode());

        // Assert Roles
        Set<UserRole> retrievedRoles = retrievedEmployee.getRoles();
        assertNotNull(retrievedRoles);
        assertEquals(1, retrievedRoles.size());
        UserRole retrievedUserRole = retrievedRoles.iterator().next();
        assertEquals(Role.EMPLOYEE, retrievedUserRole.getRole());

        // Assert UserCredentials
        UserCredentials retrievedCredentials = retrievedEmployee.getCredentials();
        assertNotNull(retrievedCredentials);
        assertEquals("doe1", retrievedCredentials.getUsername());
        assertEquals("password", retrievedCredentials.getPassword());
        assertEquals(retrievedUserRole, retrievedCredentials.getRole());

        // Clean up
        cleanUp(savedEmployee.getEmployeeId());
    }

    @Test
    public void testGetAllEmployees() {
        // Arrange
        Employee employee1 = employeeToSave;
        Employee employee2 = employeeToSave1;
        Employee savedEmployee1 = employeeService.saveEmployee(employee1);
        Employee savedEmployee2 = employeeService.saveEmployee(employee2);

        // Act
        List<Employee> allEmployees = employeeService.getAllEmployees();
        System.out.println(allEmployees.toString());
        // Assert
        assertNotNull(allEmployees);
        assertFalse(allEmployees.isEmpty());
        assertTrue(allEmployees.contains(savedEmployee1));
        assertTrue(allEmployees.contains(savedEmployee2));

        //Clean up
        cleanUp(savedEmployee1.getEmployeeId());
        cleanUp(savedEmployee2.getEmployeeId());
    }

    @Test
    public void testUpdateEmployee() {
        // Arrange
        Employee employee = employeeToSave;
        Employee savedEmployee = employeeService.saveEmployee(employee);

        // Modify some properties
        savedEmployee.setFirstName("UpdatedFirstName");
        savedEmployee.setLastName("UpdatedLastName");
        savedEmployee.setEmail("UpdatedEmail@email.com");
        savedEmployee.setSsn("000-00-0000");

        // Act
        Employee updatedEmployee = employeeService.updateEmployee(savedEmployee);

        // Assert
        assertNotNull(updatedEmployee);
        assertEquals("UpdatedFirstName", updatedEmployee.getFirstName());
        assertEquals("UpdatedLastName", updatedEmployee.getLastName());
        assertEquals("UpdatedEmail@email.com", updatedEmployee.getEmail());
        assertEquals("000-00-0000", updatedEmployee.getSsn());

        cleanUp(updatedEmployee.getEmployeeId());

    }

    @Test
    public void testDeleteEmployeeById() {
        // Arrange
        Employee employee = EmployeeTestUtils.createSampleEmployee();
        Employee savedEmployee = employeeService.saveEmployee(employee);

        // Act
        employeeService.deleteEmployeeById(savedEmployee.getEmployeeId());

        // Assert
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.getEmployeeById(savedEmployee.getEmployeeId()));
    }
    @Test
    public void cleanUp(Long employeeId) {
        employeeService.deleteEmployeeById(employeeId);
    }
    // Similar tests for getAllEmployees, updateEmployee, deleteEmployeeById
}