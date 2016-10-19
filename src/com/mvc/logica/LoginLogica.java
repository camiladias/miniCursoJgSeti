package com.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginLogica implements Logica {
	
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
