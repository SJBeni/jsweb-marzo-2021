<%@page import="ar.com.educacionit.services.impl.LoginServiceImp"%>
<%@page import="ar.com.educacionit.services.LoginService"%>
<%@page import="ar.com.educacionit.domain.User"%>
<html>
	<head>
		<jsp:include page="styles.jsp"></jsp:include>
	</head>
	
	<body>
		<jsp:include page="navbar.jsp"></jsp:include>
		<div class="container">
			<div class="row">
				<div class="col-12 mt-2">
					<%
					//scriplet: codigo java
					String username = request.getParameter("username");
					String password = request.getParameter("password");
					
					LoginService ls = new LoginServiceImp();
					User user = ls.getUserByUserName(username);
					
					
					if(user != null && user.getPassword().equals(password)){
					%>
						<div class="alert alert-success" role="alert">
						  Username:<%=user.getUsername().toUpperCase() %>
						</div>
					<%
					}else{			
					%>	
						<div class="alert alert-danger" role="alert">
  							DATOS INVALIDOS
						</div>
					<%
					}
					
					%>
					<ul>
						<li>
							<a href = "<%=request.getContextPath()%>/login.jsp">Volver al login</a>
						</li>				
						<li>
							<a href = "<%=request.getContextPath()%>/verListado.jsp">Ver Listado</a>
						</li>				
					</ul>
				</div>
			</div>
		</div>
	</body>

</html>