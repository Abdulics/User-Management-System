package com.dultek.ums.service;

import com.dultek.ums.model.UserRole;

import java.util.List;

public interface UserRoleService {
    UserRole saveUserRole(UserRole userRole);
    List<UserRole> getUserRolesByEmployeeId(Long employeeId);
    UserRole updateUserRole(UserRole userRole);
    void deleteUserRoleByEmployeeId(Long employeeId);
    UserRole getUserRolesByUserCredentialsId(Long credentialId);
}
