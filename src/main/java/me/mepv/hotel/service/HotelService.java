package me.mepv.hotel.service;

import me.mepv.hotel.dto.ApiResponse;
import me.mepv.hotel.dto.HotelRequestDTO;
import me.mepv.hotel.dto.HotelResponseDTO;

import java.util.Collection;

public interface HotelService {

    Collection<HotelResponseDTO> findAll();

    ApiResponse saveHotel(HotelRequestDTO hotelRequest);

    ApiResponse deleteHotelByHotelCode(String hotelCode);

    ApiResponse updateHotelByHotelCode(String hotelCode, HotelRequestDTO hotelRequest);
}
