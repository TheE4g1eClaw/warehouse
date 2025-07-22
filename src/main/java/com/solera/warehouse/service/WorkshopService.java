package com.solera.warehouse.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.solera.warehouse.model.Workshop;
import com.solera.warehouse.repository.WorkshopRepository;

@Service
public class WorkshopService {
    private final WorkshopRepository workshopRepository;

    public WorkshopService(WorkshopRepository workshopRepository) {
        this.workshopRepository = workshopRepository;
    }

    public Workshop saveWorkshop(Workshop workshop) {
        workshop.setIdWorkshop(null);; // Ensure a new workshop is created
        workshop.setVehicles(null); // Clear vehicles to avoid issues with existing vehicles
        return workshopRepository.save(workshop);
    }

    public Workshop getWorkshopById(Integer id) {
        return workshopRepository.findById(id).orElse(null);
    }

    public List<Workshop> getAllWorkshops() {
        return (List<Workshop>) workshopRepository.findAll();
    }

    public void deleteWorkshop(Integer id) {
        workshopRepository.deleteById(id);
    }

    public Workshop updateWorkshop(Workshop workshop) {
        if (workshopRepository.existsById(workshop.getIdWorkshop())) {
            workshop.setVehicles(workshopRepository.findById(workshop.getIdWorkshop()).get().getVehicles());
            return workshopRepository.save(workshop);
        }
        return null; // or throw an exception
    }

}
