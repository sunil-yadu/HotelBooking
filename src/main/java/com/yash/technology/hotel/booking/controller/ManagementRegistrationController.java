package com.yash.technology.hotel.booking.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yash.technology.hotel.booking.entity.ManagementRegistration;
import com.yash.technology.hotel.booking.entity.UserRegistration;
import com.yash.technology.hotel.booking.service.ManagementRegistrationImpl;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
@CrossOrigin(origins="http://localhost:3000")
@RestController
public class ManagementRegistrationController {

	//code to create object of logger
	private static final Logger logger = LoggerFactory.getLogger(ManagementRegistrationController.class);

	
	@Autowired
	private ManagementRegistrationImpl service;
	//code to save manager
	@PostMapping("/saveManager")
	public String saveManagement(@RequestBody ManagementRegistration mg)
	{
		this.service.save(mg);
		return "Data saved";
	}
	@ResponseBody
	@PostMapping("/getByManagementEmail")
	public String getByUserEmail(@RequestBody ManagementRegistration mg)
	{
		ManagementRegistration mr=service.getByEmail(mg.getRegistrationNumber());
		if(mr==null)
		{
			logger.error("registration number given by user not present so error occur");
			return "Invalid username or password";
		}
		//code to check password is correct or not
		if(!mr.getPassword().equals(mg.getPassword()))
		return "Invalid username or password";
		else
		{
			return "You can login";
		}
		
	} 
	//code to get all manager users
	@GetMapping("/getManagers")
	public List<ManagementRegistration> getManagers()
	{
		List<ManagementRegistration> lst=this.service.getManagers();
		if(lst==null)
		{
			logger.error("No manager is present");
			return null;
		}
		for(int i=0;i<lst.size();i++)
			lst.get(i).setPassword(null);
		logger.info("list of manager is created and will send");
		System.out.println(lst);
		return lst;
	}
	
	@GetMapping("/deleteManager/{num}")
	public String deleteManager(@PathVariable ("num") String num)
	{
		return this.service.deleteManager(num);
	}
}
