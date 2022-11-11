package com.yash.technology.hotel.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.technology.hotel.booking.entity.HotelInformation;
import com.yash.technology.hotel.booking.repository.HotelInformationRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@Service
public class HotelInformationImpl implements HotelInformationService{

	private static final Logger logger = LoggerFactory.getLogger(HotelInformationImpl.class);

	@Autowired
	private HotelInformationRepository repository;
	@Override
	public HotelInformation saveHotelInformation(HotelInformation hi) {
		HotelInformation h=this.repository.save(hi);
		logger.info("hotal information was saved in database");
		return h;
	}
	//code to fetch information of all hotels
	@Override
	public List<HotelInformation> getHotelInformation()
	{
		
		List<HotelInformation> lst= this.repository.findAll();
		logger.info("hotel information was fetched and will send");
		return lst;
	}
	
	//code to get hotel information of particular id
	@Override
	public HotelInformation getInformation(String registrationNumber) {
		HotelInformation hi=this.repository.findById(registrationNumber).get();
		if(hi==null)
		{
			logger.error("hotel is not present of given registration number");
			return null;
		}
		return hi;
	}	
}
