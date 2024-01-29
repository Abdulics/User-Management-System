package com.dultek.ums.service;

import com.dultek.ums.model.User;

import com.dultek.ums.repo.UserRepository;
import com.dultek.ums.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user) {

        if (UserValidator.isValidUser(user)) {
            // Set the user ID to null to rely on the database-generated ID
            user.setId(null);

            // Save the user to generate the database ID
            User savedUser = userRepository.save(user);

            // Generate the employee ID based on savedUser details
            String initials = user.getFirstName().substring(0, 1).toUpperCase()
                    + user.getLastName().substring(0, 1).toUpperCase();

            String employeeId = generateEmployeeId(initials, savedUser.getId());

            // Update the saved user with the generated employee ID
            savedUser.setEmployeeId(employeeId);
            userRepository.save(savedUser);
        } else {
            // Handle the case where the user is not valid
            throw new IllegalArgumentException("Invalid user details");
        }
    }


    public String generateEmployeeId(String initials, Long id) {
        return initials + id;
    }

}
