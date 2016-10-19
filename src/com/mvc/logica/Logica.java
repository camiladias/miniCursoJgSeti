package com.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Logica {
	//cada classe de l�gica implementa seu pr�prio executa
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception;
}
