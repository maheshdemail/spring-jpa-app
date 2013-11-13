Employee Management System demonstrates JPA 2.0s latest features like:

1. Criteria API
2. Additions APIs on EntityManager
3. Additional API on Query
4. New Bean Validation Support
5. Metamodel APIs

Use Cases demonstrated:

	1. Add Employee
	2. Update Employee
	3. Remove Employee
	4. Find Employees	
	
		4.1 Find Employee by First Name and Last Name
		4.2 Find Employee by Manager
		4.3 Find Employee by Gender
		4.4 Find Employee by Salary
	
Refer to DAO implementation classes to see all three types of data access strategies using:

 	1. Criteria API
 	2. Dynamic Queries
 	3. Static Queries
 	
 Queries with Other Conditional Expressions:
 
 	1. The LIKE Expression
 	2. The BETWEEN Expression
 	3. Comparison Operators
 	4. The GREATER THAN Expression
 	5. The LESS THAN Expression
 	6. The IN Expression
 	7. The FETCH JOIN Expression
 	
 	
 Demo Environment Details
	
	1. ORM : JPA 2.0
	2. ORM JPA Persistence Provider - Hibernate 3.5.0
	3. Hibernate JPA MetaModel Generater to write TypeSafe Dynamic Quiries using Criteria APIs
	4. Maven PlugIn (hibernate-jpamodelgen 1.0.0.Final)

	5. Spring Framework 3.0.2.RELEASE
	6. Oracle Weblogic - 10.3
	7. Database - Oracle 9i
	8. Maven is used to simplify the build processes
	9. Apache Tile Framework
	10. Java Script
	11. CSS
	


Configuration Files

	1. Oracle Weblogic 10.3 doesn't support JEE 6 at the moment (as of May 2010), then how to get JPA 2.0 working on weblogic:

  		weblogic-application.xml

	2. JPA 2.0 and Spring 3.0.2 integration (Application Context XMLs)

  		2.1. Data Access Object (DAO) Layer: jpa-dao-config.xml (JPA 2.0 is integrated in DAO layer)
  		2.2. Service (Business) Layer: service-config.xml
  		2.3. Web Layer (Spring Web MVC): mvc-config.xml
  		
 JPA Entities
	
 		1. Employee
 		2. Address
 		3. Degree
 		4. JobTitle
 		5. PhoneNumber
 		6. EmailAddress (Embedable)
		7. EmploymentPeriod (Embedable)
		8. Gender (Java Enum)

JPA Persistence
	
		1. persistence.xml
		
		
