package com.github.dmitrKuznetsov.buysell.repositories;

import com.github.dmitrKuznetsov.buysell.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
