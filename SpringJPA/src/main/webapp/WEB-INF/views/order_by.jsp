<%@ include file="incl/taglibs.jsp" %>

<c:set var="context" value="${pageContext.request.contextPath}" />
<html>
	<head>
		<meta name="useCaseName" content='Search All Employees' />
		<title>Search All Employees</title>
	</head>
	<body>
		<form:form id="searchForm1" name="searchForm1" modelAttribute="searchBackingBean" >
			<div class="demoapp-skin-sam">
				<div class="demoapp-navset">
					<ul class="demoapp-nav">
						<li class="selected"><a href="#" onclick="javascript:loadTab('1', document.searchForm1);"><em>ORDER BY</em></a></li>
						<li><a href="#" onclick="javascript:loadTab('2', document.searchForm2);"><em>LIKE</em></a></li>
						<li><a href="#" onclick="javascript:loadTab('3', document.searchForm3);"><em>BETWEEN</em></a></li>
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
						  				<div class="info">Find All Employees order by First Name and Last Name</div>
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
											<jsp:include page="incl/incl_jpa_panel.jsp" />
										</div>
									</div>
								</div>
								<div class="middle_box">
									<table align="center" border="0">
										<tr>
									  		<td>  
												<div class="buttonwrapper">
													<a class="squarebutton" onclick="this.disabled='true';document.searchForm1.action='searchEmployees-OrderBy.do'; document.searchForm1.submit();">
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
