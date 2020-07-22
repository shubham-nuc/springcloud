package com.mycomp.dao.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@Table(name="USER_ADDRESS")
public class AddressEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long addressId;
	
	@Column(name="HOUSE_NO")
	private String houseNo;
	
	@Column(name="BUILDING_NAME")
	private String buildingName;
	
	@Column(name="STREET_NAME")
	private String StreetName;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="STATE")
	private String state;
	
	@Column(name="COUNTRY")
	private String country;
	
	@Column(name="PINCODE")
	private int pincode;
	
	@Version
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LOCK_VERSION",nullable = false)
    private Date version;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="USER_ID", nullable=false,insertable=true,updatable=true) // This is to give name to reference id column, 
	//otherwise hibernate will give its own name like user_user_id
	private UserEntity user;

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getStreetName() {
		return StreetName;
	}

	public void setStreetName(String streetName) {
		StreetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
		//this.setUser123(user123);
	}

	public Date getVersion() {
		return version;
	}

	public void setVersion(Date version) {
		this.version = version;
	}
}
