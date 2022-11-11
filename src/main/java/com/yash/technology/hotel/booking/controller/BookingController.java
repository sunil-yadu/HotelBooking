package com.yash.technology.hotel.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yash.technology.hotel.booking.entity.Booking;
import com.yash.technology.hotel.booking.entity.TempBooking;
import com.yash.technology.hotel.booking.service.BookingSerivce;
import com.yash.technology.hotel.booking.service.TempBookingService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@CrossOrigin(origins="http://localhost:3000")
@RestController
public class BookingController {
	
	private static final Logger logger = LoggerFactory.getLogger(BookingController.class);
	 
	
	@Autowired
	private BookingSerivce service;
	
	@Autowired
	private TempBookingService tempService;
	
	@PostMapping("/saveBooking/{id}")
	public String saveBooking(@PathVariable ("id") String id)
	{
		logger.info("Booking data save in temporary table code starts here");
		
		
		
		return "Data saved";
	} 
	//here all the booking return for particular hotel registration number
	@GetMapping("/permanentBooking/{num}")
	public String  getBookings(@PathVariable ("num") String num)
	{
		List<TempBooking> lst=this.tempService.getAllBookingsById(num);
		Booking b=null;
		TempBooking tb=null;
		for(int i=0;i<lst.size();i++)
		{
			tb=lst.get(i);
			b=new Booking();
			b.setBookingId(tb.getBookingId());
			b.setContactNumber(tb.getContactNumber());
			b.setEmail(tb.getEmail());
			b.setEndDate(tb.getEndDate());
			b.setStartDate(tb.getStartDate());
			b.setGender(tb.getGender());
			b.setHotelRegistrationNumber(tb.getHotelRegistrationNumber());
			this.service.save(b);
		}
		return "All booking confirmed";
	}
	
}
