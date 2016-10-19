package com.mvc.logica;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD
public class LoginLogica implements Logica {
=======
public class LoginLogica extends HttpServlet implements Logica {
>>>>>>> 4340cb3c36b491fc46b82e624fa74526fca55786

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

		if ((req.getParameter("idUsuario").equals("admin")) && (req.getParameter("senhaUsuario").equals("admin"))) {
			System.out.println("VITORIA!");
			return "agenda.jsp";
		} else {
			System.out.println("Derrota!");
			return "404.html";
		}

	}

}
