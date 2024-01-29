package com.flyaway.flyaway.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="reservations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime reservationTime;
    private Integer price;


    @ManyToOne
    @JoinColumn(name = "routes_id", referencedColumnName = "id")
    private Route routes;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;






}
