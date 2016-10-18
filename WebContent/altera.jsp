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
		    <input type="hidden" id="logica" name="logica" value="AlteraContatoLogica">
		    
		    Nome: <input type="text" id="nomeContato" name="nome" value="<%=request.getParameter("nome")%>"/><br />
		    E-mail: <input type="text" name="email" value="<%=request.getParameter("email")%>"/><br/>
		    Endereço: <input type="text" name="endereco" value="<%=request.getParameter("endereco")%>"/><br/>  
		    Data Nascimento: <input type="text" id="dataNascimento" name="dataNascimento" value="<%=request.getParameter("dataNascimento")%>"/><br/>
		    	<script>$("#dataNascimento").datepicker();</script>
		    
		    <!-- Passei o ID escondido também heuheuheheu -->
		    <input  type="hidden" id="id" name="id" value="<%=request.getParameter("id") %>"/>
		      
     		<input type="submit" value="Alterar" />
	      
	    </form>
	</body>
</html>