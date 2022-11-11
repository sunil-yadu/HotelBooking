package com.yash.technology.hotel.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.technology.hotel.booking.entity.TempBooking;
import com.yash.technology.hotel.booking.repository.TempBookingRepository;

@Service
public class TempBookingService {

	@Autowired
	private TempBookingRepository repository;
	
	public int doBooking(TempBooking booking)
	{
		System.out.println(booking.getBookingId()+" che cj j");
		TempBooking b=this.repository.save(booking);
		System.out.println(b.getBookingId());
		return 0;
	}
	
	public List<TempBooking> getAllBookingsById(String id)
	{
	
		return this.repository.getByBookingId(id);
	}
		
}
