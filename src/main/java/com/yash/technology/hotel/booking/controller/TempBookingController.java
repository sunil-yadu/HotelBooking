package com.yash.technology.hotel.booking.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.technology.hotel.booking.entity.BookingId;
import com.yash.technology.hotel.booking.entity.HotelInformation;
import com.yash.technology.hotel.booking.entity.TempBooking;
import com.yash.technology.hotel.booking.entity.UserRegistration;
import com.yash.technology.hotel.booking.service.TempBookingService;
import com.yash.technology.hotel.booking.service.BookingIdService;
import com.yash.technology.hotel.booking.service.HotelInformationImpl;
import com.yash.technology.hotel.booking.service.UserRegistrationService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class TempBookingController {

	@Autowired
	private TempBookingService service;

	@Autowired
	private HotelInformationImpl hotelService;

	@Autowired
	private BookingIdService bookingService;

	public static String createId(String name, String number, String gender, String lastName) {
		char c1[] = name.toCharArray();
		char c2[] = number.toCharArray();
		char c3[] = lastName.toCharArray();
		String id = "";
		for (int i = 0; i < 3; i++)
			id += Character.toString(c1[i]);
		id += gender;
		for (int i = 0; i < 3; i++)
			id += Character.toString(c2[i]);
		for (int i = 0; i < 3; i++)
			id += Character.toString(c3[i]);
		Random r = new Random();
		int x = r.nextInt(99);
		id += String.valueOf(x);
		return id;
	}
	  public int calculateTotalPayment(int days,int charges,int totalGuest)
	    {
//	        b.setTotalPayment((days*(int)(hi.getCharges()))*userList.size());

	        int roomsRequired=1;
	        if(totalGuest<=3)
	        {
	            return roomsRequired*days*charges;
	        }
	        roomsRequired=totalGuest/3;
	        if(totalGuest%3!=0)
	            roomsRequired+=1;
	        return roomsRequired*days*charges;
	    }

	public static long calculateDays(Date startDate, Date endDate) {
		long dateBeforeInMs = endDate.getTime();
		long dateBeforeInMs1 = startDate.getTime();
		long timeDiff = Math.abs(dateBeforeInMs - dateBeforeInMs1);
		long daysDiff = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);
		return daysDiff;
	}

	private UserRegistrationService s;

	// (String name,String number,String gender,String lastName)
	@PostMapping("/booking")
	public String hotelBooking(@RequestBody List<TempBooking> userList) {
		System.out.println("user List" + userList.size());
		TempBooking tb = userList.get(0);
		String bookingId = createId(tb.getFirstName(), tb.getContactNumber(), tb.getGender(), tb.getLastName());
		tb.setBookingId(bookingId);
		int days = (int) calculateDays(tb.getStartDate(), tb.getEndDate());
		BookingId b = new BookingId();
		b.setBookingId(bookingId);
		b.setTotalDays(days);
		b.setHotelRegistrationNumber(tb.getHotelRegistrationNumber());
		b.setPaymentComplete(0);
		b.setTotalMembers(userList.size());
		HotelInformation hi;
		try {
			hi = this.hotelService.getInformation(tb.getHotelRegistrationNumber());
		} catch (Exception e) {
			return "Hotel id do not exists";
		}

//        b.setTotalPayment((days*(int)(hi.getCharges()))*userList.size());      
		int payment = calculateTotalPayment(days, (int) hi.getCharges(), userList.size());
		b.setTotalPayment(payment);
		// code to save booking information in database
		this.bookingService.addBookingId(b);

		for (int i = 0; i < userList.size(); i++) {
			System.out.println("Booking id" + bookingId);
			tb = userList.get(i);
			tb.setBookingId(bookingId);
			this.service.doBooking(tb);
		}
		return bookingId;
	}

	@RequestMapping("/getDetails/{id}")
	public String getInformationOfBooking(@PathVariable("id") String id) {
		System.out.println(id);
		try {
			BookingId data = this.bookingService.getById(id);
			if (data == null) {
				return "Some error occur";
			}
			return String.valueOf(data.getTotalPayment());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "chec";
	}
    //code related to send total Payment
    @GetMapping("/getPayment/{id}")
    public String getPayment(@PathVariable ("id") String id)
    {
        String payment=this.bookingService.getPayment(id);
        return payment;
    }

}
/*
 * Date dateBefore = new Date(2022, Calendar.APRIL, 21); Date dateAfter = new
 * Date(2022, Calendar.APRIL, 25);
 * 
 * long dateBeforeInMs = dateBefore.getTime(); long dateAfterInMs =
 * dateAfter.getTime();
 * 
 * long timeDiff = Math.abs(dateAfterInMs - dateBeforeInMs);
 * 
 * long daysDiff = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);
 */
