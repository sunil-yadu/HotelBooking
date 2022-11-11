package com.yash.technology.hotel.booking.service;

import java.util.List;

import com.yash.technology.hotel.booking.entity.UserRegistration;

public interface UserRegistrationService {
public UserRegistration saveUser(UserRegistration ur);

public UserRegistration getByEmail(String email);

public List<UserRegistration> getAllUsers();

public boolean isUserExist(String mail);

public String deleteUser(String email);
}
