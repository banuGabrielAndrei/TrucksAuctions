package com.TrucksAuctions.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "trucks")
public class Truck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String owner;

    @Column(nullable = false)
    private String manufacturer;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String engineType;

    @Column(nullable = false)
    private int mileage;

    @Column(nullable = false)
    private int hp;

    @Column(nullable = false)
    private String retarder;

    @Column(nullable = false)
    private String transmission;

    @Column(nullable = false)
    private String auxiliaryHeater;

    @Column(nullable = false)
    private String climateControl;

    @Column(nullable = false)
    private String stationaryAC;

    @Column(nullable = false)
    private int year;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    private int price;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;
}
