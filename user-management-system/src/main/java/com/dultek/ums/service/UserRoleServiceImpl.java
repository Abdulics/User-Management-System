package com.dultek.ums.service;

import com.dultek.ums.exception.MyExceptions;
import com.dultek.ums.model.UserRole;
import com.dultek.ums.repo.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRoleServiceImpl implements UserRoleService{

    @Autowired
    private UserRoleRepository userRoleRepository;

    // Implement the methods from the UserRoleService interface

    // Example of saveUserRole
    @Override
    public UserRole saveUserRole(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    @Override
    public List<UserRole> getUserRolesByEmployeeId(Long employeeId) {
        return null;
    }

    /**
     * Updates an existing user role's information based on the provided user role object.
     *
     * @param userRole The user role object containing the updated information.
     * @return The updated user role after the changes are applied and saved to the database.
     * @throws IllegalArgumentException If the provided userRole has a null userRoleId.
     * @throws MyExceptions.UserRoleNotFoundException If no user role is found in the database with the provided userRoleId.
     * @throws DataAccessException If an exception occurs while accessing the data store.
     */
    @Override
    public UserRole updateUserRole(UserRole userRole) {
        try {
            // Check if the userRole has a valid userRoleId
            if (userRole.getUserRoleId() == null) {
                throw new IllegalArgumentException("UserRoleId cannot be null for userRole update.");
            }

            // Retrieve the existing userRole from the database
            Optional<UserRole> existingUserRoleOptional = userRoleRepository.findById(userRole.getUserRoleId());

            if (existingUserRoleOptional.isPresent()) {
                // Update the existing userRole with the new values
                UserRole existingUserRole = existingUserRoleOptional.get();
                existingUserRole.setRole(userRole.getRole());
                // Update other properties as needed

                // Save the updated userRole back to the database
                return userRoleRepository.save(existingUserRole);
            } else {
                // Handle the case where the userRole with the given userRoleId is not found
                throw new MyExceptions.UserRoleNotFoundException("UserRole not found with ID: " + userRole.getUserRoleId());
            }
        } catch (DataAccessException e) {
            // Handle exceptions related to data access, e.g., database connectivity issues
            throw new DataAccessResourceFailureException("Error occurred while updating user role in the database.", e);
        }
    }


    @Override
    public void deleteUserRoleByEmployeeId(Long employeeId) {

    }

    /**
     * @param credentialId
     * @return
     */
    @Override
    public UserRole getUserRolesByUserCredentialsId(Long credentialId) {
        return userRoleRepository.getReferenceById(credentialId);
    }
}
