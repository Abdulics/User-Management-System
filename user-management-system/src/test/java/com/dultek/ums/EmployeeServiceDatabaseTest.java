package com.dultek.ums;

import com.dultek.ums.model.Employee;
import com.dultek.ums.service.EmployeeService;
import com.dultek.ums.service.EmployeeTestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class EmployeeServiceDatabaseTest {


    @Autowired
    EmployeeService employeeService;

    @Test
    void testSaveEmployee_ValidData() {

        Employee validEmployee = EmployeeTestUtils.createValidEmployee();

    }

    @Test
    public void testSaveUser_InvalidData() {
        // Create an invalid user
        Employee invalidEmployee = EmployeeTestUtils.createInvalidEmployee();

    }

}

