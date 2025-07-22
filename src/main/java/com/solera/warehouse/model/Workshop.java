package com.solera.warehouse.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "workshop")
@Getter
@Setter
public class Workshop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idWorkshop;
    String name;
    String descrption;

    @OneToMany(mappedBy = "workshop")
    @JsonIgnore
    List<Vehicle> vehicles;

}
