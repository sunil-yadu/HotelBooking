package com.yash.technology.hotel.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yash.technology.hotel.booking.entity.UserRegistration;
import com.yash.technology.hotel.booking.repository.UserRegistrationRepository;
@Service
public class UserRegistrationImpl implements UserRegistrationService{

	@Autowired
	private UserRegistrationRepository repository;
	
	@Override
	public UserRegistration saveUser(UserRegistration ur) {
		
		return this.repository.save(ur);
	}

	@Override
	public UserRegistration getByEmail(String email) {
		UserRegistration ur=null;
		try
		{
		ur=this.repository.findById(email).get();
		}catch(Exception e)
		{
//			System.out.println(e);
			return null;
		}
	//	System.out.println(ur);
		return ur;
	}

	@Override
	public List<UserRegistration> getAllUsers() {
		List<UserRegistration> ur=this.repository.findAll();
		if(ur==null)
		  return null;
		
		return ur;
	}

	@Override
	public boolean isUserExist(String mail) {
		return this.repository.existsById(mail);

	}

	@Override
	public String deleteUser(String email) {
		try
		{
		this.repository.deleteById(email);
		}
		catch(Exception e)
		{
			System.out.println(e);
			return "Some problem occur";
		}
		
		return "Data Deleted";
	}
	

}
