package com.sda.cargo_project.web;

import com.sda.cargo_project.models.Cargo;
import com.sda.cargo_project.services.CargoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/cargo")
public class CargoController {

    private final CargoService cargoService;

    public CargoController(CargoService cargoService) {
        this.cargoService = cargoService;
    }

    @PostMapping("/book")
    public ResponseEntity<Cargo> bookACargo(@RequestBody Cargo cargo) {
        try {
            Cargo bookedCargo = cargoService.book(cargo);
            return ResponseEntity.status(HttpStatus.CREATED).body(bookedCargo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cargo> getCargoById(@PathVariable int id) {
        Optional<Cargo> cargo = cargoService.getCargoById(id);
        return cargo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cargo> updateCargo(@PathVariable int id, @RequestBody Cargo cargo) {
        try {
            cargo.setId(id);
            Cargo updatedCargo = cargoService.updateCargo(cargo);
            return ResponseEntity.ok(updatedCargo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCargoById(@PathVariable int id) {
        try {
            cargoService.deleteCargoById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @GetMapping("/all")
    public ResponseEntity<Iterable<Cargo>> getAllCargoes() {
        try {
            Iterable<Cargo> cargoes = cargoService.getAllCargoes();
            return ResponseEntity.ok(cargoes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
