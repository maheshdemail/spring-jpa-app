<%@ include file="incl/taglibs.jsp" %>

<c:set var="context" value="${pageContext.request.contextPath}" />
<html>
	<head>
		<meta name="useCaseName" content='Search Employee by Salaries' />
		<title>Search Employee by Salaries</title>
	</head>
	<body>
		<form:form id="searchForm3"  name="searchForm3" modelAttribute="searchBackingBean" >
			<div class="demoapp-skin-sam">
				<div class="demoapp-navset">
					<ul class="demoapp-nav">
						<li><a href="#" onclick="javascript:loadTab('1', document.searchForm1);"><em>ORDER BY</em></a></li>
						<li><a href="#" onclick="javascript:loadTab('2', document.searchForm2);"><em>LIKE</em></a></li>
						<li class="selected"><a href="#" onclick="javascript:loadTab('3', document.searchForm3);"><em>BETWEEN</em></a></li>
						<li><a href="#" onclick="javascript:loadTab('4', document.searchForm4);"><em>LESS THAN</em></a></li>
						<li><a href="#" onclick="javascript:loadTab('5', document.searchForm5);"><em>GREATER THAN</em></a></li>
						<li><a href="#" onclick="javascript:loadTab('6', document.searchForm6);"><em>IN</em></a></li>
						<li><a href="#" onclick="javascript:loadTab('7', document.searchForm7);"><em>JOIN FETCH</em></a></li>
					</ul>            
					<div class="demoapp-content" >
						<div>&nbsp;
							<table class="custom" border="0" cellpadding="3" cellspacing="0" width="100%" id="filterTable" align="center">
						  		<tr>
							  		<td colspan="3" align="left" width="100%" >
						  				<div class="info">Find Employees by Salary Range</div>
									</td>
							  	</tr>
							</table>
							<div class="borderbox">
								<div id="middleMainContainer">
									<div class="middle_box">
										<h2>
											<span>Search Criteria</span>
										</h2>
										<div class="content">
											<table class="custom" border="0" cellpadding="1" cellspacing="0" width="98%" id="filterTable" align="left">
												<tr>
													<td width="40%">
														<jsp:include page="incl/incl_jpa_panel.jsp" />
													</td>
													<td width="60%">
														<fieldset style="border: 1px #336600;font-size: 11px;font-size:90%;">
															<legend>Search Criteria</legend>
															<table class="custom" border="0" cellpadding="3" cellspacing="0" width="100%" id="filterTable" align="left">
				  												<tr>
				  													<td align="left" >&nbsp; &nbsp;</td>
				  												</tr>
				  												<tr>
				  													<td align="right" width="50%">
																		Employee Salary Range Minimum: 
																	 </td>
				  													<td align="left" width="50%">
																		<form:input path="minimumSalary" size="20" maxlength="20" cssClass="highlightBox" onblur="toUpperCase(this);"/>
																	 </td>
																</tr>
																<tr>
				  													<td align="right" width="50%">
																		Employee Salary Range Maximum: 
																	 </td>
				  													<td align="left" width="50%" >
																		<form:input path="maximumSalary" size="20" maxlength="20" cssClass="highlightBox" onblur="toUpperCase(this);"/>
																	 </td>
																</tr>
															</table><br></br><br></br>
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
													<a class="squarebutton" onclick="this.disabled='true';document.searchForm3.action='searchEmployees-Between.do'; document.searchForm3.submit();">
														<span>Search</span>
													</a>
												</div>
											</td>
									  	</tr>
									</table>
								</div>	
							</div>
							<jsp:include page="incl/incl_search_result.jsp" />
						</div>
					</div>
				</div>
			</div>
		</form:form>
	</body>
</html>
