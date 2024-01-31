package com.dultek.ums.service;

import com.dultek.ums.model.UserCredentials;

public interface UserCredentialsService {
    UserCredentials saveUserCredentials(UserCredentials userCredentials);
    UserCredentials getUserCredentialsByEmployeeId(Long employeeId);
    UserCredentials getUserCredentialsByUsername(String username);
    UserCredentials updateUserCredentials(UserCredentials userCredentials);
    void deleteUserCredentialsByEmployeeId(Long employeeId);
    void deleteUserCredentialsByUsername(String username);
}