package com.dultek.ums.repo;

import com.dultek.ums.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserOperationServiceRepository extends JpaRepository<User, String> {

}
