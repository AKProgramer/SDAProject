package com.sda.cargo_project.services;

import com.sda.cargo_project.models.Cargo;
import com.sda.cargo_project.models.CargoAssignment;
import com.sda.cargo_project.models.User;
import com.sda.cargo_project.repositories.CargoAssignmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CargoAssignmentService {

    private final CargoAssignmentRepo cargoAssignmentRepository;
    private final CargoService cargoService;
    private final UserService userService;

    @Autowired
    public CargoAssignmentService(CargoAssignmentRepo cargoAssignmentRepository, CargoService cargoService, UserService userService) {
        this.cargoAssignmentRepository = cargoAssignmentRepository;
        this.cargoService = cargoService;
        this.userService = userService;
    }

    public ResponseEntity<?> assignCargoToDriver(int cargoId, int driverId) {
        // Validate that cargo and driver exist
        Optional<Cargo> cargo = cargoService.getCargoById(cargoId);
        if (cargo.isEmpty()) {
            return ResponseEntity.badRequest().body("Cargo not found");
        }

        Optional<User> driver = userService.getUserById(driverId);
        if (driver.isEmpty()) {
            return ResponseEntity.badRequest().body("Driver not found");
        }

        // Check if the assigned user is a driver
        if (!driver.get().getRole().equals("Driver")) {
            return ResponseEntity.badRequest().body("The assigned user is not a driver");
        }

        // Create CargoAssignment and save
        CargoAssignment cargoAssignment = new CargoAssignment();
        cargoAssignment.setCargo(cargo.get());
        cargoAssignment.setDriver(driver.get());
        cargoAssignment.setAssignmentDate(LocalDateTime.now());

        cargoAssignmentRepository.save(cargoAssignment);

        return ResponseEntity.ok().build();
    }
}
