Emplyee Manangement System:

Use Cases:

	1. Add Employee
	2. Update Employee
	3. Remove Employee
	4. Find Employees	
	
		4.1 Find Employee by First Name and Last Name
		4.2 Find Employee by Manager
		4.3 Find Employee by Gender
		4.4 Find Employee by Salary
	

Following jars need to be installed in local maven repository:

mvn install:install-file -DgroupId=antlr -DartifactId=antlr -Dversion=2.7.6 -Dpackaging=jar -Dfile=<downloaded_location>\antlr-2.7.6.jar
mvn install:install-file -DgroupId=commons-collections -DartifactId=commons-collections -Dversion=3.1 -Dpackaging=jar -Dfile=<downloaded_location>\commons-collections-3.1.jar
mvn install:install-file -DgroupId=dom4j -DartifactId=dom4j -Dversion=1.6.1 -Dpackaging=jar -Dfile=<downloaded_location>\dom4j-1.6.1.jar
mvn install:install-file -DgroupId=javassist -DartifactId=javassist -Dversion=3.9.0.GA -Dpackaging=jar -Dfile=<downloaded_location>\javassist-3.9.0.GA.jar
mvn install:install-file -DgroupId=jta -DartifactId=jta -Dversion=1.1 -Dpackaging=jar -Dfile=<downloaded_location>\jta-1.1.jar
mvn install:install-file -DgroupId=slf4j-api -DartifactId=slf4j-api -Dversion=1.5.8 -Dpackaging=jar -Dfile=<downloaded_location>\slf4j-api-1.5.8.jar
mvn install:install-file -DgroupId=javax.persistence -DartifactId=hibernate-jpa -Dversion=2.0-api-1.0.0.Final -Dpackaging=jar -Dfile=<downloaded_location>\hibernate-jpa-2.0-api-1.0.0.Final.jar
mvn install:install-file -DgroupId=hibernate -DartifactId=hibernate3 -Dversion=1.0 -Dpackaging=jar -Dfile=<downloaded_location>\hibernate3.jar	