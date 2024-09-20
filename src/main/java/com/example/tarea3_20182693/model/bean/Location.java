package com.example.tarea3_20182693.model.bean;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


@Entity
@Table(name = "locations")
public class Location {

    @Id
    @Column(name = "location_id")

    private int locationId;

    @Column(name = "city", nullable = false)
    private String city;
    @Column(name = "street_address")
    private String street_address;

    @Override
    public String toString() {
        return city;
    }


}