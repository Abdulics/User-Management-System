package com.dultek.ums.repo;

import com.dultek.ums.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT e FROM Employee e LEFT JOIN FETCH e.address LEFT JOIN FETCH e.credentials WHERE e.employeeId = :employeeId")
    Optional<Employee> findEmployeeWithDetailsById(@Param("employeeId") Long employeeId);
}
