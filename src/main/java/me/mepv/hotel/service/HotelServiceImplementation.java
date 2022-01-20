package me.mepv.hotel.service;

import lombok.extern.slf4j.Slf4j;
import me.mepv.hotel.dto.ApiResponse;
import me.mepv.hotel.dto.HotelRequestDTO;
import me.mepv.hotel.dto.HotelResponseDTO;
import me.mepv.hotel.dto.RoomDTO;
import me.mepv.hotel.entity.City;
import me.mepv.hotel.entity.Hotel;
import me.mepv.hotel.entity.Room;
import me.mepv.hotel.entity.RoomType;
import me.mepv.hotel.exception.HotelException;
import me.mepv.hotel.exception.NoDataException;
import me.mepv.hotel.repository.HotelRepository;
import me.mepv.hotel.repository.RoomTypeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static me.mepv.hotel.dto.ApiResponse.*;

@Service
@Slf4j
public class HotelServiceImplementation implements HotelService {

    private final HotelRepository hotelRepository;
    private final RoomTypeRepository roomTypeRepository;
    private final ModelMapper modelMapper;

    public HotelServiceImplementation(HotelRepository hotelRepository,
                                      RoomTypeRepository roomTypeRepository,
                                      ModelMapper modelMapper) {
        this.hotelRepository = hotelRepository;
        this.roomTypeRepository = roomTypeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Collection<HotelResponseDTO> findAll() {
        return hotelRepository.findAll()
                .stream()
                .map(hotel -> modelMapper.map(hotel, HotelResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ApiResponse saveHotel(HotelRequestDTO hotelRequest) {
        List<RoomDTO> roomsDTO = hotelRequest.getRooms();
        roomsDTO.forEach(room -> room.setHotel(hotelRequest));

        Hotel hotel = modelMapper.map(hotelRequest, Hotel.class);
        List<Room> rooms = hotel.getRooms();

        for (int i = 0; i < roomsDTO.size(); i++) {
            getRoomTypeAndSet(roomsDTO, rooms, i);
        }
        hotelRepository.save(hotel);
        return new ApiResponse(message(HOTEL_CREATED));
    }

    /* todo: spring security implement logic for soft deletion in order to the data be accessible
        for administrator-level has full access to al the data */
    @Override
    public ApiResponse deleteHotelByHotelCode(String hotelCode) {
        Hotel hotel = getHotel(hotelCode);
        hotelRepository.deleteById(hotel.getId());
        return new ApiResponse(message(HOTEL_DELETED));
    }

    @Override
    @Transactional
    public ApiResponse updateHotelByHotelCode(String hotelCode, HotelRequestDTO hotelRequest) {
        Hotel hotel = getHotel(hotelCode);
        hotelRepository.save(updateHotel(hotelRequest, hotel));
        return new ApiResponse(message(HOTEL_UPDATED));
    }

    private Hotel getHotel(String hotelCode) {
        Optional<Hotel> optional = hotelRepository.findByHotelCode(hotelCode);
        if (optional.isPresent()) return optional.get();
        else {
            log.info(String.format("getHotel() // No data for hotel %s", hotelCode));
            throw new HotelException(String.format("No data for hotel: %s", hotelCode));
        }
    }

    private Hotel updateHotel(HotelRequestDTO hotelRequest, Hotel hotel) {
        if (hotelRequest.getHotelCode() != null && !hotelRequest.getHotelCode().equals(hotel.getHotelCode())) {
            hotel.setHotelCode(hotelRequest.getHotelCode());
        }
        if (hotelRequest.getName() != null && !hotelRequest.getName().equals(hotel.getName())) {
            hotel.setName(hotelRequest.getName());
        }
        if (hotelRequest.getCity().getName() != null && !hotelRequest.getCity().getName().equals(hotel.getCity().getName())) {
            hotel.setCity(modelMapper.map(hotelRequest.getCity(), City.class));
        }
        List<Room> rooms = hotel.getRooms();
        List<RoomDTO> roomsDTO = hotelRequest.getRooms();
        for (int i = 0; i < roomsDTO.size(); i++) {
            if (roomsDTO.get(i).getPrice() != null && !roomsDTO.get(i).getPrice().equals(rooms.get(i).getPrice())) {
                rooms.get(i).setPrice(roomsDTO.get(i).getPrice());
            }
            if (roomsDTO.get(i).getRoomType() != null && !roomsDTO.get(i).getRoomType().equals(rooms.get(i).getRoomType().getType())) {
                getRoomTypeAndSet(roomsDTO, rooms, i);
            }
        }
        return hotel;
    }

    private void getRoomTypeAndSet(List<RoomDTO> roomsDTO, List<Room> rooms, int i) {
        Optional<RoomType> optional = roomTypeRepository.findByType(roomsDTO.get(i).getRoomType());
        RoomType roomType;
        if (optional.isPresent()) roomType = optional.get();
        else {
            log.info(String.format("getRoomTypeAndSet() // No data for room id %s", i));
            throw new NoDataException("Internal server error");
        }
        rooms.get(i).setRoomType(roomType);
    }
}
