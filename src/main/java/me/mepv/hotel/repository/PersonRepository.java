package me.mepv.hotel.repository;

import me.mepv.hotel.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
