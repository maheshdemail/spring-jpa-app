<%@ include file="incl/taglibs.jsp" %>

<c:set var="context" value="${pageContext.request.contextPath}" />

<html>
	<head>
		<meta name="useCaseName" content='<fmt:message key="screen.protocol.information.meta.content"/>' />
		<title><fmt:message key="screen.protocol.information.title"/></title>
	</head>
	<body>
		<div class="demoapp-skin-sam">
			<div class="demoapp-navset">
				<ul class="demoapp-nav">
					<li class="selected"><a href="#"><em>Home</em></a></li>
				</ul>            
				<div class="demoapp-content" >
					<div>&nbsp;<br>
						<table border="0" width="100%">
							<tr>
								<td colspan="1" width="50%">
									<table width="100%" >
										<tr>
											<td width="100%">&nbsp;&nbsp;</td>
										</tr>
										<tr>
											<td width="100%">
												This application demonstrates how <b>JPA 2.0</b> and <b>Spring 3.0.2</b> work on Oracle Weblogic 10.3.
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
						<%--
						<table border="0" width="100%">
							<tr>
								<td colspan="1" width="50%">
									<table width="100%" style="border-color: #600;border-width: 1px 1px 1px 1px; border-style: solid;">
										<tr>
											<td width="100%">
												<h3>
													<a name="#"><img align="middle" src="<c:url value="/images/step1.gif"/>"></a>Employee Management System Application
												</h3><br>
												<ul>
													<li>Add Employee</li>
													<li>Update Employee</li>
													<li>Delete Employee</li>
													<li>Search Employees</li><br></br>
													&nbsp;&nbsp;&nbsp;&#187;&nbsp;&nbsp;Find All Employees<br>
													&nbsp;&nbsp;&nbsp;&#187;&nbsp;&nbsp;Find Employees by Name<br>
													&nbsp;&nbsp;&nbsp;&#187;&nbsp;&nbsp;Find Employees by Salary Range<br>
													&nbsp;&nbsp;&nbsp;&#187;&nbsp;&nbsp;Find Employees by Gender<br><br><br><br><br>
												</ul>
												<br>
												<h3>
													<a name="#"><img align="middle" src="<c:url value="/images/step2.gif"/>"></a>Environment
												</h3><br>
												<ul>
													<li>JPA 2.0</li>
													<li>JPA Runtime Provider - Hibernate 3.5.0</li>
													<li>JPA Static MetaModel Generator - hibernate-jpamodelgen 1.0.0.Final</li>
													<li>Spring Framework - 3.0.2.RELEASE</li>
													<li>Oracle Weblogic - 10.3</li>
													<li>Database - Oracle 9i</li>
													<li>Maven is used to simplify the build processes</li><br><br><br>
												</ul>
											</td>
										</tr>
									</table>
								</td>
								<td colspan="2" width="50%">
									<table width="100%" style="border-color: #600;border-width: 1px 1px 1px 1px; border-style: solid;">
										<tr style="border-color: #600;border-width: 1px 1px 1px 1px; border-style: solid;">
											<td width="100%">
												<h3>
													<a name="#"><img align="middle" src="<c:url value="/images/step3.gif"/>"></a>Configuration
												</h3><br>
												<ul>
													<li>Oracle Weblogic 10.3 doesn't support JEE 6 at the moment, then how to get JPA 2.0 working on weblogic:</li><br><br>
													&nbsp;&nbsp;&nbsp;&#187;&nbsp;&nbsp;<b>weblogic-application.xml</b><br><br>
													<li>JPA 2.0 and Spring 3.0.2 integration (Application Context XMLs)</li><br><br>
													<table>
														<tr>
															<td>&nbsp;&nbsp;&nbsp;&#187;&nbsp;&nbsp;Data Access (DAO) Layer:</td>
															<td><b>&nbsp;&nbsp;jpa-dao-config.xml</b></td>
														</tr>
														<tr>
															<td>&nbsp;&nbsp;&nbsp;&#187;&nbsp;&nbsp;Service (Business) Layer:</td>
															<td><b>&nbsp;&nbsp;service-config.xml</b></td>
														</tr>
														<tr>
															<td>&nbsp;&nbsp;&nbsp;&#187;&nbsp;&nbsp;Web Layer (Spring Web MVC):</td>
															<td><b>&nbsp;&nbsp;mvc-config.xml</b></td>
														</tr>
													</table>
													<li>persistence.xml</li>
												</ul>
												<br>
												<h3>
													<a name="#"><img align="middle" src="<c:url value="/images/step4.gif"/>"></a>JPA Entities
												</h3><br>
												<ul>
													<li>Employee</li>
													<li>Address</li>
													<li>Degree</li>
													<li>JobTitle</li>
													<li>PhoneNumber</li>
													<li>EmailAddress (Embedable)</li>
													<li>EmploymentPeriod (Embedable)</li>
													<li>Gender (Java Enum)</li>
												</ul>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
						 --%>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
