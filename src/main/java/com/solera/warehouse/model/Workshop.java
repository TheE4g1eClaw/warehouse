package com.solera.warehouse.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

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

}
