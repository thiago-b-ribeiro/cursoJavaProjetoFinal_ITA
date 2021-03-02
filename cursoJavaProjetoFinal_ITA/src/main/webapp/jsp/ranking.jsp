<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE html>
<html>

	<head>
	
		<meta charset="utf-8">
		<title>Projeto Final - Java Avançado</title>
		
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style01.css">
	
	</head>

	<body>
	
		<div class="container01">
		
			<div class="box01">
			
				<table>
					<tr>
					
						<td>Colocação</td>
						<td>Nome</td>
						<td>Login</td>
						<td>Pontos</td>
					
					</tr>
					
					<c:forEach var="usuarios" items="${usuarios}">
						<tr>
							<td></td>
							<td>${usuarios.nome}</td>
							<td>${usuarios.login}</td>
							<td>${usuarios.pontos}</td>				
						</tr>
					</c:forEach>
			
				</table>
				
				<form action="consultarTopicos" method="post">
					<input type ="submit" value="Tópicos">
				</form>
				
			</div>
		
		</div>
	
	</body>

</html>