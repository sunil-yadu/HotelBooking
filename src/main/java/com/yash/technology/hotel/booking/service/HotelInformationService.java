package com.yash.technology.hotel.booking.service;

import java.util.List;

import com.yash.technology.hotel.booking.entity.HotelInformation;

public interface HotelInformationService {

	public HotelInformation saveHotelInformation(HotelInformation hi);
	public List<HotelInformation> getHotelInformation();
	public HotelInformation getInformation(String registrationNumber);
	
}
