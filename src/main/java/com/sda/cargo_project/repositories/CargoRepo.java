package com.sda.cargo_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sda.cargo_project.models.Cargo;

public interface CargoRepo extends JpaRepository<Cargo, Integer>{

    
} 
