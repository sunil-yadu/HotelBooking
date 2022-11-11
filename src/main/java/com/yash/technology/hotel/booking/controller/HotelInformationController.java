package com.yash.technology.hotel.booking.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yash.technology.hotel.booking.entity.HotelInformation;
import com.yash.technology.hotel.booking.service.HotelInformationImpl;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@CrossOrigin(origins="http://localhost:3000")
@RestController
public class HotelInformationController {
	private static final Logger logger = LoggerFactory.getLogger(BookingController.class);

	@Autowired
	private HotelInformationImpl service;
	@PostMapping("/saveHotelInformation")
	public String save(@RequestBody HotelInformation hi)
	{	
		this.service.saveHotelInformation(hi);
		return "Hotel saved";
	}
	
	@GetMapping("/getByHotelId/{id}")
	public List<HotelInformation> getInformationById(@PathVariable String id)
	{		
		List<HotelInformation> lst=this.service.getHotelInformation();
		for(int i=0;i<lst.size();i++)
		{
			if( !id.equals(lst.get(i).getRegistrationNumber()))
			{
				lst.remove(i);
			    i=i-1;
			}
		}
		return lst;
	}
	
	@GetMapping("/checkRooms/{num}")
	public List<HotelInformation> checkRooms(@PathVariable ("num") String num)
	{
		List<HotelInformation> lst=this.service.getHotelInformation();
		logger.info("All the hotel information are fetched");
		for(int i=0;i<lst.size();i++)
		{
			if(!lst.get(i).getRegistrationNumber().equals(num))
			{
				lst.remove(i);
			    i=i-1;
			}
		}
		logger.info("rooms availability information will send");
		return lst;
	}
	
}
