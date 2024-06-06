package com.sda.cargo_project.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sda.cargo_project.models.User;

public interface UserRepo extends JpaRepository<User, Integer>{
    Optional<User> findByEmailAndPassword(String email, String password);
    public List<User> findByRole(String role);
}
