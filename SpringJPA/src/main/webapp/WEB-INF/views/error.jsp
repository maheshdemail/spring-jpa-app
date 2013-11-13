<%@ page language="java" isErrorPage="true" %>
<%@ include file="incl/taglibs.jsp" %>

<c:set var="context" value="${pageContext.request.contextPath}" />

<html>
	<head>
		<meta name="useCaseName" content='<fmt:message key="error.page.meta.content"/>' />
		<title>SYSTEM ERROR</title>
	</head>
	<body>
		<form method="post" name="protocolAssignmentForm">
			<div class="demoapp-skin-sam">
				<div class="demoapp-navset">
					<ul class="demoapp-nav">
						<li class="selected"><a href="#"><em>SYSTEM ERROR</em></a></li>
					</ul>            
					<div class="demoapp-content" >
						<div>&nbsp;<br>
							<p align="center"><b><font SIZE="2px" color="red">SYSTEM ERROR</font></b><p/>
							<p align="center"><font color="red">Please contact Administrator</font></p><br>
							<c:if test="${not empty exception}">
								<c:if test="${not empty exception.message and fn:length(exception.message) gt 0 }">
									<table border ="0" id="exceptionTable" align="center" class="custom">
										<tr align="center">
											<td align="center">
												<span onclick="toggleExceptionRow('${context}/images/plus.gif', '${context}/images/minus.gif');">
													<img src="${context}/images/plus.gif" id="toggleImage1" />
												</span>
											</td>
										</tr>
										<tr style="display:none" id='exceptionTR'>
											<td><br>
												<table border ="0" id="exceptionTable" align="center" class="custom">
													<tr>
														<td align="center">
															<p align="center">
																<img src="${context}/images/msg_error.gif" />
																&nbsp;&nbsp;<b><FONT SIZE="2px">Cause</FONT></b>&nbsp;&nbsp;
																<img src="${context}/images/msg_error.gif" />
															</p>
														</td>
													</tr>
													<tr>
														<td>
															<div class="warning"><c:out value="${exception.message}" /></div>
														</td>
													</tr>
												</table>
											<td>
										</tr>
									</table>
								</c:if>
							</c:if>
							<br>
						</div>
					</div>
				</div>
			</div>
		</form>
	</body>
</html>