	<%@ taglib prefix="s" uri="/struts-tags" %>
	<% 
	if(session.getAttribute("usuarioViajero") != null){
	%>
		<jsp:include page="hederViajero.jsp"></jsp:include>
	<% 
	}
	%>
		
	