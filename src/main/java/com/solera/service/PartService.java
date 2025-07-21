package com.solera.service;

import org.springframework.stereotype.Service;
import com.solera.repository.PartRepository;

@Service
public class PartService {
    private final PartRepository partRepository;

    public PartService(PartRepository partRepository) {
        this.partRepository = partRepository;
    }
    
}
