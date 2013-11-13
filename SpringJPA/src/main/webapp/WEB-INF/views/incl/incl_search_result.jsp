<%@ include file="taglibs.jsp" %>

<%
request.setAttribute("employees",  request.getAttribute("employeeList"));
%>
<br>
<c:choose>
	<c:when test="${fn:length(employeeList) gt 0}">
		Total <font color="red"><b>${fn:length(employeeList)} </b></font>record(s) found. 
		<display:table id="row" cellspacing="1" name="requestScope.employees" class="dataTable" style="width:100%; margin-top:1%; margin-right:0%;">
			<display:column title="Name">${row.name}</display:column>
			<display:column property="gender" title="Gender" />
			<display:column property="endDate" title="End Date" />
			<display:column property="startDate" title="Start Date" />
			<display:column property="jobTitle" title="Job Title" />
			<display:column property="degree" title="Degree" />
			<display:column property="salary" title="Salary" />
			<display:column property="address" title="Adress" />
			<display:column property="allPhones" title="Phone" />
			<display:column property="responsibility" title="Responsibility" />
		</display:table>
	</c:when>
	<c:when test="${employeeList != null}">
		<CENTER><font color="red"><b>No records found.</b></font></CENTER>
	</c:when>
	<c:otherwise></c:otherwise>
</c:choose>
<%--<display:column property="email" title="Email" />--%>