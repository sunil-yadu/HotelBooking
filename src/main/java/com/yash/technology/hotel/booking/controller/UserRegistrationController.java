package com.yash.technology.hotel.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.technology.hotel.booking.entity.UserRegistration;
import com.yash.technology.hotel.booking.service.UserRegistrationImpl;

import java.util.List;
import java.util.Random;   

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@CrossOrigin(origins="http://localhost:3000")
@RestController
public class UserRegistrationController {
	//create object of logger
	private static final Logger logger = LoggerFactory.getLogger(UserRegistrationController.class);

	private String  otp="-1";
	@Autowired
	private UserRegistrationImpl service;
	
	@Autowired
	private EmailSenderService emailService; 

	//code to save data of user
	@PostMapping("/register")
	public String saveUser(@RequestBody UserRegistration ur)
	{
		if(this.service.isUserExist(ur.getEmail()))
		{
			return "User already exists";
		}
		service.saveUser(ur);
		logger.info("User data is saved");
		return "User Registered";
	}
	
	//update user

	@PostMapping("/editUser")
	public String updateUser(@RequestBody UserRegistration ur)
	{
		service.saveUser(ur);
		logger.info("User data is Edited");
		return "User Edited";
	}

	
	
	//code to do authentication of user at time of login starts here
	@RequestMapping("/getByUserEmail")
	public String getByUserEmail(@RequestBody UserRegistration ur)
	{
		
		UserRegistration uCheck=service.getByEmail(ur.getEmail());
		if(uCheck==null)
		{
			logger.error("Username given by user at the login is not present so error occur");
			return "Invalid username or password";
		}
		if(!uCheck.getPassword().equals(ur.getPassword()))
		{
			
			return "Invalid username or password";
		}
		logger.info("username and password are correct so user can login");
		return "You can login	";
	}
	
	//code to return list of users starts here
	@GetMapping("/allUsers")
	public List<UserRegistration> getUsers()
	{
		List<UserRegistration> lst=this.service.getAllUsers();
		if(lst==null)
		{
			logger.error("There is no user present so null value returns");
		return null;
		}
		//code to set password null so no one able to see password of user
		for(int i=0;i<lst.size();i++)
			lst.get(i).setPassword(null);
		logger.info("user data returns from server side");
		return lst;
	}
	
	
	//Code to send otp 
	
	public void triggerMail(String sendTo,String otp)
	{
		emailService.sendSimpleEmail(sendTo, otp,"Hotel Booking OTP");
	}
	
	@GetMapping("/getOtp/{email}")
	public String getOtp(@PathVariable ("email") String email)
	{
		Random r=new Random();
		int x=r.nextInt(1000,9999);
		otp=String.valueOf(x);
		triggerMail(email, otp);
		return "Email is send";
	}
	
	@GetMapping("/validateOtp/{checkOtp}")
	public String validateUser(@PathVariable("checkOtp") String checkOtp)
	{
		if(checkOtp.equals(otp))
		{
			otp="-1";
			return "you can login";
		}
		else
		{
			return "Invalid Otp";
		}
	}
	
	@GetMapping("/delete/{email}")
	public String deleteUser(@PathVariable ("email") String email)
	{
		
		return this.service.deleteUser(email);
	}
	
}
