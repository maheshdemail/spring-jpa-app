package com.gatewayjug.demoapp.dto;

import java.io.Serializable;
import java.util.List;

/**
* Employee Data Transfer Object
* 
* @author Mahesh Desai
* @version $Revision: 1.0
*/
public class EmployeeDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String employeeId;
	private String firstName;
	private String lastName;
	private String gender;
	private String endDate;
	private String startDate;
	
	private String city;
	private String country;
	private String zipCode;
	private String province;
	private String street;
	private List<String> degree;
	private String email;
	private String phoneType;
	private String areaCode;
	private String jobTitle;
	private String phoneIsdn;
	private String phoneWorkFax;
	private String phoneWork;
	private String phoneCellular;
	private String phonePager;
	private String salary;
	private String responsibility;
	
	private String phoneIsdnAreaCode;
	private String phoneWorkFaxAreaCode;
	private String phoneWorkAreaCode;
	private String phoneCellularAreaCode;
	private String phonePagerAreaCode;

	private String name;
	private String address;
	private String allPhones;
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public List<String> getDegree() {
		return degree;
	}
	public void setDegree(List<String> degree) {
		this.degree = degree;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneType() {
		return phoneType;
	}
	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getPhoneIsdn() {
		return phoneIsdn;
	}
	public void setPhoneIsdn(String phoneIsdn) {
		this.phoneIsdn = phoneIsdn;
	}
	public String getPhoneWorkFax() {
		return phoneWorkFax;
	}
	public void setPhoneWorkFax(String phoneWorkFax) {
		this.phoneWorkFax = phoneWorkFax;
	}
	public String getPhoneWork() {
		return phoneWork;
	}
	public void setPhoneWork(String phoneWork) {
		this.phoneWork = phoneWork;
	}
	public String getPhoneCellular() {
		return phoneCellular;
	}
	public void setPhoneCellular(String phoneCellular) {
		this.phoneCellular = phoneCellular;
	}
	public String getPhonePager() {
		return phonePager;
	}
	public void setPhonePager(String phonePager) {
		this.phonePager = phonePager;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getResponsibility() {
		return responsibility;
	}
	public void setResponsibility(String responsibility) {
		this.responsibility = responsibility;
	}
	public String getPhoneIsdnAreaCode() {
		return phoneIsdnAreaCode;
	}
	public void setPhoneIsdnAreaCode(String phoneIsdnAreaCode) {
		this.phoneIsdnAreaCode = phoneIsdnAreaCode;
	}
	public String getPhoneWorkFaxAreaCode() {
		return phoneWorkFaxAreaCode;
	}
	public void setPhoneWorkFaxAreaCode(String phoneWorkFaxAreaCode) {
		this.phoneWorkFaxAreaCode = phoneWorkFaxAreaCode;
	}
	public String getPhoneWorkAreaCode() {
		return phoneWorkAreaCode;
	}
	public void setPhoneWorkAreaCode(String phoneWorkAreaCode) {
		this.phoneWorkAreaCode = phoneWorkAreaCode;
	}
	public String getPhoneCellularAreaCode() {
		return phoneCellularAreaCode;
	}
	public void setPhoneCellularAreaCode(String phoneCellularAreaCode) {
		this.phoneCellularAreaCode = phoneCellularAreaCode;
	}
	public String getPhonePagerAreaCode() {
		return phonePagerAreaCode;
	}
	public void setPhonePagerAreaCode(String phonePagerAreaCode) {
		this.phonePagerAreaCode = phonePagerAreaCode;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return address;
	}
	public String getAllPhones() {
		return allPhones;
	}
	public void setAllPhones(String allPhones) {
		this.allPhones = allPhones;
	}
	
}
