package com.dultek.ums.service;

import com.dultek.ums.EmployeeTestUtils;
import com.dultek.ums.model.Address;
import com.dultek.ums.model.Employee;
import com.dultek.ums.model.User;
import com.dultek.ums.model.UserCredentials;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserOperationServiceImplTest {

    private final UserOperationService userOperationService;

    @Autowired
    public UserOperationServiceImplTest(UserOperationService userOperationService) {
        this.userOperationService = userOperationService;
    }

    @Test
    public void testLogin() {
        assertDoesNotThrow(() -> userOperationService.login());
        // Add more assertions based on the behavior of the login method
    }

    @Test
    public void testLogout() {
        assertDoesNotThrow(() -> userOperationService.logout());
        // Add more assertions based on the behavior of the logout method
    }

    @Test
    public void testResetPassword() {
        //assertDoesNotThrow(() -> userOperationService.resetPassword());
        // Add more assertions based on the behavior of the resetPassword method
    }

    @Test
    public void testUpdateInformation() {
        //assertDoesNotThrow(() -> userOperationService.updateInformation());
        // Add more assertions based on the behavior of the updateInformation method
    }

    @Test
    public void testCreateUser() {
        // Arrange
        Employee validEmployee = EmployeeTestUtils.createValidEmployee();

        // Act
        User user = validEmployee;

        // Assert
        assertNotNull(user);
        userOperationService.createUser(user);
        assertNotNull(user.getId());
        assertEquals(validEmployee.getEmployeeId(), user.getEmployeeId());
        assertEquals(validEmployee.getFirstName(), user.getFirstName());
        assertEquals(validEmployee.getLastName(), user.getLastName());
        assertEquals(validEmployee.getEmail(), user.getEmail());
        assertEquals(validEmployee.getSsn(), user.getSsn());

        // Assert Address
        Address address = user.getAddress();
        assertNotNull(address);
        assertNotNull(address.getId());
        assertEquals(validEmployee.getAddress().getStreet(), address.getStreet());
        assertEquals(validEmployee.getAddress().getCity(), address.getCity());
        assertEquals(validEmployee.getAddress().getState(), address.getState());
        assertEquals(validEmployee.getAddress().getZipCode(), address.getZipCode());

        // Assert UserCredentials
        UserCredentials userCredentials = user.getCredentials();
        assertNotNull(userCredentials);
        assertNotNull(userCredentials.getId());
        assertEquals(validEmployee.getCredentials().getUsername(), userCredentials.getUsername());
        assertEquals(validEmployee.getCredentials().getPassword(), userCredentials.getPassword());
        assertEquals(validEmployee.getCredentials().getRole(), userCredentials.getRole());
    }


    @Test
    public void testUpdateUser() {
        // Arrange
        User user = EmployeeTestUtils.createValidEmployee(); // Create and save a user to update

        // Modify user details
        String updatedFirstName = "UpdatedFirstName";
        user.setFirstName(updatedFirstName);

        // Act
        //userOperationService.updateUser(user);

        // Retrieve the updated user from the database
        User updatedUser = userOperationService.getUserById(user.getId());

        // Assert
        assertNotNull(updatedUser);
        //assertDoesNotThrow(() -> userOperationService.updateUser(user));
        assertEquals(updatedFirstName, updatedUser.getFirstName());
        // Add more assertions based on the changes you expect

        // Add more assertions based on the behavior of the updateUser method
    }

    @Test
    public void testDeleteUser() {
        assertDoesNotThrow(() -> userOperationService.deleteUser(1L)); // Assuming an example user ID
        // Add more assertions based on the behavior of the deleteUser method
    }

    @Test
    public void testGetUserById() {
        Long userId = 1L; // Assuming an example user ID
        //User user = userOperationService.getUserById(userId);
        //assertNotNull(user);
        // Add more assertions based on the behavior of the getUserById method
    }
}
