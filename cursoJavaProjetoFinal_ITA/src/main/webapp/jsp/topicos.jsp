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
		
			<div class="lista">
			
				<table>
					
					<tr>
					
						<td>Usuário</td>
						<td>Título</td>
					
					</tr>
					
					<c:forEach var="topicos" items="${topicos}">
					
						<tr>
						
							<td>
								${topicos.topicoLogin}
							</td>
							<td>
								<a href="${pageContext.request.contextPath}/exibirTopico?idTopico=${topicos.idTopico}">${topicos.titulo}</a>
							</td>
						
						</tr>
					
					</c:forEach>
			
				</table>
				
				<br>
				
				<form action="rankearUsuarios" method="post">
					<input type="submit" value="Ranking"/>
				</form>
				
				<button type="button" onClick="location.href='jsp/insereTopicos.jsp'">Inserir tópico</button>
				
			</div>
		
		</div>
	
	</body>

</html>