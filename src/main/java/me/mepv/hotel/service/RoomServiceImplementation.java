package me.mepv.hotel.service;

import lombok.extern.slf4j.Slf4j;
import me.mepv.hotel.dto.RoomDTO;
import me.mepv.hotel.repository.RoomRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Slf4j
public class RoomServiceImplementation implements RoomService {

    private final RoomRepository roomRepository;
    private final ModelMapper modelMapper;

    public RoomServiceImplementation(RoomRepository roomRepository, ModelMapper modelMapper) {
        this.roomRepository = roomRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Collection<RoomDTO> getAllRooms() {
        return null;
    }

    @Override
    public void deleteRoomById(Long id) {

    }
}
