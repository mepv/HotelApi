package me.mepv.hotel.repository;

import me.mepv.hotel.entity.HotelBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelBookingRepository extends JpaRepository<HotelBooking, Long> {
}
