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
	
		<div class="container02">
		
			<div class="box02">
			
				<h1>${topicos.titulo}</h1>
				<h3>${topicos.topicoLogin}</h3>	
				
				<p> ${topicos.conteudo}		
			
			</div>
			
			<br>
			
			<div class="box03">
			
				<h2>Comentários:</h2>
			
				<c:forEach var="comentario" items="${comentarios}">
				
					${comentario.comentarioLogin} |	${comentario.comentario} <br>
				
				</c:forEach>
			
			</div>
			
			<br>
			
			<div class="box04">
				
				<form action="inserirComentario" method="post">
				
					<label for="comentario"> Insira seu comentário: <br>
						<input name="comentario" type="text">
					</label>
					
					<input type="hidden" name="idTopico" value="${topicos.idTopico}">
					
					<input type="submit" value="Enviar"/>
					
				</form>
				
				<form action="consultarTopicos" method="post">
					<input type="submit" value="Tópicos">
				</form>
					
			</div>
		
		</div>
	
	</body>

</html>