package com.springsecurity.repository;


import com.springsecurity.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserAccount, Long> {

    Optional<UserAccount> findById(Long userId);

    Optional<UserAccount> findByUserName(String userName);
}
