<%@ include file="incl/taglibs.jsp" %>

<html>
<head>
	<title>JPA 2.0 &amp; Spring 3.0.2 - Demo to Gateway JUG, St Louis, MO.</title>
	<meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
	<meta content="MSHTML 6.00.6000.16762" name="GENERATOR">
</head>
<body>
<br>
<hr color="black" style="width: 100%; height: 1px;">
<br>
	<h3>
		<a name=""></a>Content
	</h3><br>
	<ul>
		<li><a href="desingArchitecture.do#Img_UseCase_Diagram">Use Case Diagram </a></i></li>
		<li><a href="desingArchitecture.do#Environment">Environment  </a></i></li>
		<li><a href="desingArchitecture.do#Configuration">Configuration  </a></i></li>
		<li><a href="desingArchitecture.do#Entities">JPA Entities</a></i></li>
	</ul>
	<br>
	<hr color="black" style="width: 100%; height: 1px;">
	<br>
	<h3>
		<a name="Environment"></a>Environment
	</h3><br>
	<ul>
		<li>JPA <i>2.0</i></li>
		<li>JPA Persistence Provider - <i>Hibernate 3.5.0</i></li>
		<li>Hibernate JPA MetaModel Generater to write TypeSafe Dynamic Quiries using Criteria APIs - <i> Maven PlugIn (hibernate-jpamodelgen 1.0.0.Final)</i></li><br></br>

		<li>Spring Framework <i>3.0.2.RELEASE</i></li>
		<li>Oracle Weblogic - <i>10.3</i></li>
		<li>Database - Oracle <i>9i</i></li>
		<li>Maven is used to simplify the build processes</li>
	</ul>
	<br>
	<hr color="black" style="width: 100%; height: 1px;">
	<br>
	<h3>
		<a name="Configuration"></a>Configuration
	</h3><br>
	<ul>
		<li>Oracle Weblogic 10.3 doesn't support JEE 6 at the moment, then how to get JPA 2.0 working on weblogic:</li><br></br>
		&nbsp;&nbsp;&nbsp;&#187;&nbsp;&nbsp;<b>weblogic-application.xml</b><br></br>
		<li>JPA 2.0 and Spring 3.0.2 integration (Application Context XMLs)</li>
		<br></br>
		&nbsp;&nbsp;&nbsp;&#187;&nbsp;&nbsp;Data Access Object (DAO) Layer:&nbsp;&nbsp;&nbsp;&nbsp;<b>jpa-dao-config.xml</b>&nbsp;&nbsp;&nbsp;&nbsp; (JPA 2.0 is integrated in DAO layer)<br></br>
		&nbsp;&nbsp;&nbsp;&#187;&nbsp;&nbsp;Service (Business) Layer:&nbsp;&nbsp;&nbsp;&nbsp;<b>service-config.xml</b><br></br>
		&nbsp;&nbsp;&nbsp;&#187;&nbsp;&nbsp;Web Layer (Spring Web MVC):&nbsp;&nbsp;&nbsp;&nbsp;<b>mvc-config.xml</b><br></br>
	</ul>
	<br>
	<hr color="black" style="width: 100%; height: 1px;">
	<br>
	<h3>
		<a name="Entities"></a>JPA Entities
	</h3><br>
	<ul>
		<li>Employee</li>
		<li>Address </li>
		<li>Degree </li>
		<li>JobTitle </li>
		<li>PhoneNumber </li>
		<li>EmailAddress (Embedable) </li>
		<li>EmploymentPeriod (Embedable)</li>
		<li>Gender (Java Enum)</li><br></br>
		
		<li><a href="desingArchitecture.do#Img_ORMClass_Digaram">ORM Class Diagram</a></i>
		<li><b>persistence.xml</b></li>
	</ul>
	<br>
	<hr color="black" style="width: 100%; height: 1px;">
	<br>
	<h3>List of Figures</h3>
	<ol>
		<li><a href="desingArchitecture.do#Img_UseCase_Diagram">Figure 1. Use Case Diagram </a>  </li>
		<li><a href="desingArchitecture.do#Img_ORMClass_Digaram">Figure 2. ORM Class Diagram</a>  </li>
		<li><a href="desingArchitecture.do#Img_ERDiagram_Diagram">Figure 3. ER Diagram</a>  </li>
		<li><a href="desingArchitecture.do#Img_FindAll_Sequence_Diagram">Figure 4. Sequence Diagram - Find All Employees</a> </li>
		<li><a href="desingArchitecture.do#Img_AddUpdateDelete_Sequence_Diagram">Figure 5. Sequence Diagram - Add/Update/Delete Employee</a> </li> 
		<li><a href="desingArchitecture.do#Img_Class_Diagram">Figure 6. Class Diagram</a> </li> 
	</ol>

	<br>
	<hr color="black" style="width: 100%; height: 1px;">
	
	<br>
	<h3>
		<a name="6._UI_Events"></a>Figures
	</h3><br>
	<h3 style="TEXT-ALIGN: left"><a name="Img_UseCase_Diagram"></a>Figure 1. Use Case Diagram</h3><br></br>
	<table border="0" width="100%">
		<tr align="center">
			<td align="center">
				<img align="middle" alt="Use Case Diagram" src="<c:url value="/images/uml/UseCase.PNG"/>">
			</td>
		</tr>
	</table>
	<br><br><br>
	<hr color="black" style="width: 100%; height: 1px;">
	<br>
	<h3 style="TEXT-ALIGN: left"><a name="Img_ORMClass_Digaram"></a>Figure 2. ORM Class Diagram</h3><br></br>
	<table border="0" width="100%">
		<tr align="center">
			<td align="center">
				<img align="middle" alt="ORM Class Diagram" src="<c:url value="/images/uml/ORMClassDiagram.PNG"/>">
			</td>
		</tr>
	</table>
	<br><br><br><br>
	<hr color="black" style="width: 100%; height: 1px;">
	<br>
	<h3 style="TEXT-ALIGN: left"><a name="Img_ERDiagram_Diagram"></a>Figure 3. ER Diagram</h3><br></br>
	<table border="0" width="100%">
		<tr align="center">
			<td align="center">
				<img align="middle" alt="ER Diagram" src="<c:url value="/images/uml/ERDiagram.PNG"/>">
			</td>
		</tr>
	</table>
	<br><br><br>
	<hr color="black" style="width: 100%; height: 1px;">
	<br>
	<h3 style="TEXT-ALIGN: left"><a name="Img_FindAll_Sequence_Diagram"></a>Figure 4. Sequence Diagram - Find All Employees</h3><br></br>
	<table border="0" width="100%">
		<tr align="center">
			<td align="center">
				<img align="middle" alt="Sequence Diagram - Find All Employees" src="<c:url value="/images/uml/FindAllEmployeesSeqenceDiagram.PNG"/>">
			</td>
		</tr>
	</table>
	<br>
	<hr color="black" style="width: 100%; height: 1px;">
	<br>
	<h3 style="TEXT-ALIGN: left"><a name="Img_AddUpdateDelete_Sequence_Diagram"></a>Figure 5. Sequence Diagram - Add/Update/Delete Employee</h3><br></br>
	<table border="0" width="100%">
		<tr align="center">
			<td align="center">
				<img align="middle" alt="Sequence Diagram - Add/Update/Delete Employee" src="<c:url value="/images/uml/AddUpdateDeleteSeqenceDiagram.PNG"/>">
			</td>
		</tr>
	</table>
	
	<br>
	<hr color="black" style="width: 100%; height: 1px;">
	<br>
	<h3 style="TEXT-ALIGN: left"><a name="Img_Class_Diagram"></a>Figure 6. Class Diagram</h3><br></br>
	<table border="0" width="100%">
		<tr align="center">
			<td align="center">
				<img align="middle" alt="Class Diagram" src="<c:url value="/images/uml/ClassDiagram.PNG"/>">
			</td>
		</tr>
	</table>
	<br>
	<hr color="black" style="width: 100%; height: 1px;">
	<br>
</body>
</html>