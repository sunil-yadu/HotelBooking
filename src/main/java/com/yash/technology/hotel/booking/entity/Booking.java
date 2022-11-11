package com.yash.technology.hotel.booking.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

@Entity
@Table(name="booking")
public class Booking {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String bookingId;
	private Date startDate;
	private Date endDate;
	private String email;
	@Column(nullable=false)
	private String contactNumber;
	@Column(nullable = false)
	private String firstName;
	@Column(nullable =false)
	private String lastName;
	@Column(name="hotel_number")
	private String hotelRegistrationNumber;
	@Column(nullable=false)
	private String gender;
	
	private long total;

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getHotelRegistrationNumber() {
		return hotelRegistrationNumber;
	}

	public void setHotelRegistrationNumber(String hotelRegistrationNumber) {
		this.hotelRegistrationNumber = hotelRegistrationNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", startDate=" + startDate + ", endDate=" + endDate + ", email="
				+ email + ", contactNumber=" + contactNumber + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", hotelRegistrationNumber=" + hotelRegistrationNumber + ", gender=" + gender + ", total=" + total
				+ "]";
	}


	
	
}
