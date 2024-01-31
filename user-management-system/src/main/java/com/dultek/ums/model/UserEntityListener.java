package com.dultek.ums.model;
import com.dultek.ums.validator.UserValidator;
import jakarta.persistence.PrePersist;

/**
 * Entity listener for User entities, containing pre-persist logic.
 */
public class UserEntityListener {

    /**
     * Handles pre-persist events for User entities.
     *
     * @param user The User entity being persisted.
     * @throws IllegalArgumentException If the user details are invalid.
     */
    @PrePersist
    public void prePersist(User user) {
        // Check if the user details are valid using the UserValidator
        if (UserValidator.isValidUser(user)) {
            // Generate the employee ID based on user details
            String initials = user.getFirstName().substring(0, 1).toUpperCase()
                    + user.getLastName().substring(0, 1).toUpperCase();

            user.setEmployeeId(generateEmployeeId(initials, user.getId()));
        } else {
            // Throw an exception if the user details are invalid
            throw new IllegalArgumentException("Invalid user details");
        }
    }

    /**
     * Generates an employee ID based on initials and user ID.
     *
     * @param initials The initials of the user.
     * @param id       The ID of the user.
     * @return The generated employee ID.
     */
    public String generateEmployeeId(String initials, Long id) {
        return initials + id;
    }
}

