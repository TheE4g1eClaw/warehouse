package com.solera.warehouse.repository;

import org.springframework.data.repository.CrudRepository;

import com.solera.warehouse.model.Workshop;

public interface WorkshopRepository  extends CrudRepository<Workshop, Integer> {
    // Additional query methods can be defined here if needed

}
