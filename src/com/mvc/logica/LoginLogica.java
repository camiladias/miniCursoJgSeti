package com.mvc.logica;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginLogica implements Logica {

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
