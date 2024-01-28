package com.dultek.ums.service;

import com.dultek.ums.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Modifying
    @Query(value = "INSERT INTO user (employee_id, first_name, last_name, ...other_columns) VALUES (?1, ?2, ?3, ...)", nativeQuery = true)
    void saveUserWithGeneratedEmployeeId(String employeeId, String firstName, String lastName);

    @Query(value = "SELECT CONCAT(LEFT(?1, 2), RIGHT(YEAR(CURDATE()), 2), LPAD(COUNT(*) + 1, 4, '0'))", nativeQuery = true)
    String generateEmployeeId(String initials);
}
