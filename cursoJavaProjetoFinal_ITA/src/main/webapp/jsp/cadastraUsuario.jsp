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
			
				<form action="../cadastrarUsuario" method="post">
				
					<label for="nome">Nome: 
						<input name="nome" type="text">
					</label>

					<label for="login">Login: 
						<input name="login" type="text">
					</label>					

					<label for="email">E-mail: 
						<input name="email" type="text">
					</label>
					
					<label for="senha">Senha: 
						<input name="senha" type="text">
					</label>
					
					<input type="submit" value="Cadastrar"/>
					
				</form>
			
			</div>
		
		</div>
	
	</body>

</html>