	<%@ taglib prefix="s" uri="/struts-tags" %>
	
	<% 
	if(session.getAttribute("usuarioAdministrador") != null){		
	%>	
		<jsp:include page="hederAdmin.jsp"></jsp:include>
	<% } %>