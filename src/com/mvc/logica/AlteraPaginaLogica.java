package com.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.dao.ContatoDao;
import com.mvc.model.Contato;

public class AlteraPaginaLogica implements Logica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int id = (Integer) null;
		try{
			id = Integer.getInteger(request.getParameter("id"));
			
		}catch (Exception e) {
			return "erro.jsp";
		}
		
		Contato contato = ContatoDao.getInstance().getById(id);		
		request.setAttribute("contato", contato);
		
		return "altera.jsp";
	}
	
}
