package com.flyaway.flyaway.repository;

import com.flyaway.flyaway.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoutesRepository extends JpaRepository<Route,Long> {

    List<Route> findAll();
}
