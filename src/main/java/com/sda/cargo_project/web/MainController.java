package com.sda.cargo_project.web;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sda.cargo_project.models.Cargo;
import com.sda.cargo_project.models.User;
import com.sda.cargo_project.services.CargoService;
import com.sda.cargo_project.services.UserService;

@RestController
public class MainController {
    UserService userService;
    CargoService cargoService;
    public MainController(UserService service, CargoService cargoService)
    {
        this.userService = service;
        this.cargoService = cargoService;
    }
    @GetMapping("/")
    public String hello()
    {
        return "Kasy ho";
    }
   @PostMapping("/register")
    public ResponseEntity<Object> registerUser(@RequestBody User user) {
        try {
            User registeredUser = userService.registerUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @PostMapping("/bookACargo")
    
        public ResponseEntity<Object> bookACargo(@RequestBody Cargo cargo) {
        try {
            Cargo bookedCargo = cargoService.book(cargo);
            return ResponseEntity.status(HttpStatus.CREATED).body(bookedCargo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    
}
