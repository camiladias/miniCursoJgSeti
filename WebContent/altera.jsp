<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<form action="mvc" method="GET">
	    
	    	<!-- Passei o Logica no formulário escondido hihi -->
		    <input type="hidden" id="logica" name="logica" value="AlteraLogica">
		    
		    Nome: <input type="text" id="nomeContato" name="nome" value="${contato.nome}"/><br />
		    Telefone: <input type="text" name="telefone" value="${contato.telefone}"/><br/>
		    Email: <input type="text" name="email" value="${contato.email}"/><br/>  
		    
		    <!-- Passei o ID escondido também heuheuheheu -->
		    <input  type="hidden" id="id" name="id" value="${contato.id}"/>
		      
     		<input type="submit" value="Alterar" />
	      
	    </form>
	</body>
</html>