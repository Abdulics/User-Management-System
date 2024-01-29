package com.dultek.ums.service;

import com.dultek.ums.model.User;

public interface UserOperationService {
    void login();
    void logout();
    void resetPassword();
    void updateInformation();
    void saveUser(User user);
    void createUser(User user);
    void updateUser(User user);
    void deleteUser(Long userId);
    User getUserById(Long userId);
}

