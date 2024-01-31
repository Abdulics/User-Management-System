package com.dultek.ums.service;

import com.dultek.ums.EmployeeTestUtils;
import com.dultek.ums.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeServiceImplTest {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeServiceImplTest(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Test
    void updateEmployeeBasic() {
        // Arrange
        Employee employee = EmployeeTestUtils.createSampleEmployeeUpdate();
        String employeeId = "JD1000";

        // Act
        Employee updatedEmployee = employeeService.updateEmployeeBasic(employee, employeeId);
        System.out.println(updatedEmployee);
        // Assert
        assertNotNull(updatedEmployee);
        assertEquals(employee.getFirstName(), updatedEmployee.getFirstName());
        assertEquals(employee.getLastName(), updatedEmployee.getLastName());
        assertEquals(employee.getEmail(), updatedEmployee.getEmail());
        // Add assertions for other fields as needed
    }
}