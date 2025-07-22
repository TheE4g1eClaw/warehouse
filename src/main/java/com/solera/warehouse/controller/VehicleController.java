package com.solera.warehouse.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.solera.warehouse.model.Vehicle;
import com.solera.warehouse.service.VehicleService;


@RestController
@RequestMapping("/v1")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicle/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Integer id) {
        Vehicle vehicle = vehicleService.getVehicleById(id);
        return (vehicle == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(vehicle);
    }

    @PostMapping("/vehicle")
    public ResponseEntity<String> saveVehicle(@RequestBody Vehicle vehicle) {
        Vehicle savedVehicle = null;
        if (vehicle.getWorkshopId() != null) {
            savedVehicle = vehicleService.saveVehicle(vehicle, vehicle.getWorkshopId());
            return (savedVehicle == null) ? ResponseEntity.internalServerError().body("Workshop not found") : ResponseEntity.ok("Vehicle saved successfully");
        }
        return ResponseEntity.badRequest().body("Missing workshop ID");
    }

    @PutMapping("/vehicle/{id}")
    public ResponseEntity<String> updateVehicle(@PathVariable Integer id, @RequestBody Vehicle vehicle) {
        Vehicle updatedVehicle = vehicleService.updateVehicle(id, vehicle);
        return (updatedVehicle == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok("Vehicle updated successfully");
    }

    @DeleteMapping("/vehicle/{id}")
    public ResponseEntity<String> deleteVehicle(@PathVariable Integer id) {
        if (vehicleService.getVehicleById(id) != null) {
            vehicleService.deleteVehicle(id);
            return ResponseEntity.ok("Vehicle deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }
}
