package com.evaExchange.eva.repository;

import com.evaExchange.eva.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

