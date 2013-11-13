package com.gatewayjug.demoapp.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the DEMO_ADDRESS database table.
 * 
 */
@Entity
@Table(name = "DEMO_ADDRESS")
public class Address extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "DEMO_ADDRESS_SEQ_GENERATOR", sequenceName = "DEMO_ADDRESS_SEQ")
	@GeneratedValue(generator = "DEMO_ADDRESS_SEQ_GENERATOR")
	@Column(name = "ADDRESS_ID")
	private long addressId;
	@Basic
	private String city;

	@Basic
	private String country;

	@Basic
	@Column(name = "P_CODE")
	private String pCode;

	@Basic
	private String province;

	@Basic
	private String street;
	
	public Address() {
	}

	public long getAddressId() {
		return this.addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPCode() {
		return this.pCode;
	}

	public void setPCode(String pCode) {
		this.pCode = pCode;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

}