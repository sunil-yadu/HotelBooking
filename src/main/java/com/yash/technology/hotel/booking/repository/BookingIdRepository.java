package com.yash.technology.hotel.booking.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yash.technology.hotel.booking.entity.BookingId;

@Repository
public interface BookingIdRepository extends CrudRepository<BookingId, String>{

}
