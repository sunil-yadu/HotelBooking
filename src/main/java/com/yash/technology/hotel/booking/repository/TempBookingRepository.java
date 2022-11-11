package com.yash.technology.hotel.booking.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yash.technology.hotel.booking.entity.TempBooking;

@Repository
public interface TempBookingRepository extends JpaRepository<TempBooking, Integer>{

	@Transactional
	@Modifying
	@Query(value="select booking_id,contact_number,email,end_date,start_date,first_name,last_name,gender,hotel_registration_number from temp_booking where booking_id=?1",nativeQuery=true)
	public List<TempBooking> getByBookingId(String booking_id);

}
