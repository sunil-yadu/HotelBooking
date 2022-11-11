package com.yash.technology.hotel.booking.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yash.technology.hotel.booking.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer>{

/*	@Transactional
    @Modifying
    @Query("delete from cart_details where customer_id=?1 and product_id=?2")
    public void removeProductFromCart(int customer_id, int product_id);*/
	
	@Transactional
	@Modifying
	@Query(value="select booking_id,contact_number,email,end_date,first_name,last_name,gender,last_name,start_date,end_date from booking where hotel_number=?1",nativeQuery=true)
	public List<Booking> getByRegistrationNum(String hotel_number);
	
}
