package com.flyaway.flyaway.domain.mapper;

import com.flyaway.flyaway.domain.dto.ReservationDto;
import com.flyaway.flyaway.entity.Reservation;

public class ReservationMapper {

    public static Reservation toEntity(ReservationDto dto){
        Reservation reservation = new Reservation();
        reservation.setId(dto.getId());
        reservation.setReservationTime(dto.getReservationTime());
        reservation.setPrice(dto.getPrice());
        return  reservation;
    }

    public static ReservationDto toDto(Reservation reservation){
        ReservationDto reservationDto = new ReservationDto();
        reservationDto.setReservationTime(reservation.getReservationTime());
        reservationDto.setPrice(reservation.getPrice());
        reservationDto.setUser(reservation.getUser().getName());
        reservationDto.setRoutes(reservation.getRoutes().toString());
        return reservationDto;
    }
}
