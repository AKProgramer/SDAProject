package com.sda.cargo_project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sda.cargo_project.models.User;
import com.sda.cargo_project.repositories.UserRepo;

@Service
public class UserService {
    
    @Autowired
    private UserRepo userRepo;

    // Register User
    public User registerUser(User user) {
        return userRepo.save(user);
    }

    // Login User
    public Optional<User> loginUser(String email, String password) {
        return userRepo.findByEmailAndPassword(email, password);
    }

    // Get User by ID
    public Optional<User> getUserById(int id) {
        return userRepo.findById(id);
    }

    // Update User
    public User updateUser(User user) {
        return userRepo.save(user);
    }

    // Delete User by ID
    public void deleteUserById(int id) {
        userRepo.deleteById(id);
    }
    public List<User> getUsersByRole(String role) {
        return userRepo.findByRole(role);
    }
}
