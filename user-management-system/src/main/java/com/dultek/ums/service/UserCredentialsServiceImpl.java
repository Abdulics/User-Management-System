package com.dultek.ums.service;

import com.dultek.ums.model.UserCredentials;
import com.dultek.ums.repo.UserCredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return null;
    }

    @Override
    public UserCredentials getUserCredentialsByUsername(String username) {
        return null;
    }

    @Override
    public UserCredentials updateUserCredentials(UserCredentials userCredentials) {
        return null;
    }

    @Override
    public void deleteUserCredentialsByEmployeeId(Long employeeId) {

    }

    @Override
    public void deleteUserCredentialsByUsername(String username) {

    }

    // ... Implement other methods ...
}
