package com.yash.technology.hotel.booking.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BookingId {
	
	@Id
	private String bookingId;
	private int totalMembers;
	private int totalPayment;
	private int paymentComplete;
	private String hotelRegistrationNumber;
	private int totalDays;
	
	
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public int getTotalMembers() {
		return totalMembers;
	}
	public void setTotalMembers(int totalMembers) {
		this.totalMembers = totalMembers;
	}
	public int getTotalPayment() {
		return totalPayment;
	}
	public void setTotalPayment(int totalPayment) {
		this.totalPayment = totalPayment;
	}
	public int getPaymentComplete() {
		return paymentComplete;
	}
	public void setPaymentComplete(int paymentComplete) {
		this.paymentComplete = paymentComplete;
	}
	public String getHotelRegistrationNumber() {
		return hotelRegistrationNumber;
	}
	public void setHotelRegistrationNumber(String hotelRegistrationNumber) {
		this.hotelRegistrationNumber = hotelRegistrationNumber;
	}
	public int getTotalDays() {
		return totalDays;
	}
	public void setTotalDays(int totalDays) {
		this.totalDays = totalDays;
	}
	
	
	
	
}
