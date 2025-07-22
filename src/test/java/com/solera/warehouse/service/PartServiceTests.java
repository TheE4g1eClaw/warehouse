package com.solera.warehouse.service;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.List;
import org.springframework.boot.test.context.SpringBootTest;
import com.solera.warehouse.model.Part;
import com.solera.warehouse.repository.PartRepository;
import com.solera.warehouse.repository.VehicleRepository;
import org.mockito.*;


@SpringBootTest
public class PartServiceTests {
    private final PartRepository partRepository = org.mockito.Mockito.mock(PartRepository.class);
    private final VehicleRepository vehicleRepository = org.mockito.Mockito.mock(VehicleRepository.class);
    private final PartService partService = new PartService(partRepository, vehicleRepository);

    @Test
    void testGetPartById() {    
        Part part = new Part();
        part.setIdPart(1);
        part.setName("Faro de luz");
        part.setDescription("Faro de luz delantero");
        Mockito.when(partRepository.findById(1)).thenReturn(java.util.Optional.of(part));
        Part foundPart = partService.getPartById(1);
        assertNotNull(foundPart);
        assertEquals("Faro de luz", foundPart.getName());
    }

    @Test
    void testGetAllParts() {
        Part part1 = new Part();
        part1.setIdPart(1);
        part1.setName("Faro de luz");
        part1.setDescription("Faro de luz delantero");
        Part part2 = new Part();
        part2.setIdPart(2);
        part2.setName("Filtro de aceite");
        part2.setDescription("Filtro de aceite");
        List<Part> parts = java.util.Arrays.asList(part1, part2);
        Mockito.when(partRepository.findAll()).thenReturn(parts);
        List<Part> foundParts = partService.getAllParts();
        assertNotNull(foundParts);
        assertEquals(2, foundParts.size());
    }

    @Test
    void testDeletePart() {
        Part part = new Part();
        part.setIdPart(1);
        part.setName("Faro de luz");
        part.setDescription("Faro de luz delantero");
        Mockito.when(partRepository.findById(1)).thenReturn(java.util.Optional.of(part));
        partService.deletePart(1);
        Mockito.when(partRepository.findById(1)).thenReturn(java.util.Optional.empty());
        Part partDeleted = partService.getPartById(1);
        assertNull(partDeleted);
    }


    @Test
    void testSavePartNull() {
        Part part = new Part();
        Mockito.when(partRepository.save(part)).thenReturn(part);
        Part savedPart = partService.savePart(part);
        assertNull(savedPart);
    }
}