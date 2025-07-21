package com.solera.warehouse.repository;
import org.springframework.data.repository.CrudRepository;

import com.solera.warehouse.model.Vehicle;

public interface VehicleRepository  extends CrudRepository<Vehicle, Integer> {
    
    // Additional query methods can be defined here if needed

}
