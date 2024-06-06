package com.sda.cargo_project.web;
import com.sda.cargo_project.dto.CargoAssignmentRequest;
import com.sda.cargo_project.models.CargoAssignment;
import com.sda.cargo_project.services.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/assign")
public class CargoAssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    @PostMapping("/cargo")
    public ResponseEntity<?> assignCargoToDriver(@RequestBody CargoAssignmentRequest request) {
        try {
            CargoAssignment cargoAssignment = assignmentService.assignCargoToDriver(request.getCargoId(), request.getDriverId());
            return ResponseEntity.status(HttpStatus.CREATED).body(cargoAssignment);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}