package com.yash.technology.hotel.booking.service;

import java.util.List;

import com.yash.technology.hotel.booking.entity.ManagementRegistration;


public interface ManagementRegistrationService {
public ManagementRegistration save(ManagementRegistration mg);

public ManagementRegistration getByEmail(String email);
public List<ManagementRegistration> getManagers();

public String deleteManager(String regNo);

}
