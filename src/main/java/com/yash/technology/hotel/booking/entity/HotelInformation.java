package com.yash.technology.hotel.booking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class HotelInformation implements java.io.Serializable{

	@Id
	private String registrationNumber;
	
	@Column(nullable=false)
	private String hotelName;
	private int totalRooms;
	private int availableAcRooms;
	private int availableNonAcRooms;
	private String address;

	@Column(nullable=false)
	private float charges;
	private int foodIncluded;
	private int isBar;
	private String image;
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public int getTotalRooms() {
		return totalRooms;
	}
	public void setTotalRooms(int totalRooms) {
		this.totalRooms = totalRooms;
	}
	public int getAvailableAcRooms() {
		return availableAcRooms;
	}
	public void setAvailableAcRooms(int availableAcRooms) {
		this.availableAcRooms = availableAcRooms;
	}
	public int getAvailableNonAcRooms() {
		return availableNonAcRooms;
	}
	public void setAvailableNonAcRooms(int availableNonAcRooms) {
		this.availableNonAcRooms = availableNonAcRooms;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public float getCharges() {
		return charges;
	}
	public void setCharges(float charges) {
		this.charges = charges;
	}
	public int isFoodIncluded() {
		return foodIncluded;
	}
	public void setFoodIncluded(int foodIncluded) {
		this.foodIncluded = foodIncluded;
	}
	public int isBar() {
		return isBar;
	}
	public void setBar(int isBar) {
		this.isBar = isBar;
	}
	@Override
	public String toString() {
		return "HotelInformation [registrationNumber=" + registrationNumber + ", hotelName=" + hotelName
				+ ", totalRooms=" + totalRooms + ", availableAcRooms=" + availableAcRooms + ", availableNonAcRooms="
				+ availableNonAcRooms + ", address=" + address + ", charges=" + charges + ", foodIncluded="
				+ foodIncluded + ", isBar=" + isBar + "]";
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
}
