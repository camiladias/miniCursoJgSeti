<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Agenda eletr�nica - JavaGroup</title>
	</head>
	<body>
		<h2>Bem vindo a agenda eletr�nica</h2>
		<hr/>
		
		<form action="mvc" method="POST">
		
			<input type="hidden" value="LoginLogica" name="logica" id ="logica"/>
			Login:<input type="text" name="idUsuario" id="idUsuario"/><br/>
			Senha:<input type="password" name="senhaUsuario" id="senhaUsuario"/><br/>
			
			<input type="submit" value="Login"/> 
		
		</form>
		
		<hr/>
	</body>
</html>