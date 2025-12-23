package com.tp31.microservicesmessagingconsumer.repository;

import com.tp31.microservicesmessagingconsumer.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByAccountId(String accountId);
}

