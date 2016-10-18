<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    import="java.util.*, com.mvc.dao.*, com.mvc.model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Bem vindo ao sistema</title>
	</head>
	<body>
		Bem vindo a agenda (:<br/>
		
		<form action="mvc" method="POST">
			<input id="logica" name="logica" type="hidden" value="AdicionaPaginaLogica"/>
			<input type="submit" value="Adicionar Contato"/><br/><br/>
		</form>
		<form action="mvc" method="POST">
			<input id="logica"  name="logica" type="hidden" value="ListaLogica"/>
			<input type="submit" value="Listar Todos"/><br/>
		</form>
		
	</body>
</html>