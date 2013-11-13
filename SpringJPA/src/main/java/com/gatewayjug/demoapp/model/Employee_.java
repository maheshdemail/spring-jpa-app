package com.gatewayjug.demoapp.model;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(Employee.class)
public abstract class Employee_ {

	public static volatile SingularAttribute<Employee, Employee> manager;
	public static volatile SingularAttribute<Employee, Long> empId;
	public static volatile SingularAttribute<Employee, String> lastName;
	public static volatile ListAttribute<Employee, PhoneNumber> phoneNumbers;
	public static volatile SingularAttribute<Employee, EmploymentPeriod> period;
	public static volatile ListAttribute<Employee, Degree> degrees;
	public static volatile SingularAttribute<Employee, String> firstName;
	public static volatile SingularAttribute<Employee, Long> version;
	public static volatile ListAttribute<Employee, Employee> managedEmployees;
	public static volatile SingularAttribute<Employee, Address> address;
	public static volatile ListAttribute<Employee, String> responsibilities;
	public static volatile SingularAttribute<Employee, Gender> gender;
	public static volatile SingularAttribute<Employee, Double> salary;
	public static volatile MapAttribute<Employee, String, EmailAddress> emailAddresses;
	public static volatile SingularAttribute<Employee, JobTitle> jobTitle;

}

