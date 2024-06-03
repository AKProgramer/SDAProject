package com.sda.cargo_project.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sda.cargo_project.models.Cargo;
import com.sda.cargo_project.repositories.CargoRepo;

@Service
public class CargoService {
    
    @Autowired
    private CargoRepo cargoRepo;

    // Create or Update (Book) Cargo
    public Cargo book(Cargo cargo) {
        return cargoRepo.save(cargo);
    }

    // Read (Get) Cargo by ID
    public Optional<Cargo> getCargoById(int id) {
        return cargoRepo.findById(id);
    }

    // Update Cargo
    public Cargo updateCargo(Cargo cargo) {
        return cargoRepo.save(cargo);
    }

    // Delete Cargo by ID
    public void deleteCargoById(int id) {
        cargoRepo.deleteById(id);
    }
    
    // List All Cargoes
    public Iterable<Cargo> getAllCargoes() {
        return cargoRepo.findAll();
    }
}
