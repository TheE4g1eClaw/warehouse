package com.solera.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.solera.model.Part;

public interface PartRepository extends JpaRepository<Part, Integer> {
    // Additional query methods can be defined here if needed


}
