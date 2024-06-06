package com.sda.cargo_project.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CargoAssignmentRequest {
    private int cargoId;
    private int driverId;
}