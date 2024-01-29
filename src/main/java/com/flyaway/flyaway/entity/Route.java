package com.flyaway.flyaway.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "from_country_id", referencedColumnName = "id")
    private Country fromCountry;

    @ManyToOne
    @JoinColumn(name = "to_country_id", referencedColumnName = "id")
    private Country toCountry;


}
