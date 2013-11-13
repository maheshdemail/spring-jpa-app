<%@ include file="incl/taglibs.jsp" %>

<c:set var="context" value="${pageContext.request.contextPath}" />

<html>
	<head>
		<meta name="useCaseName" content='Add Entity' />
		<title>Add Entity</title>
	</head>
	<body>
		<div class="demoapp-skin-sam">
			<div class="demoapp-navset">
				<ul class="demoapp-nav">
					<li class="selected"><a href="#">
						<em>
							<c:choose>
								<c:when test="${isAddEmployeeUseCase}">Add Employee</c:when>
								<c:otherwise>Update Employee</c:otherwise>
							</c:choose>
						</em></a>
					</li>
				</ul>            
				<div class="demoapp-content" >
					<div>&nbsp;<br>
						<form:form id="employeeInformationForm" modelAttribute="employeeInformationModel" action="saveEmployee" name="employeeInformationForm" >
							<spring:hasBindErrors name="employeeInformationModel">
								<c:if test="${errors.errorCount gt 0}">
									<table class="custom" border="0" cellpadding="3" cellspacing="0" width="100%" id="filterTable" align="center">
										<tr>
									  		<td colspan="2" align="center">
									  			<div class="warning">There were ${errors.errorCount} error(s) in total.</div>
											</td>
									  	</tr>
									</table>
							  	</c:if>
							</spring:hasBindErrors>
							<c:if test="${not empty successMessages}">
								<table class="custom" border="0" cellpadding="3" cellspacing="0" width="100%" id="filterTable" align="center">
									<tr>
								  		<td colspan="2" align="center">
								  			<div class="success">${successMessages}</div>
										</td>
								  	</tr>
								</table>
						  	</c:if>
							<div class="borderbox">
								<div id="middleMainContainer">
									<div class="middle_box">
										<h2>
											<span>Employee Details</span>
										</h2>
										<form:hidden path="employeeId"/>
										<div class="content">
										<table class="custom" border="0" cellpadding="3" cellspacing="0" width="98%" id="filterTable" align="center">
											<tr>
												<td width="33%">
													<fieldset style="border: 1px #336600;font-size: 11px;font-size:90%;"><legend>Personal Details</legend><br>	
														<table class="custom" border="0" cellpadding="3" cellspacing="0" width="100%" id="filterTable" align="center">
														  	<tr>
														  		<td align="right" width="30%">First Name<span style="color:red;">*</span>&nbsp;&nbsp;</td>
														  		<td width="70%">
														  			<form:input path="firstName" maxlength="10" size="10"  cssClass="highlightBox" onblur="toUpperCase(this);"/>&nbsp;
														  			&nbsp;<font color="red"><form:errors path="firstName" /></font>
															  	</td>
															</tr>
														  	<tr>
															  	<td align="right" width="30%">Last Name<span style="color:red;">*</span>&nbsp;&nbsp;</td>
														  		<td width="70%">
														  			<form:input path="lastName" maxlength="10" size="10"  cssClass="highlightBox" onblur="toUpperCase(this);"/>&nbsp;
														  			&nbsp;<font color="red"><form:errors path="lastName" /></font>
															  	</td>
														  	</tr>
														  	<tr>
														  		<td  align="right" width="30%">Gender<span style="color:red;">*</span>&nbsp;&nbsp;</td>
														  		<td width="70%">
														  			<form:select path="gender">
														  				<form:option value="-1" label="-- Select --"></form:option>
														  				<form:option value="M">Male</form:option>
														  				<form:option value="F">Female</form:option>
														  			</form:select>
														  			&nbsp;<font color="red"><form:errors path="gender" /></font>
																</td>
														  	</tr>
														  	<tr>
														  		<td  align="right" width="30%">End Date&nbsp;&nbsp;</td>
														  		<td width="70%">
														  			<form:input path="endDate" id="endDate" size="10" maxlength="10" cssClass="highlightBox" readonly="true" onblur="toUpperCase(this);"/>
														  			&nbsp;&nbsp;<a href="javascript:showCal('HilightCal1')"><img src='${context}/images/button_calendar.gif' border='0' align="middle" title='Show Calendar' height="17"/></a>
														  		</td>
														  	</tr>
														  	<tr>
														  		<td  align="right" width="30%">Start Date<span style="color:red;">*</span>&nbsp;&nbsp;</td>
														  		<td width="70%">
														  			<form:input path="startDate" id="startDate" size="10" maxlength="10" cssClass="highlightBox" readonly="true" onblur="toUpperCase(this);"/>
														  			&nbsp;&nbsp;<a href="javascript:showCal('HilightCal')"><img src='${context}/images/button_calendar.gif' border='0' align="middle" title='Show Calendar' height="17"/></a>
														  			&nbsp;<font color="red"><form:errors path="startDate" /></font>
														  		</td>
														  	</tr>
															<tr>
														  		<td  align="right" width="30%">Job Title<span style="color:red;">*</span>&nbsp;&nbsp;</td>
														  		<td width="70%">
														  			<form:select path="jobTitle">
																		<form:option value="-1">-- Select --</form:option>
																		<form:option value="Admin">Admin</form:option>
																		<form:option value="Developer">Developer</form:option>
																		<form:option value="Architect">Architect</form:option>
																		<form:option value="Manager">Manager</form:option>
																		<form:option value="VP">VP</form:option>
																		<form:option value="CEO">CEO</form:option>
																	</form:select>
														  			&nbsp;<font color="red"><form:errors path="jobTitle" /></font>
																</td>
														  	</tr>
														  	<tr>
														  		<td  align="right" width="30%">Degree<span style="color:red;">*</span>&nbsp;&nbsp;</td>
														  		<td width="70%">
														  			<form:select path="degree" multiple="true" size="3">
														  				<form:option value="-1" label="-- Select --"></form:option>
																		<form:option value="Bachelor Arts">Bachelor Arts</form:option>
																		<form:option value="Bachelor Business">Bachelor Business</form:option>
																		<form:option value="Bachelor Computer Science">Bachelor Computer Science</form:option>
																		<form:option value="Masters Business">Masters Business</form:option>
																		<form:option value="Masters Computer Science">Masters Computer Science</form:option>
																		<form:option value="Masters Engineering">Masters Engineering</form:option>
																		<form:option value="PHD Computer Science">PHD Computer Science</form:option>
																		<form:option value="PHD Philosophy">PHD Philosophy</form:option>
																	</form:select>
														  			&nbsp;<font color="red"><form:errors path="degree" /></font>
																</td>
														  	</tr>
														  	<tr>
														  		<td align="right" width="30%">Salary<span style="color:red;">*</span>&nbsp;&nbsp;</td>
														  		<td width="70%">
														  			<form:input path="salary" maxlength="10" size="10"  cssClass="highlightBox" onblur="toUpperCase(this);"/>&nbsp;
														  			&nbsp;<font color="red"><form:errors path="salary" /></font>
														  		</td>
														  	</tr>
													  	</table>
												  	</fieldset>	
												  </td>
												  <td width="34%">
													  <fieldset style="border: 1px #336600;font-size: 11px;"><legend>Address</legend><br>
													  	<table class="custom" border="0" cellpadding="3" cellspacing="0" width="100%" id="filterTable" align="center">
														  	<tr>
														  		<td align="right" width="30%">City<span style="color:red;">*</span>&nbsp;&nbsp;</td>
														  		<td width="70%">
														  			<form:input path="city" maxlength="10" size="10"  cssClass="highlightBox" onblur="toUpperCase(this);"/>&nbsp;
														  			&nbsp;<font color="red"><form:errors path="city" /></font>
															  	</td>
															 </tr>
														  	<tr>
															  	<td align="right" width="30%">Country<span style="color:red;">*</span>&nbsp;&nbsp;</td>
														  		<td width="70%">
														  			<form:input path="country" maxlength="10" size="10"  cssClass="highlightBox" onblur="toUpperCase(this);"/>&nbsp;
														  			&nbsp;<font color="red"><form:errors path="country" /></font>
															  	</td>
														  	</tr>
														  	<tr>
														  		<td align="right" width="30%">Zip Code<span style="color:red;">*</span>&nbsp;&nbsp;</td>
														  		<td width="70%">
														  			<form:input path="zipCode" maxlength="10" size="10"  cssClass="highlightBox" onblur="toUpperCase(this);"/>&nbsp;
														  			&nbsp;<font color="red"><form:errors path="zipCode" /></font>
														  		</td>
														  	</tr>
														  	<tr>
														  		<td align="right" width="30%">State&nbsp;&nbsp;</td>
														  		<td width="70%">
														  			<form:input path="province" maxlength="3" size="3"  cssClass="highlightBox" onblur="toUpperCase(this);"/>&nbsp;
														  		</td>
														  	</tr>
														  	<tr>
														  		<td align="right" width="30%">Street&nbsp;&nbsp;</td>
														  		<td width="70%">
														  			<form:textarea path="street" cols="7" rows="2" cssClass="highlightBox" onblur="toUpperCase(this);"/>&nbsp;
														  		</td>
														  	</tr>
														  	<tr>
															  	<td align="right" width="30%">&nbsp;&nbsp;</td>
														  		<td align="right" width="70%">&nbsp;&nbsp;</td>
														  	</tr>
												  		</table>
												  		</fieldset>
											  		</td>
											  		 <td width="33%">
													  <fieldset style="border: 1px #336600;font-size: 11px;"><legend>Contact Details</legend><br>
													  	<table class="custom" border="0" cellpadding="3" cellspacing="0" width="100%" id="filterTable" align="center">
														  	<tr>
														  		<td align="right" width="35%">Email<span style="color:red;">*</span>&nbsp;&nbsp;</td>
														  		<td width="65%">
														  			<form:input path="email" maxlength="30" size="30"  cssClass="highlightBox" onblur="toUpperCase(this);"/>&nbsp;
														  			&nbsp;<font color="red"><form:errors path="email" /></font>
															  	</td>
															 </tr>
														  	<tr>
															  	<td align="right" width="35%">Phone ISDN&nbsp;&nbsp;</td>
														  		<td width="65%">
														  			<form:input path="phoneIsdnAreaCode" maxlength="3" size="2"  cssClass="highlightBox" onblur="toUpperCase(this);"/>
														  			&nbsp;<form:input path="phoneIsdn" maxlength="7" size="7"  cssClass="highlightBox" onblur="toUpperCase(this);"/>
														  			<font color="red"><form:errors path="phoneIsdn" />&nbsp;<form:errors path="phoneIsdnAreaCode" /></font>
															  	</td>
														  	</tr>
														 	<tr>
															  	<td align="right" width="35%">Phone Work&nbsp;&nbsp;</td>
														  		<td width="65%">
														  			<form:input path="phoneWorkAreaCode" maxlength="3" size="2" cssClass="highlightBox" onblur="toUpperCase(this);"/>
														  			&nbsp;<form:input path="phoneWork" maxlength="7" size="7"  cssClass="highlightBox" onblur="toUpperCase(this);"/>
														  			<font color="red"><form:errors path="phoneWork" />&nbsp;<form:errors path="phoneWorkAreaCode" /></font>
															  	</td>
														  	</tr>
														  	<tr>
															  	<td align="right" width="35%">Phone Work Fax&nbsp;&nbsp;</td>
														  		<td width="65%">
														  			<form:input path="phoneWorkFaxAreaCode" maxlength="3" size="2"  cssClass="highlightBox" onblur="toUpperCase(this);"/>
														  			&nbsp;<form:input path="phoneWorkFax" maxlength="7" size="7"  cssClass="highlightBox" onblur="toUpperCase(this);"/>
														  			<font color="red"><form:errors path="phoneWorkFax" />&nbsp;<form:errors path="phoneWorkFaxAreaCode" /></font>
															  	</td>
														  	</tr>
														  	<tr>
															  	<td align="right" width="35%">Phone Cellular<span style="color:red;">*</span>&nbsp;&nbsp;</td>
														  		<td width="65%">
														  			<form:input path="phoneCellularAreaCode" maxlength="3" size="2" cssClass="highlightBox" onblur="toUpperCase(this);"/>
														  			&nbsp;<form:input path="phoneCellular" maxlength="7" size="7"  cssClass="highlightBox" onblur="toUpperCase(this);"/>
														  			<font color="red"><form:errors path="phoneCellular" />&nbsp;<form:errors path="phoneCellularAreaCode" /></font>
															  	</td>
														  	</tr>
														  	<tr>
															  	<td align="right" width="35%">Phone Pager&nbsp;&nbsp;</td>
														  		<td width="65%">
														  			<form:input path="phonePagerAreaCode" maxlength="3" size="2"  cssClass="highlightBox" onblur="toUpperCase(this);"/>
														  			&nbsp;<form:input path="phonePager" maxlength="7" size="7"  cssClass="highlightBox" onblur="toUpperCase(this);"/>
														  			<font color="red"><form:errors path="phonePager" />&nbsp;<form:errors path="phonePagerAreaCode" /></font>
															  	</td>
														  	</tr>
														  	<tr>
															  	<td align="right" width="35%">Responsibility&nbsp;&nbsp;</td>
														  		<td width="65%">
														  			<%-- TODO: Should be populated from DB Table --%>
														  			<form:select path="responsibility">
														  				<form:option value="-1" label="-- Select --"></form:option>
														  				<form:option value="Fix the Database problem">Fix the Database problem</form:option>
														  				<form:option value="Write user specifications">Write user specifications</form:option>
														  				<form:option value="Perform code reviews">Perform code reviews</form:option>
														  				<form:option value="Write code documentation">Write code documentation</form:option>
														  				<form:option value="Write Programs">Write Programs</form:option>
														  				<form:option value="Design and Architecture">Design and Architecture</form:option>
														  				<form:option value="Manange Teams">Manange Teams</form:option>
														  				<form:option value="Maintain the kitchen facilities">Maintain the kitchen facilities</form:option>
														  				<form:option value="Plan-develop-implement strategies">Plan-develop-implement strategies</form:option>
														  				<form:option value="Direct company planning and policy">Direct company planning and policy</form:option>
														  			</form:select>
																</td>
														  	</tr>
														  	<tr>
															  	<td align="right" width="30%">&nbsp;&nbsp;</td>
														  		<td align="right" width="70%">&nbsp;&nbsp;<br></br></td>
														  	</tr>
														  	<tr>
															  	<td align="right" width="30%">&nbsp;&nbsp;</td>
														  		<td align="right" width="70%">&nbsp;&nbsp;</td>
														  	</tr>
												  		</table>
												  		</fieldset>
											  		</td>
											  	</tr>
										  	</table>
										</div>
									</div>
								</div>
								<div class="middle_box">
									<table align="center" border="0">
										<tr>
									  		<td>  
												<div class="buttonwrapper">
													<a class="squarebutton" onclick="this.disabled='true';document.employeeInformationForm.action='saveEmployeeInformation.do'; document.employeeInformationForm.submit();">
														<span>
															<c:choose>
																<c:when test="${isAddEmployeeUseCase}">Save Employee</c:when>
																<c:otherwise>Update Employee</c:otherwise>
															</c:choose>
														</span>
													</a>
												</div>
											</td>
									  	</tr>
									</table>	
								</div>	
							</div>
							<br>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
