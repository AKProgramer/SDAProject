package com.sda.cargo_project.web;
import com.sda.cargo_project.models.CargoAssignment;
import com.sda.cargo_project.services.CargoAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/assign")
public class CargoAssignmentController {

    private final CargoAssignmentService assignmentService;

    @Autowired
    public CargoAssignmentController(CargoAssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @PostMapping("/cargo")
    public ResponseEntity<?> assignCargoToDriver(@RequestBody CargoAssignment request) {
        return assignmentService.assignCargoToDriver(request.getCargo().getId(), request.getDriver().getId());
    }
}
