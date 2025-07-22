package com.solera.warehouse.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.solera.warehouse.model.Workshop;
import com.solera.warehouse.model.Vehicle;
import com.solera.warehouse.repository.WorkshopRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;


@RestController
@RequestMapping("/v1")
public class WorkshopController {
    private WorkshopRepository workshopRepository;

    public WorkshopController(WorkshopRepository workshopRepository) {
        this.workshopRepository = workshopRepository;
    }

    @PostMapping("/workshop")
    public String postMethodName(@RequestBody Workshop entity) {
        workshopRepository.save(entity);
        return "Workshop saved successfully";
    }

    @GetMapping("/workshop/{id}")
    public String getWorkshopById(@PathVariable Integer id) {
        if (workshopRepository.existsById(id)) {
            Workshop workshop = workshopRepository.findById(id).get();
            String message = "Workshop Name: " + workshop.getName() + ", Description: " + workshop.getDescription();
            message += "\nVehicles in Workshop: ";
            if (workshop.getVehicles() != null && !workshop.getVehicles().isEmpty   ()) {
                for (Vehicle vehicle : workshop.getVehicles()) {
                    message += "\n- " + vehicle.getModel() + " (ID: " + vehicle.getIdVehicle() + ")";
                }
            } else {
                message += "The workshop is empty.";
            }
            return message;
        } else {
            return "Workshop not found";
        }
    }
     /* Copilot, revisar */
    @GetMapping("/workshop")
    public String getAllWorkshops() {
        StringBuilder message = new StringBuilder("List of Workshops:\n");
        workshopRepository.findAll().forEach(workshop -> {
            message.append("ID: ").append(workshop.getIdWorkshop())
                   .append(", Name: ").append(workshop.getName())
                   .append(", Description: ").append(workshop.getDescription()).append("\n");
        });
        return message.toString();
    }

    @PutMapping("/workshop/{id}")
    public String updateWorkshop(@PathVariable Integer id, @RequestBody Workshop workshop) {
        if (workshopRepository.existsById(id)) {
            workshop.setIdWorkshop(id);
            workshopRepository.save(workshop);
            return "Workshop updated successfully";
        } else {
            return "Workshop not found";
        }
    }

    @DeleteMapping("/workshop/{id}")
    public String deleteWorkshop(@PathVariable Integer id) {
        if (workshopRepository.existsById(id)) {
            workshopRepository.deleteById(id);
            return "Workshop deleted successfully";
        } else {
            return "Workshop not found";
        }
    }

}
