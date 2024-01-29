package com.dultek.ums;

import com.dultek.ums.model.Employee;
import com.dultek.ums.model.User;
import com.dultek.ums.repo.UserRepository;
import com.dultek.ums.service.UserService;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class UserServiceDatabaseTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    void testSaveEmployee_ValidData() {
        // Create a valid employee using the utility class
        Employee validEmployee = EmployeeTestUtils.createValidEmployee();
        User user = validEmployee;
        // Call the service method to save the employee
        userService.saveUser(user);

        // Retrieve the saved employee from the database
        Optional<User> savedEmployee = userRepository.findById(String.valueOf(validEmployee.getId()));

        // Assertions on the saved employee's properties
        assertTrue(((Optional<?>) savedEmployee).isPresent());
        assertEquals(validEmployee.getEmployeeId(), savedEmployee.get().getEmployeeId());
        // Add more assertions based on your implementation
    }

    @Test
    public void testSaveUser_InvalidData() {
        // Create an invalid user
        Employee invalidEmployee = EmployeeTestUtils.createInvalidEmployee();
        User invalidUser = invalidEmployee;

        // Call the method to be tested and expect an exception
        assertThrows(ConstraintViolationException.class, () -> userService.saveUser(invalidUser));

        // Verify that userRepository.save was not called (since it's an in-memory database)
        assertEquals(0, userRepository.count());
    }


}

