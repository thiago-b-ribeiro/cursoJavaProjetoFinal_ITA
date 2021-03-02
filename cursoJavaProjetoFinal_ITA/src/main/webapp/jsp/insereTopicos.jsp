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
			
				<form action="../inserirTopico" method="post">

					<label for="titulo">Título: 
						<input name="titulo" type="text"/>
					</label>
					
					<label for="conteudo">Texto: 
						<input name="conteudo" type="text"/>
					</label>
				
					<input type="submit" value="Gravar"/>
				
				</form>
			
			</div>
		
		</div>
	
	</body>

</html>