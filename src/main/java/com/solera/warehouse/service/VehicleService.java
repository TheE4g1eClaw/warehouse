package com.solera.warehouse.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.solera.warehouse.model.Vehicle;
import com.solera.warehouse.repository.VehicleRepository;
import com.solera.warehouse.repository.WorkshopRepository;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;
    private final WorkshopRepository workshopRepository;

    public VehicleService(VehicleRepository vehicleRepository, WorkshopRepository workshopRepository) {
        this.vehicleRepository = vehicleRepository;
        this.workshopRepository = workshopRepository;
    }

    public Vehicle saveVehicle(Vehicle vehicle, Integer workshopId) {
        vehicle.setIdVehicle(null); // Ensure a new vehicle is created
        vehicle.setParts(null); // Clear parts to avoid issues with existing parts
        if (workshopId != null) {
            var workshop = workshopRepository.findById(workshopId).orElse(null);
            vehicle.setWorkshop(workshop);
        } else {
            vehicle.setWorkshop(null); // If no workshop ID is provided, set workshop to null
        }
        if (vehicle.getWorkshop() == null) {
            return null; // or throw an exception
        }
        return vehicleRepository.save(vehicle);
        
    }

    public List<Vehicle> getAllVehicles() {
        return (List<Vehicle>) vehicleRepository.findAll();
    }

    public Vehicle getVehicleById(Integer id) {
        return vehicleRepository.findById(id).orElse(null);
    }

    public Vehicle updateVehicle(Integer id, Vehicle vehicle) {
        if (vehicleRepository.existsById(id) && vehicle.getWorkshopId() != null) {
            Vehicle existingVehicle = vehicleRepository.findById(id).get();
            vehicle.setIdVehicle(id);
            vehicle.setParts(existingVehicle.getParts());
            if (vehicle.getWorkshopId() != existingVehicle.getWorkshop().getIdWorkshop()) {
                vehicle.setWorkshop(workshopRepository.findById(vehicle.getWorkshopId()).orElse(null));
                if (vehicle.getWorkshop() == null) {
                    return null; // or throw an exception
                }
            } else {
                vehicle.setWorkshop(existingVehicle.getWorkshop());
            }
            return vehicleRepository.save(vehicle);
        }
        return null; // or throw an exception
    }

    public void deleteVehicle(Integer id) {
        vehicleRepository.deleteById(id);
    }
}
