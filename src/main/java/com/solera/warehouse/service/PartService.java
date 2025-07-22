package com.solera.warehouse.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.solera.warehouse.model.Part;
import com.solera.warehouse.model.Vehicle;
import com.solera.warehouse.repository.PartRepository;
import com.solera.warehouse.repository.VehicleRepository;

@Service
public class PartService {
    private final PartRepository partRepository;
    private final VehicleRepository vehicleRepository;

    public PartService(PartRepository partRepository, VehicleRepository vehicleRepository) {
        this.partRepository = partRepository;
        this.vehicleRepository = vehicleRepository;
    }
    
    public Part savePart(Part part) {
        Vehicle vehicle = null;
        if(part == null || part.getIdVehicle() == null) {
            return null;
        }else{
            vehicle = vehicleRepository.findById(part.getIdVehicle()).orElse(null);
            if(vehicle == null) {
                return null; // or throw an exception
            }else {
                part.setVehicle(vehicle);
            }
            return partRepository.save(part);
        }
    }

    public Part getPartById(Integer id) {
        return partRepository.findById(id).orElse(null);
    }

    public List<Part> getAllParts() {
        return (List<Part>) partRepository.findAll();
    }

    public void deletePart(Integer id) {
        partRepository.deleteById(id);
    }

    public Part updatePart(Part part) {
        try{
            if (partRepository.existsById(part.getIdPart())) {
            Vehicle vehicle = null;
            vehicle = vehicleRepository.findById(part.getIdVehicle()).orElse(null);
            if(vehicle == null) {
                return null; 
            }else {
                part.setVehicle(vehicle);
            }
                return partRepository.save(part);
            }
            return null; 
        }catch (Exception e) {
            return null;
        }
    }
}