package com.dultek.ums.service;

import com.dultek.ums.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserOperationService {
    void login();
    void logout();
    void saveUser(User user);
    void createUser(User user);
    void deleteUser(Long userId);
    User getUserById(Long userId);
}

