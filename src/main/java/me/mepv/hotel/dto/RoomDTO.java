package me.mepv.hotel.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RoomDTO {

    @JsonProperty(value = "room_number")
    private Integer roomNumber;
    private Integer floor;
    @JsonProperty(value = "room_type")
    private String roomType;
    private BigDecimal price;
    private HotelRequestDTO hotel;
}
