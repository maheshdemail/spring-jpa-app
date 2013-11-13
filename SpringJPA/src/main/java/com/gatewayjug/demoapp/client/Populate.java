package com.gatewayjug.demoapp.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.gatewayjug.demoapp.model.Address;
import com.gatewayjug.demoapp.model.Employee;
import com.gatewayjug.demoapp.model.EmploymentPeriod;
import com.gatewayjug.demoapp.model.Gender;
import com.gatewayjug.demoapp.model.JobTitle;

/**
 * This example populates the database with example instances using JPA.
 * 
 * @author Mahesh Desai
 * @version $1.0
 */
public class Populate {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("DemoSpecialityService");
		populate(emf);
		emf.close();
	}

	public static void populate(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Populate.population.persistAll(em);
		em.getTransaction().commit();
		em.close();
	}

	public static final Populate population = new Populate();

	public Employee[] employees = { basicDemoEmployeeExample1(),
			basicDemoEmployeeExample2(), basicDemoEmployeeExample3(),
			basicDemoEmployeeExample4(), basicDemoEmployeeExample5(),
			basicDemoEmployeeExample6(), basicDemoEmployeeExample7(),
			basicDemoEmployeeExample8(), basicDemoEmployeeExample9(),
			basicDemoEmployeeExample10(), basicDemoEmployeeExample11(),
			basicDemoEmployeeExample12() };

	private JobTitle[] jobTitles = { new JobTitle("CEO"),
			new JobTitle("VP"), new JobTitle("Manager"),
			new JobTitle("Developer"), new JobTitle("Admin") };

	private Populate() {

		// Setup management hierarchy
		setJobTitle(0, 2);
		setJobTitle(1, 2);
		setJobTitle(0, 3);
		setJobTitle(0, 3);
		setJobTitle(0, 3);
		setJobTitle(5, 4);
		setJobTitle(6, 4);
		setJobTitle(7, 1);
		setJobTitle(8, 4);
		setJobTitle(9, 0);
		setJobTitle(10, 1);
		setJobTitle(11, 1);

	}

	public Employee basicDemoEmployeeExample1() {
		Employee employee = new Employee();

		employee.setFirstName("Bob");
		employee.setLastName("Smith");
		employee.setGender(Gender.Male);
		employee.setSalary(35000);

		EmploymentPeriod employmentPeriod = new EmploymentPeriod();
		employmentPeriod.setEndDate(1996, 0, 1);
		employmentPeriod.setStartDate(1993, 0, 1);
		employee.setPeriod(employmentPeriod);

		Address address = new Address();
		address.setCity("Toronto");
		address.setPCode("L5J2B5");
		address.setProvince("ONT");
		address.setStreet("1450 Acme Cr., Suite 4");
		address.setCountry("Canada");
		employee.setAddress(address);

		employee.addResponsibility("Water the office plants.");
		employee.addResponsibility("Maintain the kitchen facilities.");
		employee.addPhoneNumber("Work", "613", "5558812");

		return employee;
	}

	public Employee basicDemoEmployeeExample10() {
		Employee employee = new Employee();

		employee.setFirstName("Jill");
		employee.setLastName("May");
		employee.setGender(Gender.Female);

		EmploymentPeriod employmentPeriod = new EmploymentPeriod();
		employmentPeriod.setStartDate(1991, 10, 11);
		employee.setPeriod(employmentPeriod);

		Address address = new Address();
		address.setCity("Calgary");
		address.setPCode("J5J2B5");
		address.setProvince("AB");
		address.setStreet("1111 Mooseland Rd.");
		address.setCountry("Canada");
		employee.setAddress(address);

		employee.setSalary(56232);
		employee.addPhoneNumber("Work", "613", "5558812");
		employee.addPhoneNumber("Work Fax", "613", "5555943");
		employee.addEmailAddress("Work", "jill.may@acme.com");
		employee.addEmailAddress("Mobile", "jill.lewis.may@sprint.com");
		employee.addDegree("Bachelor Computer Science");
		employee.addDegree("Masters Computer Science");
		employee.addDegree("PHD Computer Science");

		return employee;
	}

	public Employee basicDemoEmployeeExample11() {
		Employee employee = new Employee();

		employee.setFirstName("Sarah-Lou");
		employee.setLastName("Smitty");
		employee.setGender(Gender.Female);

		EmploymentPeriod employmentPeriod = new EmploymentPeriod();
		employmentPeriod.setEndDate(1996, 0, 1);
		employmentPeriod.setStartDate(1993, 0, 1);
		employee.setPeriod(employmentPeriod);

		Address address = new Address();
		address.setCity("Arnprior");
		address.setPCode("W1A2B5");
		address.setProvince("ONT");
		address.setStreet("1 Hawthorne Drive");
		address.setCountry("Canada");
		employee.setAddress(address);

		employee.setSalary(75000);
		employee.addPhoneNumber("Work Fax", "613", "5555943");
		employee.addPhoneNumber("Home", "613", "5551234");
		employee.addPhoneNumber("Cellular", "416", "5551111");
		employee.addEmailAddress("Home", "sarah-lou.smitty@rogers.com");
		employee.addDegree("Bachelor Computer Science");

		return employee;
	}

	public Employee basicDemoEmployeeExample12() {
		Employee employee = new Employee();

		employee.setFirstName("Jim-Bob");
		employee.setLastName("Jefferson");
		employee.setGender(Gender.Male);

		EmploymentPeriod employmentPeriod = new EmploymentPeriod();
		employmentPeriod.setEndDate(2001, 11, 31);
		employmentPeriod.setStartDate(1995, 0, 12);
		employee.setPeriod(employmentPeriod);

		Address address = new Address();
		address.setCity("Yellowknife");
		address.setPCode("Y5J2N5");
		address.setProvince("YK");
		address.setStreet("1112 Gold Rush Rd.");
		address.setCountry("Canada");
		employee.setAddress(address);

		employee.setSalary(50000);
		employee.addPhoneNumber("Home", "613", "5551234");
		employee.addPhoneNumber("Cellular", "416", "5551111");
		employee.addEmailAddress("Home", "jim-bob@jim-bob.com");

		return employee;
	}

	public Employee basicDemoEmployeeExample2() {
		Employee employee = new Employee();

		employee.setFirstName("John");
		employee.setLastName("Way");
		employee.setGender(Gender.Male);
		employee.setSalary(53000);

		EmploymentPeriod employmentPeriod = new EmploymentPeriod();
		employmentPeriod.setStartDate(1991, 10, 11);
		employee.setPeriod(employmentPeriod);

		Address address = new Address();
		address.setCity("Ottawa");
		address.setPCode("K5J2B5");
		address.setProvince("ONT");
		address.setStreet("12 Merivale Rd., Suite 5");
		address.setCountry("Canada");
		employee.setAddress(address);

		employee.addResponsibility("Hire people when more people are required.");
		employee.addResponsibility("Lay off employees when less people are required.");
		employee.addPhoneNumber("Work", "613", "5558812");
		employee.addPhoneNumber("ISDN", "905", "5553691");
		employee.addEmailAddress("Work", "john.way@acme.com");
		employee.addDegree("Bachelor Computer Science");

		return employee;
	}

	public Employee basicDemoEmployeeExample3() {
		Employee employee = new Employee();

		employee.setFirstName("Charles");
		employee.setLastName("Chanley");
		employee.setGender(Gender.Male);
		employee.setSalary(43000);

		EmploymentPeriod employmentPeriod = new EmploymentPeriod();
		employmentPeriod.setEndDate(2001, 11, 31);
		employmentPeriod.setStartDate(1995, 0, 1);
		employee.setPeriod(employmentPeriod);

		Address address = new Address();
		address.setCity("Montreal");
		address.setPCode("Q2S5Z5");
		address.setProvince("QUE");
		address.setStreet("1 Canadien Place");
		address.setCountry("Canada");
		employee.setAddress(address);

		employee.addResponsibility("Perform code reviews as required.");
		employee.addPhoneNumber("Pager", "976", "5556666");
		employee.addPhoneNumber("ISDN", "905", "5553691");
		employee.addEmailAddress("Work", "charles.chanley@acme.com");

		return employee;
	}

	public Employee basicDemoEmployeeExample4() {
		Employee employee = new Employee();

		employee.setFirstName("Emanual");
		employee.setLastName("Smith");
		employee.setGender(Gender.Male);
		employee.setSalary(49631);

		EmploymentPeriod employmentPeriod = new EmploymentPeriod();
		employmentPeriod.setEndDate(2001, 11, 31);
		employmentPeriod.setStartDate(1995, 0, 1);
		employee.setPeriod(employmentPeriod);

		Address address = new Address();
		address.setCity("Vancouver");
		address.setPCode("N5J2N5");
		address.setProvince("BC");
		address.setStreet("20 Mountain Blvd., Floor 53, Suite 6");
		address.setCountry("Canada");
		employee.setAddress(address);

		employee.addResponsibility("Have to fix the Database problem.");
		employee.addPhoneNumber("Work Fax", "613", "5555943");
		employee.addPhoneNumber("Cellular", "416", "5551111");
		employee.addPhoneNumber("Pager", "976", "5556666");
		employee.addPhoneNumber("ISDN", "905", "5553691");
		employee.addEmailAddress("Work", "emanual.smith@acme.com");

		return employee;
	}

	public Employee basicDemoEmployeeExample5() {
		Employee employee = new Employee();

		employee.setFirstName("Sarah");
		employee.setLastName("Way");
		employee.setGender(Gender.Female);
		employee.setSalary(87000);

		EmploymentPeriod employmentPeriod = new EmploymentPeriod();
		employmentPeriod.setEndDate(2001, 6, 31);
		employmentPeriod.setStartDate(1995, 4, 1);
		employee.setPeriod(employmentPeriod);

		Address address = new Address();
		address.setCity("Prince Rupert");
		address.setPCode("K3K5D5");
		address.setProvince("BC");
		address.setStreet("3254 Parkway Place");
		address.setCountry("Canada");
		employee.setAddress(address);

		employee.addResponsibility("Write code documentation.");
		employee.addPhoneNumber("Work", "613", "5558812");
		employee.addPhoneNumber("ISDN", "905", "5553691");
		employee.addPhoneNumber("Home", "613", "5551234");
		employee.addEmailAddress("Work", "sarah.way@acme.com");

		return employee;
	}

	public Employee basicDemoEmployeeExample6() {
		Employee employee = new Employee();

		employee.setFirstName("Marcus");
		employee.setLastName("Saunders");
		employee.setGender(Gender.Male);
		employee.setSalary(54300);

		EmploymentPeriod employmentPeriod = new EmploymentPeriod();
		employmentPeriod.setEndDate(2001, 11, 31);
		employmentPeriod.setStartDate(1995, 0, 12);
		employee.setPeriod(employmentPeriod);

		Address address = new Address();
		address.setCity("Perth");
		address.setPCode("Y3Q2N9");
		address.setProvince("ONT");
		address.setStreet("234 Caledonia Lane");
		address.setCountry("Canada");
		employee.setAddress(address);

		employee.addResponsibility("Write user specifications.");
		employee.addPhoneNumber("ISDN", "905", "5553691");
		employee.addPhoneNumber("Work", "613", "5558812");
		employee.addEmailAddress("Work", "marcus.saunders@acme.com");
		employee.addDegree("Bachelor Computer Science");
		employee.addDegree("Masters Computer Science");

		return employee;
	}

	public Employee basicDemoEmployeeExample7() {
		Employee employee = new Employee();

		employee.setFirstName("Nancy");
		employee.setLastName("White");
		employee.setGender(Gender.Female);
		employee.setSalary(31000);

		EmploymentPeriod employmentPeriod = new EmploymentPeriod();
		employmentPeriod.setEndDate(1996, 0, 1);
		employmentPeriod.setStartDate(1993, 0, 1);
		employee.setPeriod(employmentPeriod);

		Address address = new Address();
		address.setCity("Metcalfe");
		address.setPCode("Y4F7V6");
		address.setProvince("ONT");
		address.setStreet("2 Anderson Rd.");
		address.setCountry("Canada");
		employee.setAddress(address);

		employee.addPhoneNumber("Home", "613", "5551234");
		employee.addEmailAddress("Work", "nancy.white@acme.com");

		return employee;
	}

	public Employee basicDemoEmployeeExample8() {
		Employee employee = new Employee();

		employee.setFirstName("Fred");
		employee.setLastName("Jones");
		employee.setGender(Gender.Male);
		employee.setSalary(500000);

		EmploymentPeriod employmentPeriod = new EmploymentPeriod();
		employmentPeriod.setEndDate(2001, 11, 31);
		employmentPeriod.setStartDate(1995, 0, 1);
		employee.setPeriod(employmentPeriod);

		Address address = new Address();
		address.setCity("Victoria");
		address.setPCode("Z5J2N5");
		address.setProvince("BC");
		address.setStreet("382 Hyde Park Blvd.");
		address.setCountry("Canada");
		employee.setAddress(address);

		employee.addPhoneNumber("Cellular", "416", "5551111");
		employee.addPhoneNumber("ISDN", "905", "5553691");
		employee.addEmailAddress("Work", "fred.jones@acme.com");
		employee.addDegree("Bachelor Business");
		employee.addDegree("Masters Business");

		return employee;
	}

	public Employee basicDemoEmployeeExample9() {
		Employee employee = new Employee();

		employee.setFirstName("Betty");
		employee.setLastName("Jones");
		employee.setGender(Gender.Female);
		employee.setSalary(500001);

		EmploymentPeriod employmentPeriod = new EmploymentPeriod();
		employmentPeriod.setStartDate(2001, 11, 31);
		employmentPeriod.setEndDate(1995, 0, 1);
		employee.setPeriod(employmentPeriod);

		Address address = new Address();
		address.setCity("Smith Falls");
		address.setPCode("C6C6C6");
		address.setProvince("ONT");
		address.setStreet("89 Chocolate Drive");
		address.setCountry("Canada");
		employee.setAddress(address);

		employee.addPhoneNumber("Work", "613", "5558812");
		employee.addPhoneNumber("ISDN", "905", "5553691");
		employee.addEmailAddress("Work", "betty.jones@acme.com");
		employee.addEmailAddress("Home", "betty.cleo.jones@rogers.com");
		employee.addDegree("Bachelor Arts");
		employee.addDegree("Masters Engineering");
		employee.addDegree("PHD Philosophy");

		return employee;
	}

	private void setJobTitle(int employeeIndex, int jobIndex) {
		Employee employee = this.employees[employeeIndex];

		employee.setJobTitle(this.jobTitles[jobIndex]);
	}

	/**
	 * Register all of the population in the provided EntityManager to be
	 * persisted This method should only be called from within a test case. It
	 * asserts that the provided EntityManager is in a transaction and that the
	 * database tables are empty.
	 */
	public void persistAll(EntityManager em) {
		System.out.println("Persisting samples objects.");
		// assert(em.getTransaction().isActive());

		// Verify that the database tables are empty
		/*
		 * assertCount(em, Employee.class, 0); assertCount(em, Address.class,
		 * 0); assertCount(em, PhoneNumber.class, 0); assertCount(em,
		 * Project.class, 0); assertCount(em, JobTitle.class, 0);
		 */

		for (int index = 0; index < this.jobTitles.length; index++) {
			em.persist(this.jobTitles[index]);
		}
		for (int index = 0; index < this.employees.length; index++) {
			em.persist(this.employees[index]);
		}

		System.out.println("Flushing to database.");
		// em.flush();

		System.out.println("Verifying populate.");
		// verifyCounts(em);
	}

	public void verifyCounts(EntityManager em) {
		/*
		 * assertCount(em, Employee.class, this.employees.length);
		 * assertCount(em, Address.class, this.employees.length);
		 * assertCount(em, Project.class, this.smallProjects.length +
		 * this.largeProjects.length); assertCount(em, JobTitle.class,
		 * this.jobTitles.length);
		 */
	}

	/**
	 * Verify that the provided entity type has no rows in the database using a
	 * native ReportQuery.
	 * 
	 * @param entityClass
	 * @param count
	 */
	@SuppressWarnings("unchecked")
	public void assertCount(EntityManager em, Class entityClass, int count) {
		/*CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery criteria = cb.createQuery();
		Root<Class> entity = criteria.from(entityClass);
		criteria.select(cb.count(entity));
		Query query = em.createQuery(criteria);

		Long dbCount = (Long) query.getSingleResult();
		assert (count == dbCount.intValue());*/

	}

	public void persistAllNew(EntityManager em) {
		
		Employee employee = new Employee();

		employee.setFirstName("Fred1");
		employee.setLastName("Jones1");
		employee.setGender(Gender.Female);
		employee.setSalary(500001);

		EmploymentPeriod employmentPeriod = new EmploymentPeriod();
		employmentPeriod.setEndDate(2001, 1, 1);
		employmentPeriod.setStartDate(1995, 1, 1);
		employee.setPeriod(employmentPeriod);

		Address address = new Address();
		address.setCity("Victoria");
		address.setPCode("Z5J2N5");
		address.setProvince("BC");
		address.setStreet("382 Hyde Park Blvd.");
		address.setCountry("Canada");
		employee.setAddress(address);

		employee.addEmailAddress("Work", "fred.jones@acme.com");
		employee.addDegree("Masters Business");
		
		for (int index = 0; index < this.employees.length; index++) {
			em.persist(employee);
		}
	}
	
	public void cleanUpDataBase(EntityManager em) {
		em.getTransaction().begin();
		
		em.createNativeQuery("DELETE FROM DEMO_DEGREE").executeUpdate();
		em.createNativeQuery("DELETE FROM DEMO_EMAIL").executeUpdate(); 
		em.createNativeQuery("DELETE FROM DEMO_EMP_JOB").executeUpdate();
		em.createNativeQuery("DELETE FROM DEMO_JOBTITLE").executeUpdate();
		em.createNativeQuery("DELETE FROM DEMO_PHONE").executeUpdate();
		em.createNativeQuery("DELETE FROM DEMO_RESPONS").executeUpdate();
		em.createNativeQuery("DELETE FROM DEMO_SALARY").executeUpdate();
		em.createNativeQuery("DELETE FROM DEMO_EMPLOYEE").executeUpdate();
		em.createNativeQuery("DELETE FROM DEMO_ADDRESS").executeUpdate();
		
		em.getTransaction().commit();
	}

}
