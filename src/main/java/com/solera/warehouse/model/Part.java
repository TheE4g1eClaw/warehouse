package com.solera.warehouse.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "part")
@Getter
@Setter
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idPart;
    String name;
    String description;
    
    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = true)
    @JsonIgnore
    Vehicle vehicle;
}
