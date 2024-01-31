package com.dultek.ums.service;

import com.dultek.ums.model.Address;
import com.dultek.ums.model.User;

import com.dultek.ums.model.UserCredentials;
import com.dultek.ums.repo.AddressRepository;
import com.dultek.ums.repo.UserCredentialsRepository;
import com.dultek.ums.repo.UserOperationServiceRepository;
import com.dultek.ums.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserOperationServiceRepository userOperationServiceRepository;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    UserCredentialsRepository userCredentialsRepository;

    /**
     * Saves a user to the database after validating the user details.
     *
     * @param user The user to be saved.
     * @throws IllegalArgumentException If the user details are invalid.
     */
    public void saveUser(User user) {
        // Check if the user details are valid using the UserValidator
        if (UserValidator.isValidUser(user)) {
            // Save the user to the database
            userOperationServiceRepository.save(user);
            // Update associated entities with the generated employee ID
            String employeeId = user.getEmployeeId();
            updateAssociatedEntities(user, employeeId);
        } else {
            // Throw an exception if the user details are invalid
            throw new IllegalArgumentException("Invalid user details");
        }
    }
    /**
     * Updates associated entities (Address and UserCredentials) with the given user and employee ID.
     * Sets the user reference in Address and UserCredentials and saves them to the repository.
     *
     * @param user       The user entity containing associated entities to be updated.
     * @param employeeId The employee ID used for updating associated entities.
     */
    private void updateAssociatedEntities(User user, String employeeId) {
        // Update Address entity
        Address address = user.getAddress();
        if (address != null) {
            // Set the user reference in Address
            address.setUser(user);
            // Save the updated Address to the repository
            addressRepository.save(address);
        }

        // Update UserCredentials entity
        UserCredentials userCredentials = user.getCredentials();
        if (userCredentials != null) {
            // Set the user reference in UserCredentials
            userCredentials.setUser(user);
            // Save the updated UserCredentials to the repository
            userCredentialsRepository.save(userCredentials);
        }
    }


}
