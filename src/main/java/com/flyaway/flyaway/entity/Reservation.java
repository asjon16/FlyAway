package com.flyaway.flyaway.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name="reservations")
@Getter
@Setter
@Data
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
