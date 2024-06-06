package com.sda.cargo_project.services;

import com.sda.cargo_project.models.Cargo;
import com.sda.cargo_project.models.CargoAssignment;
import com.sda.cargo_project.models.User;
import com.sda.cargo_project.repositories.CargoAssignmentRepo;
import com.sda.cargo_project.repositories.CargoRepo;
import com.sda.cargo_project.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AssignmentService {

    @Autowired
    private CargoAssignmentRepo cargoAssignmentRepository;

    @Autowired
    private CargoRepo cargoRepository;

    @Autowired
    private UserRepo userRepository;

    public CargoAssignment assignCargoToDriver(int cargoId, int driverId) {
        Cargo cargo = cargoRepository.findById(cargoId).orElse(null);
        if (cargo == null) {
            throw new IllegalArgumentException("Invalid cargo ID");
        }

        User driver = userRepository.findById(driverId).orElse(null);
        if (driver == null || (driver.getRole().equals("Driver") || driver.getRole().equals("driver"))) {
            throw new IllegalArgumentException("Invalid driver ID");
        }

        CargoAssignment cargoAssignment = new CargoAssignment();
        cargoAssignment.setCargo(cargo);
        cargoAssignment.setDriver(driver);
        cargoAssignment.setAssignmentDate(LocalDateTime.now());

        return cargoAssignmentRepository.save(cargoAssignment);
    }
}