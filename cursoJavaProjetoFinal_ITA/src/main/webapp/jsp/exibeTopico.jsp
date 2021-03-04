<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE html>
<html>

	<head>
	
		<meta charset="utf-8">
		<title>Projeto Final - Java Avançado</title>
		
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style01.css">
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/chamaServlet.js"></script>
	</head>

	<body>
	
		<div class="container02">
		
			<div>
			
				<h1>${topicos.titulo}</h1>
				<h3>${topicos.topicoLogin}</h3>	
				
				<p> ${topicos.conteudo}		
			
			</div>
			
			<br>
			
			<div class="box01">
			
				<h2>Comentários:</h2>
			
				<c:forEach var="comentario" items="${comentarios}">
				
					${comentario.comentarioLogin} |	${comentario.comentario} <br>
				
				</c:forEach>
			
			</div>
			
			<br>
			
			<form action="inserirComentario" method="post" id="inserirComentario">
			
				<label for="comentario" style="text-align:left;"> Insira seu comentário: <br>
					<input name="comentario" type="text" style="width:325px;">
				</label>
				
				<input type="hidden" name="idTopico" value="${topicos.idTopico}">
					
				<input type="submit" value="Enviar"/>
						
			</form>
			
			<button class="button410px" onClick="chamaServlet('consultarTopicos')">Tópicos</button>
			
			
		
		</div>
	
	</body>

</html>