package com.solera.warehouse.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vehicle")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idVehicle;
    String model;
    String brand;
    String vehicleYear;
    String color;
    String vin;
    
    @ManyToOne
    @JoinColumn(name = "workshop_id", nullable = true)
    @JsonIgnore
    Workshop workshop;

    @OneToMany(mappedBy = "vehicle")
    List<Part> parts;
}
