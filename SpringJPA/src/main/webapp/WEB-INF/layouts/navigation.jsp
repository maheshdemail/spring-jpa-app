<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ul>
	<li>
		<a href="<c:url value="/" />">Home</a>
	</li>
	<li>
		<a href="<c:url value="/addEmployee.do" />">Add Employee</a>
	</li>
	<li>
		<a href="<c:url value="/viewAllEmployees.do?useCase=UpdateEmployee" />">Update Employee</a>
	</li>
	<li>
		<a href="<c:url value="/viewAllEmployees.do?useCase=RemoveEmployee" />">Remove Employee</a>
	</li>
	<li>
		<a href="<c:url value="/findEmployees-OrderBy.do" />">Find Employee(s)</a>
	</li>
	<li>
		<a href="#" onclick="javascript:showDesignArchitecture();">Design &amp; Architecture</a>
	</li>
	
</ul>
