package me.mepv.hotel.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hotels")
@SQLDelete(sql = "UPDATE hotels SET deleted = true where id=?")
@Where(clause = "deleted=false")
public class Hotel extends BaseEntity {

    @Column(name = "hotel_code", unique = true)
    private String hotelCode;
    private String name;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    private City city;
    @OneToMany(mappedBy = "hotel", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    private List<Room> rooms = new ArrayList<>();
    private boolean deleted = Boolean.FALSE;
}
