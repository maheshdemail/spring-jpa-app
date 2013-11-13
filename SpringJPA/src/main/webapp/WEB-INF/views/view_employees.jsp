<%@ include file="incl/taglibs.jsp" %>

<c:set var="context" value="${pageContext.request.contextPath}" />
<%
session.setAttribute("employees",  request.getAttribute("employeeList"));
%>
<html>
	<head>
		<meta name="useCaseName" content='<fmt:message key="screen.protocol.information.meta.content"/>' />
		<title><fmt:message key="screen.protocol.information.title"/></title>
	</head>
	<body>
		<div class="demoapp-skin-sam">
			<div class="demoapp-navset">
				<ul class="demoapp-nav">
					<li class="selected"><a href="#"><em>View All Employees</em></a></li>
				</ul>            
				<div class="demoapp-content" >
					<div>&nbsp;<br>
						<form:form id="protocolInformationForm" modelAttribute="protocolInformationModel" action="saveProtocolInformation" name="protocolInformationForm" >
							<c:if test="${not empty successMessages}">
								<table class="custom" border="0" cellpadding="3" cellspacing="0" width="100%" id="filterTable" align="center">
									<tr>
								  		<td colspan="2" align="center">
								  			<div class="success">${successMessages}</div>
										</td>
								  	</tr>
								</table>
						  	</c:if>
						  	<table class="custom" border="0" cellpadding="3" cellspacing="0" width="100%" id="filterTable" align="center">
						  		<tr>
							  		<td colspan="3" align="left" width="100%" >
						  				<c:choose>
											<c:when test="${useCase eq 'UpdateEmployee'}">
						  						<div class="info">Select employee to <b>Update</b></div>
						  					</c:when>
						  					<c:otherwise>
						  						<div class="info">Select employee to <b>Remove</b></div>
						  					</c:otherwise>
						  				</c:choose>
									</td>
							  	</tr>
							  	<tr>
							  		<td colspan="3" align="left" width="100%">&nbsp;</td>
							  	</tr>
							</table>
						  	<c:choose>
								<c:when test="${useCase eq 'UpdateEmployee'}">
									<display:table requestURI="viewAllEmployees.do" id="row" cellspacing="1" name="sessionScope.employees" class="dataTable" defaultsort="1" defaultorder="ascending" pagesize="10" style="width:100%; margin-top:1%; margin-right:0%;">
										<display:column title="Name" sortable="true">
											<a href="/GatewayJUG/updateEmployee.do?id=${row.employeeId}">${row.name}</a>
										</display:column>
										<display:column property="gender" title="Gender" sortable="true"/>
										<display:column property="endDate" title="End Date" sortable="true"/>
										<display:column property="startDate" title="Start Date" sortable="true"/>
										<display:column property="jobTitle" title="Job Title" sortable="true"/>
										<display:column property="degree" title="Degree" sortable="true"/>
										<display:column property="salary" title="Salary" sortable="true"/>
										<display:column property="address" title="Adress" sortable="true"/>
										<display:column property="allPhones" title="Phone" sortable="true"/>
										<display:column property="responsibility" title="Responsibility" sortable="true"/>
									</display:table>
								</c:when>
								<c:otherwise>
									<display:table requestURI="viewAllEmployees.do" id="row" cellspacing="1" name="sessionScope.employees" class="dataTable" defaultsort="1" defaultorder="ascending" pagesize="10" style="width:100%; margin-top:1%; margin-right:0%;">
										<display:column title="Name" sortable="true">
											<a href="#" onClick="javascript: return areYouSure('/GatewayJUG/deleteEmployee.do?id=${row.employeeId}');">${row.name}</a>
										</display:column>
										<display:column property="gender" title="Gender" sortable="true"/>
										<display:column property="endDate" title="End Date" sortable="true"/>
										<display:column property="startDate" title="Start Date" sortable="true"/>
										<display:column property="jobTitle" title="Job Title" sortable="true"/>
										<display:column property="degree" title="Degree" sortable="true"/>
										<display:column property="salary" title="Salary" sortable="true"/>
										<display:column property="address" title="Adress" sortable="true"/>
										<display:column property="allPhones" title="Phone" sortable="true"/>
										<display:column property="responsibility" title="Responsibility" sortable="true"/>
									</display:table>
								</c:otherwise>
							</c:choose>
							<br></br>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
