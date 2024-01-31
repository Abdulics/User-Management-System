package com.dultek.ums.service;

import com.dultek.ums.model.UserRole;
import com.dultek.ums.repo.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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

    @Override
    public UserRole updateUserRole(UserRole userRole) {
        return null;
    }

    @Override
    public void deleteUserRoleByEmployeeId(Long employeeId) {

    }
}
