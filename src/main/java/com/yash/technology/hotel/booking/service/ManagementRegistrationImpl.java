package com.yash.technology.hotel.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.technology.hotel.booking.entity.ManagementRegistration;
import com.yash.technology.hotel.booking.repository.ManagementRegistrationRepository;

@Service
public class ManagementRegistrationImpl implements ManagementRegistrationService{

	@Autowired
	private ManagementRegistrationRepository repository;
	@Override
	public ManagementRegistration save(ManagementRegistration mg) {
		this.repository.save(mg);
		return null;
	}
	@Override
	public ManagementRegistration getByEmail(String email) {
		ManagementRegistration mr=null;
		try {
		mr=this.repository.findById(email).get();
		}catch(Exception e)
		{
			System.out.println("Some error occur");
			return mr=null;
		}
		
		return mr;
	}
	
	public List<ManagementRegistration> getManagers() {
		List<ManagementRegistration> lst=this.repository.findAll();
		return lst;
	}
	@Override
	public String deleteManager(String regNo) {
		
		try
		{
			System.out.println("checkck");
		this.repository.deleteById(regNo);
		}catch(Exception e)
		{
			System.out.println("some error occur");
			return "Some error occur";
		}
		return "Data deleted";
	}
	

}
