package com.sda.cargo_project.repositories;

import com.sda.cargo_project.models.CargoAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoAssignmentRepo extends JpaRepository<CargoAssignment,Integer> {

}
