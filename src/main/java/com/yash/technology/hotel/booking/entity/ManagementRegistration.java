package com.yash.technology.hotel.booking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;

@Entity
public class ManagementRegistration {
	 
		@Column(nullable = false)
		private String clientName;
		@Column(nullable = false)
		private String mobileNumber;
		@Id
		@Column(nullable = false)
		private String registrationNumber;
		@Column(unique = true,nullable = false)
		private String email;
		@Column(nullable=false)
		private String password;
		@Column(nullable=false)
		private String hotelName;
		
	
	public String getHotelName() {
			return hotelName;
		}
		public void setHotelName(String hotelName) {
			this.hotelName = hotelName;
		}
	public String getRegistrationNumber() {
			return registrationNumber;
		}
		public void setRegistrationNumber(String registrationNumber) {
			this.registrationNumber = registrationNumber;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "ManagementRegistration [clientName=" + clientName + ", mobileNumber=" + mobileNumber
				+ ", registrationNumber=" + registrationNumber + ", email=" + email + ", password=" + password
				+ ", hotelName=" + hotelName + "]";
	}
	
	
}
