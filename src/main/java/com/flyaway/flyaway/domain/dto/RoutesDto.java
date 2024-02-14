package com.flyaway.flyaway.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoutesDto {

    private Long id;

    private String routeName;

    @NotEmpty
    @Size(max = 30,message = "Maximum size of name is 30")
    private String fromCountry;

    @NotEmpty
    @Size(max = 30,message = "Maximum size of name is 30")
    private String toCountry;

}
