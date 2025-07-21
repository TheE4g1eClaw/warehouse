package com.solera.warehouse.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.solera.warehouse.model.Vehicle;
import com.solera.warehouse.repository.VehicleRepository;


@RestController("/v1")
public class VehicleController {
    private VehicleRepository vehicleRepository;

    public VehicleController(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @GetMapping("/vehicle/{id}")
    public String getVehicleById(@PathVariable Integer id) {
        vehicleRepository.findById(id).get();
        String message = "Name" +  "Id: " + id;
        message += "Vehicle Workshop: " + vehicleRepository.findById(id).get().getWorkshop().getName();
        return message;
    }

    @PostMapping("/vehicle")
    public String saveVehicle(@RequestBody Vehicle vehicle) {
        vehicleRepository.save(vehicle);
        return "Vehicle saved successfully";
    }

    @PutMapping("/vehicle/{id}")
    public String updateVehicle(@PathVariable Integer id, @RequestBody Vehicle vehicle) {
        if (vehicleRepository.existsById(id)) {
            vehicle.setIdVehicle(id);
            vehicleRepository.save(vehicle);
            return "Vehicle updated successfully";
        } else {
            return "Vehicle not found";
        }
    }

    @DeleteMapping("/vehicle/{id}")
    public String deleteVehicle(@PathVariable Integer id) {
        if (vehicleRepository.existsById(id)) {
            vehicleRepository.deleteById(id);
            return "Vehicle deleted successfully";
        } else {
            return "Vehicle not found";
        }
    }
}
