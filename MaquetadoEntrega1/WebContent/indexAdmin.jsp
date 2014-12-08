	<%@ taglib prefix="s" uri="/struts-tags" %>
	
	<jsp:include page="hederAdmin.jsp"></jsp:include>
	<h1>
		<% 
			if(session.getAttribute("usuario") != null){
				System.out.println("sesion creada");
			}else{
				System.out.println("No creo la sesion");
			}
		%>	
		<s:property value="usuario" />
		
	</h1>