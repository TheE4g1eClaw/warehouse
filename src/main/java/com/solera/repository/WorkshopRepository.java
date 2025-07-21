package com.solera.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solera.model.Workshop;

public interface WorkshopRepository  extends JpaRepository<Workshop, Integer> {
    // Additional query methods can be defined here if needed

}
