package com.yash.technology.hotel.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.technology.hotel.booking.entity.BookingId;
import com.yash.technology.hotel.booking.repository.BookingIdRepository;

@Service
public class BookingIdService {

	@Autowired
	private BookingIdRepository repository;
	
	public void addBookingId(BookingId id)
	{
		this.repository.save(id);
	}
	
	public String getPayment(String bookingId)
    {
        try
        {
            BookingId bi=this.repository.findById(bookingId).get();
            return String.valueOf(bi.getTotalPayment());
        }catch(Exception e)
        {
            return "Some error occur";
        }
    }
	public BookingId getById(String bookingId)
	{
		try
		{
		return this.repository.findById(bookingId).get();
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
}
