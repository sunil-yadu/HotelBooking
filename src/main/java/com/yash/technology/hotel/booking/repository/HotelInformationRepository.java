package com.yash.technology.hotel.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yash.technology.hotel.booking.entity.HotelInformation;

@Repository
public interface HotelInformationRepository extends JpaRepository<HotelInformation, String>{
	
}
