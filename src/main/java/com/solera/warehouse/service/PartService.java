package com.solera.warehouse.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.solera.warehouse.model.Part;
import com.solera.warehouse.repository.PartRepository;

@Service
public class PartService {
    private final PartRepository partRepository;

    public PartService(PartRepository partRepository) {
        this.partRepository = partRepository;
    }
    
    public Part savePart(Part part) {
        return partRepository.save(part);
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
        if (partRepository.existsById(part.getIdPart())) {
            return partRepository.save(part);
        }
        return null; // or throw an exception
    }
}