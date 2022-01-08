package me.mepv.hotel.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hotel_bookings")
public class HotelBooking extends BaseEntity {

    @Column(name = "date_from")
    private LocalDate dateFrom;
    @Column(name = "date_to")
    private LocalDate dateTo;
    @Column(name = "people_amount")
    private Integer peopleAmount;
    @Column(name = "booking_date")
    @CreationTimestamp
    private LocalDate bookingDate;
    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Person> people;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Payment payment;
    @Column(name = "total_price")
    private Double totalPrice;
}
