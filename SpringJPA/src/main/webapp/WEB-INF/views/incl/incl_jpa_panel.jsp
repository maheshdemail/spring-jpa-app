<%@ include file="taglibs.jsp" %>

<table class="custom" border="0" cellpadding="3" cellspacing="0" width="98%" id="filterTable" align="left">
<tr>
	<td width="100%">
		<fieldset style="border: 1px #336600;font-size: 11px;font-size:90%;"><legend>Select JPA method for your search</legend>	<br>
			<table class="custom" border="0" cellpadding="3" cellspacing="0" width="100%" id="filterTable" align="left">
			  	<tr>
			  		<td align="left" width="20%">
			  			<c:forEach var="enum" items="${jpaMethods}">
					 		<form:radiobutton path="jpaMethod" value="${enum}"/>${enum.jpaType}<br>
						</c:forEach>
					 </td>
				</tr>
			 </table>
		 </fieldset>
  	</td>
 </tr>
</table>