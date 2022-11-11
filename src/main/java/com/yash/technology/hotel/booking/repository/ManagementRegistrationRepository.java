package com.yash.technology.hotel.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.technology.hotel.booking.entity.ManagementRegistration;

@Repository
public interface ManagementRegistrationRepository extends JpaRepository<ManagementRegistration, String>{

	
}
