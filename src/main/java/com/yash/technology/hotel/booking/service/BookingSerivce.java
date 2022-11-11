package com.yash.technology.hotel.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.technology.hotel.booking.entity.Booking;
import com.yash.technology.hotel.booking.repository.BookingRepository;

@Service
public class BookingSerivce {
	
	@Autowired
	private BookingRepository repository;
	public String save(Booking booking)
	{
		try
		{
		this.repository.save(booking);
		}catch(Exception e)
		{
			//logger to print exception
			return null;
		}
  
		return "save";
	}
	
	public List<Booking> getAllBookings(String regNum)
	{
		List<Booking> lst=this.repository.getByRegistrationNum(regNum);
		return lst;
		
	}
	
}
