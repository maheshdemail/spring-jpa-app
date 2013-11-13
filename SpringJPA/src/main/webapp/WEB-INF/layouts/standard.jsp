<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html 
	PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<title>
			<tiles:getAsString name="title" />
		</title>
		<style type="text/css" media="screen">
			@import url("<c:url value="/styles/css-framework/tools.css" />");
			@import url("<c:url value="/styles/css-framework/typo.css" />");
			@import url("<c:url value="/styles/css-framework/forms.css" />");
			@import url("<c:url value="/styles/css-framework/layout-navtop-subright.css" />");
			@import url("<c:url value="/styles/css-framework/layout.css" />");
			@import url("<c:url value="/styles/standard.css" />");
			@import url("<c:url value="/styles/demoapp.css" />");
			@import url("<c:url value="/styles/demoapp-tabview.css" />");
			@import url("<c:url value="/styles/displaytagex.css" />");
		</style>
		
		<script type="text/javascript" src="<c:url value="/scripts/common.js" />"></script>
		<script type="text/javascript" src="<c:url value="/scripts/calendar_1.js" />"></script>
		<script type="text/javascript" src="<c:url value="/scripts/calendar_2.js" />"></script>
		<script type="text/javascript">
			/** Enable Calender Click*/
			addCalendar("HilightCal", "Select Date", "startDate", "employeeInformationForm");
			addCalendar("HilightCal1", "Select Date", "endDate", "employeeInformationForm");
	
			/** Enter Key Press blocked **/
			document.onkeypress = stopEnterKeyPress;
	
			/** Browser Back Button inactivated **/
			noBack();
			window.onload=noBack;
			
			window.onpageshow = function(evt) {if (evt.persisted){noBack();}};
			window.onunload = function() {void (0);};
		</script>
	</head>
	<body >
		<div id="page">
			<div id="header" class="clearfix">
				<tiles:insertAttribute name="header" />
			</div>
			<div id="content" class="clearfix">
				<div id="main"><br></br>
					<tiles:insertAttribute name="body" />
				</div>
				<div id="nav">
					<tiles:insertAttribute name="navigation" />
				</div>
			</div>
			<div id="footer" class="clearfix">
				<tiles:insertAttribute name="footer" />
			</div><!-- end footer -->
		</div><!-- end page -->
		<div id="extra1">&nbsp;</div>
		<div id="extra2">&nbsp;</div>
	</body>
</html>
