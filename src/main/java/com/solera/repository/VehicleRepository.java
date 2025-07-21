package com.solera.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.solera.model.Vehicle;

public interface VehicleRepository  extends JpaRepository<Vehicle, Integer> {
    
    // Additional query methods can be defined here if needed

}
