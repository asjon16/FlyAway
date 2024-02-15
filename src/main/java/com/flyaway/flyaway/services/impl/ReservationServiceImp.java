package com.flyaway.flyaway.services.impl;

import com.flyaway.flyaway.domain.exception.ResourceNotFoundException;
import com.flyaway.flyaway.entity.Reservation;
import com.flyaway.flyaway.repository.ReservationRepository;
import com.flyaway.flyaway.services.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationServiceImp implements ReservationService {
    private final ReservationRepository reservationRepository;
    @Override
    public Reservation findById(Integer id) {
        return reservationRepository.findById(id.longValue())
                .orElseThrow(()->new ResourceNotFoundException(String.format("Reservation with ID %s doesnt exist",id)));
    }
}
