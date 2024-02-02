package com.dultek.ums.repo;

import com.dultek.ums.model.Address;
import com.dultek.ums.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    Optional<Address> findByEmployeeId(Long employeeId);
}
