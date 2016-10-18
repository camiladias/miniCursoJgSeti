package com.mvc.logica;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.dao.ContatoDao;

public class ExcluirLogica extends HttpServlet implements Logica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int id = (Integer) null;
		try{
			id = Integer.getInteger(request.getParameter("id"));
			
		}catch (Exception e) {
			return "erro.jsp";
		}
		
		ContatoDao.getInstance().removeById(id);
		
		System.out.println("Excluindo contato...");
		
		return "lista.jsp";
	}
	
}
