package me.mepv.hotel.service;

import me.mepv.hotel.dto.RoomDTO;

import java.util.Collection;

public interface RoomService {

    Collection<RoomDTO> getAllRooms();

    void deleteRoomById(Long id);
}
