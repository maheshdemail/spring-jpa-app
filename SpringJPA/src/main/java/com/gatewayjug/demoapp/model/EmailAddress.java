package com.gatewayjug.demoapp.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EmailAddress {
	@Column(name = "EMAIL_ADDRESS")
	private String address;

	public EmailAddress() {
	}

	public EmailAddress(String address) {
		setAddress(address);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
