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
		Bem vindo a agenda (:
		
		<form action="mvc" method="POST">
			<input type="hidden" value="AdicionaPaginaLogica"/>
			<input type="submit" value="Listar Todos"/><br/>
		</form>
		<form action="mvc" method="POST">
			<input type="hidden" value="ListaLogica"/>
			<input type="submit" value="Listar Todos"/><br/>
		</form>
		
		<table>
		  <!-- percorre contatos montando as linhas da tabela -->
		  <c:forEach var="contato" items="${dao.lista}">
		    <tr>
		      <td>${contato.nome}</td>
		      <td>${contato.email}</td>
		      <td>${contato.endereco}</td>
		      <td>${contato.dataNascimento.time}</td>
		      <td>
		      	<form action="mvc" method="POST">
		      		<input type="hidden" value="AlteraPaginaLogica"/>
		      		<input type="submit" value="Editar"/>
		      	</form>
		      </td>
		      <td>
		      	<form action="mvc" method="POST">
		      		<input type="hidden" value="${contato.id" name="id"/>
		      		<input type="hidden" value="AlteraPaginaLogica"/>
		      		<input type="submit" value="Editar"/>
		      	</form>
		      </td>
		      <td>
		      	<form action="mvc" method="POST">
		      		<input type="hidden" value="${contato.id}" name="id"/>
		      		<input type="hidden" value="ExcluirLogica"/>
		      		<input type="submit" value="Excluir"/>
		      	</form>
		      </td>
		    </tr>
		  </c:forEach>
		</table>
		
	</body>
</html>