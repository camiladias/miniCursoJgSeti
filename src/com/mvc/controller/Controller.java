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
	
	/*trata uma requisi��o http 
	 * request = requisi��o
	 * response = resposta para a requisi��o
	*/
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String parametro = request.getParameter("logica"); //obtem da requisi��o o parametro com nome de logica
		String nomeDaClasse = "com.mvc.logica." + parametro; //forma o nome da classe
		
		try {
			Class<?> classe = Class.forName(nomeDaClasse);
			
			//instancia a classe que foi recebida
			Logica logica = (Logica) classe.newInstance();
			String pagina = logica.executa(request, response);
			
			//encaminha para a classe respons�vel por tratar a a��o
			request.getRequestDispatcher(pagina).forward(request, response);
			
		} catch (Exception e) {
			throw new ServletException("A l�gica de neg�cios causou uma exce��o", e);
		}
	}
}