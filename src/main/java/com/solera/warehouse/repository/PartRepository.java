package com.solera.warehouse.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.solera.warehouse.model.Part;

@Repository
public interface PartRepository extends CrudRepository<Part, Integer> {
    // Additional query methods can be defined here if needed


}
