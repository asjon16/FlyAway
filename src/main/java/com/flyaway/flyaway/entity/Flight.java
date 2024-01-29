package com.flyaway.flyaway.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@RequiredArgsConstructor
@Data
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer capacity;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    @ManyToOne
    @JoinColumn(name = "routes_id", referencedColumnName = "id")
    private Route routes;
}
