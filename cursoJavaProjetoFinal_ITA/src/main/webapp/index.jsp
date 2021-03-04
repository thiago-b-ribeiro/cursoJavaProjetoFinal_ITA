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
		
			<h1>${falhaAcesso}</h1>
			
			<div class="box01">
				
				<form action="validarUsuario" method="post">
					
					<label for="login">Usuário: 
						<input name="login" type="text">
					</label>
					
					<label for="senha">Senha: 
						<input name="senha" type="password">
					</label>
					
					<br>
					
					<input type="submit" value="Acessar"/>
					<button type="button" onClick="location.href='jsp/cadastraUsuario.jsp'">Cadastrar</button>
				
				</form>
				
				
			</div>
			
		</div>
		
	</body>

</html>