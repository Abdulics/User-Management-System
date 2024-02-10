package com.dultek.ums.service;

import com.dultek.ums.exception.MyExceptions;
import com.dultek.ums.model.UserCredentials;
import com.dultek.ums.repo.UserCredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserCredentialsServiceImpl implements UserCredentialsService {
    @Autowired
    private UserCredentialsRepository userCredentialsRepository;

    @Override
    public UserCredentials saveUserCredentials(UserCredentials userCredentials) {
        return userCredentialsRepository.save(userCredentials);
    }

    @Override
    public UserCredentials getUserCredentialsByEmployeeId(Long employeeId) {
        return userCredentialsRepository.getReferenceById(employeeId);
    }

    @Override
    public UserCredentials getUserCredentialsByUsername(String username) {
        return null;
    }

    /**
     * Updates an existing user credentials' information based on the provided user credentials object.
     *
     * @param userCredentials The user credentials object containing the updated information.
     * @return The updated user credentials after the changes are applied and saved to the database.
     * @throws IllegalArgumentException If the provided userCredentials has a null ID.
     * @throws MyExceptions.UserCredentialsNotFoundException If no user credentials are found in the database with the provided ID.
     * @throws DataAccessException If an exception occurs while accessing the data store.
     */
    @Override
    public UserCredentials updateUserCredentials(UserCredentials userCredentials) {
        try {
            // Check if the userCredentials has a valid ID
            if (userCredentials.getCredentialId() == null) {
                throw new IllegalArgumentException("ID cannot be null for userCredentials update.");
            }

            // Retrieve the existing userCredentials from the database
            Optional<UserCredentials> existingUserCredentialsOptional = userCredentialsRepository.findById(userCredentials.getCredentialId());

            if (existingUserCredentialsOptional.isPresent()) {
                // Update the existing userCredentials with the new values
                UserCredentials existingUserCredentials = existingUserCredentialsOptional.get();
                existingUserCredentials.setUsername(userCredentials.getUsername());
                existingUserCredentials.setPassword(userCredentials.getPassword());
                existingUserCredentials.setRole(userCredentials.getRole());
                // Update other properties as needed

                // Save the updated userCredentials back to the database
                return userCredentialsRepository.save(existingUserCredentials);
            } else {
                // Handle the case where the userCredentials with the given ID is not found
                throw new MyExceptions.UserCredentialsNotFoundException("UserCredentials not found with ID: " + userCredentials.getCredentialId());
            }
        } catch (DataAccessException e) {
            // Handle exceptions related to data access, e.g., database connectivity issues
            throw new DataAccessResourceFailureException("Error occurred while updating user credentials in the database.", e);
        }
    }


    @Override
    public void deleteUserCredentialsByEmployeeId(Long employeeId) {

    }

    @Override
    public void deleteUserCredentialsByUsername(String username) {

    }

    // ... Implement other methods ...
}
