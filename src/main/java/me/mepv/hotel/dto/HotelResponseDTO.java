package me.mepv.hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HotelResponseDTO {

    private String hotelCode;
    private String name;
    private CityDTO city;
}
