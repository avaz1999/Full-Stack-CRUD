package com.example.springbootjavascriptcrud.repository;

import com.example.springbootjavascriptcrud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsUserByUsername(String username);
}
