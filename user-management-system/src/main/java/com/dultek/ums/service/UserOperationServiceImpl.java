package com.dultek.ums.service;

import com.dultek.ums.model.Address;
import com.dultek.ums.model.Employee;
import com.dultek.ums.model.User;
import com.dultek.ums.model.UserCredentials;
import com.dultek.ums.repo.AddressRepository;
import com.dultek.ums.repo.UserCredentialsRepository;
import com.dultek.ums.repo.UserOperationServiceRepository;
import com.dultek.ums.validator.UserValidator;
import jakarta.persistence.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class UserOperationServiceImpl implements UserOperationService{


    private UserOperationServiceRepository userOperationServiceRepository;
    private AddressRepository addressRepository;
    UserCredentialsRepository userCredentialsRepository;

    @Autowired
    public UserOperationServiceImpl(UserOperationServiceRepository userOperationServiceRepository, AddressRepository addressRepository,
                                    UserCredentialsRepository userCredentialsRepository) {
        this.userOperationServiceRepository = userOperationServiceRepository;
        this.addressRepository = addressRepository;
        this.userCredentialsRepository = userCredentialsRepository;
    }

    @Override
    public void login() {

    }

    @Override
    public void logout() {

    }


    /**
     * Saves a user to the database after validating the user details.
     *
     * @param user The user to be saved.
     * @throws IllegalArgumentException If the user details are invalid.
     */
    public void saveUser(User user) {
        try {
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
        } catch (DataIntegrityViolationException e) {
            handleDataIntegrityViolation(e);
        }

    }

    /**
     * Handles a DataIntegrityViolationException, specifically looking for a duplicate entry error.
     * If a duplicate entry error is detected, it throws an IllegalArgumentException with an appropriate error message.
     *
     * @param ex The DataIntegrityViolationException to handle.
     * @throws IllegalArgumentException If a duplicate entry error is detected.
     */
    private void handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        // Default error message
        String errorMessage = "An error occurred while saving the user.\n Here is the cause: ";

        // Get the root cause exception
        Throwable cause = ex.getRootCause();

        // Append the localized message of the root cause to the error message
        errorMessage += cause.getLocalizedMessage();

        // Throw an IllegalArgumentException with the constructed error message
        throw new IllegalArgumentException(errorMessage);
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

    @Override
    public void createUser(User user) {
        saveUser(user);
    }

    @Override
    public void deleteUser(Long userId) {

    }

    @Override
    public User getUserById(Long userId) {
        return null;
    }
}
