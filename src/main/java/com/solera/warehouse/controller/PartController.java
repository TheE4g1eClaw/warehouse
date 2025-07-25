package com.solera.warehouse.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solera.warehouse.model.Part;
import com.solera.warehouse.service.PartService;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/v1")
public class PartController {

    private final PartService partService;

    public PartController(PartService partService) {
        this.partService = partService;
    }

    @PostMapping("/parts")
    public ResponseEntity<String> postMethodName(@RequestBody Part part) {
        Part savedPart = partService.savePart(part);
        return (savedPart == null) ?ResponseEntity.internalServerError().body("We can't save the part"):ResponseEntity.ok("Part saved successfully with ID: " + savedPart.getIdPart()); 
    }

    @GetMapping("/parts/{id}")
    public ResponseEntity<String> getMethodName(@PathVariable int id) {
        Part part = partService.getPartById(id);
        return (part == null)?ResponseEntity.internalServerError().body("Part not found"):ResponseEntity.ok("Part found: " + part.getName() + " with ID: " + part.getIdPart() + ", Description: " + part.getDescription());
    }
    
    @GetMapping("/parts")
    public ResponseEntity<List<Part>> getAllParts() {
        List<Part> parts = partService.getAllParts();
        return (parts == null || parts.isEmpty()) ? ResponseEntity.internalServerError().body(null) : ResponseEntity.ok(parts);
    }
 

    @PutMapping("/parts")
    public ResponseEntity<String> putPart(@RequestBody Part part){
        Part updatedPart = partService.updatePart(part);
        return (updatedPart == null) ? ResponseEntity.internalServerError().body("We can't update the part") : ResponseEntity.ok("Part updated successfully with ID: " + updatedPart.getIdPart() + ", Name: " + updatedPart.getName() + ", Description: " + updatedPart.getDescription());
    }

    @DeleteMapping("/parts")
    public ResponseEntity<String> deletePart(@RequestParam Integer id) {
        partService.deletePart(id);
        return ResponseEntity.ok("Part deleted successfully");

    }
}
