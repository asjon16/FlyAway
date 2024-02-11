package com.flyaway.flyaway.domain.dto;
import com.flyaway.flyaway.entity.Route;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDto {


    private Long id;
    private LocalDateTime reservationTime;
    private Integer price;
    private String flight;
    @NotEmpty
    @Size(max = 30,message = "Maximum size of name is 30")
    private String user;

}
