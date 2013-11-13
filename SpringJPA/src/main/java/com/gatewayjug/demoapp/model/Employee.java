package com.gatewayjug.demoapp.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.OrderColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * The persistent class for the DEMO_EMPLOYEE database table.
 * 
 */
@Entity
@Table(name = "DEMO_EMPLOYEE")
@SecondaryTable(name = "DEMO_SALARY")
@NamedQueries( { /* Static Named Queries, will be accessed by EntityMananger from DAO layer */
		@NamedQuery(name = "Employee.findAllEmployees", query = "FROM Employee e ORDER BY e.firstName, e.lastName ASC"),
		@NamedQuery(name = "Employee.findEmployeeByName", query = "FROM Employee e WHERE e.firstName LIKE ?1 OR e.lastName LIKE ?2 ORDER BY e.firstName, e.lastName ASC"),
		@NamedQuery(name = "Employee.findEmployeeBySalaries_Between", query = "FROM Employee e WHERE e.salary BETWEEN ?1 AND ?2 ORDER BY e.salary DESC"),
		@NamedQuery(name = "Employee.findEmployeeBySalaries_GreaterThan", query = "FROM Employee e WHERE e.salary >= ?1 ORDER BY e.salary DESC"),
		@NamedQuery(name = "Employee.findEmployeeBySalaries_LessThan", query = "FROM Employee e WHERE e.salary <= ?1 ORDER BY e.salary DESC"),
		@NamedQuery(name = "Employee.findEmployeeByGender_In", query = "FROM Employee e WHERE e.gender IN (?1) ORDER BY e.firstName, e.lastName ASC"),
		@NamedQuery(name = "Employee.findAllEmployees_JoinFetch", query = "FROM Employee e ORDER BY e.firstName, e.lastName ASC") })
public class Employee extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "EMP_ID")
	@SequenceGenerator(name = "DEMO_EMPLOYEE_SEQ_GENERATOR", sequenceName = "DEMO_EMPLOYEE_SEQ")
	@GeneratedValue(generator = "DEMO_EMPLOYEE_SEQ_GENERATOR")
	private long empId;

	@Column(name = "F_NAME")
	private String firstName;

	@Column(name = "GENDER")
	@Enumerated(EnumType.STRING)
	private Gender gender = Gender.Male;

	@Column(name = "L_NAME")
	private String lastName;

	@Version
	private long version;

	@Column(table = "DEMO_SALARY")
	private double salary;

	
	@Embedded
	private EmploymentPeriod period;

	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ADDR_ID")
	private Address address;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "DEMO_EMP_JOB", joinColumns = @JoinColumn(name = "EMP_ID"), inverseJoinColumns = @JoinColumn(name = "TITLE_ID"))
	private JobTitle jobTitle;

	
	@OneToMany(mappedBy = "owner", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true) /* orphanRemoval (JPA 2.0) */
	private List<PhoneNumber> phoneNumbers = new ArrayList<PhoneNumber>();

	/**
	 * 	orphanRemoval = true
	 * 
	 * 	1. If Target Entity is removed from owner collection or set as null, it will be removed from database during a flush
	 *	2. Equivalent to cascade = CascadeType.REMOVE - If parent entity is deleted and target entity will also be removed as well... 
	 */
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true) 
	@JoinColumn(name = "EMP_ID") // FK 
	@OrderBy("name ASC") /* with Basic Types (JPA 2.0) */
	private List<Degree> degrees = new ArrayList<Degree>(); /** Collection will be sorted by degree names */

	
	/** Used to indicate that the objects in the collection are stored in a collection table */
	@ElementCollection(fetch = FetchType.EAGER)  /* Collection of Basic Types (JPA 2.0) */ 
	@CollectionTable(name = "DEMO_RESPONS", joinColumns = @JoinColumn(name = "EMP_ID")) /* JPA 2.0 */ /** Can specify details of the collection table */
	@Column(name = "RESPONSIBILITY") 
	@OrderColumn(name = "PRIORITY") /* OrderColumn (JPA 2.0) */
	private List<String> responsibilities = new ArrayList<String>();

	
	@ElementCollection /* Collection of Embeddables (JPA 2.0) */ 
	@CollectionTable(name = "DEMO_EMAIL", joinColumns = @JoinColumn(name = "EMP_ID"))
	@Column(name = "EMAIL_ADDRESS")
	@MapKeyColumn(name = "EMAIL_TYPE")  /* MapKeyColumn (JPA 2.0) */
	private Map<String, EmailAddress> emailAddresses = new HashMap<String, EmailAddress>();

	
	public Employee() {
	}

	public long getEmpId() {
		return this.empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getVersion() {
		return this.version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public List<Degree> getDegrees() {
		return this.degrees;
	}

	public void setDegrees(List<Degree> degrees) {
		this.degrees = degrees;
	}

	public Map<String, EmailAddress> getEmailAddresses() {
		return emailAddresses;
	}

	public void setEmailAddresses(Map<String, EmailAddress> emailAddresses) {
		this.emailAddresses = emailAddresses;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public List<String> getResponsibilities() {
		return responsibilities;
	}

	public void setResponsibilities(List<String> responsibilities) {
		this.responsibilities = responsibilities;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public JobTitle getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(JobTitle jobTitle) {
		this.jobTitle = jobTitle;
	}

	public EmploymentPeriod getPeriod() {
		return period;
	}

	public void setPeriod(EmploymentPeriod period) {
		this.period = period;
	}

	public Degree addDegree(String degree) {
		return addDegree(new Degree(degree));
	}

	public Degree addDegree(Degree degree) {
		getDegrees().add(degree);
		return degree;
	}

	public Degree removeDegree(Degree degree) {
		getDegrees().remove(degree);
		return degree;
	}

	public PhoneNumber addPhoneNumber(PhoneNumber phoneNumber) {
		getPhoneNumbers().remove(phoneNumber);
		getPhoneNumbers().add(phoneNumber);
		phoneNumber.setOwner(this);
		return phoneNumber;
	}

	public PhoneNumber addPhoneNumber(String type, String areaCode, String number) {
		PhoneNumber phoneNumber = new PhoneNumber(type, areaCode, number);
		return addPhoneNumber(phoneNumber);
	}

	public PhoneNumber removePhoneNumber(PhoneNumber phoneNumber) {
		getPhoneNumbers().remove(phoneNumber);
		phoneNumber.setOwner(null);
		return phoneNumber;
	}

	public void addResponsibility(String responsibility) {
		getResponsibilities().add(responsibility);
	}

	public void removeResponsibility(String responsibility) {
		getResponsibilities().remove(responsibility);
	}

	public EmailAddress addEmailAddress(String type, String address) {
		return addEmailAddress(type, new EmailAddress(address));
	}

	public EmailAddress addEmailAddress(String type, EmailAddress address) {
		return getEmailAddresses().put(type, address);
	}

	public EmailAddress removeEmailAddress(String type) {
		return getEmailAddresses().remove(type);
	}

	public EmailAddress getEmailAddress(String type) {
		return getEmailAddresses().get(type);
	}

}