package com.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.logica.Logica;

@WebServlet("/mvc")
public class Controller extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	/*trata uma requisição http 
	 * request = requisição
	 * response = resposta para a requisição
	*/
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String parametro = request.getParameter("logica"); //obtem da requisição o parametro com nome de logica
		String nomeDaClasse = "com.mvc.logica." + parametro; //forma o nome da classe
		
		try {
			Class<?> classe = Class.forName(nomeDaClasse);
			
			//instancia a classe que foi recebida
			Logica logica = (Logica) classe.newInstance();
			String pagina = logica.executa(request, response);
			
			//encaminha para a classe responsável por tratar a ação
			request.getRequestDispatcher(pagina).forward(request, response);
			
		} catch (Exception e) {
			throw new ServletException("A lógica de negócios causou uma exceção", e);
		}
	}
}