package com.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.dao.ContatoDao;
import com.mvc.model.Contato;

public class AlteraLogica implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		Contato contato = new Contato();
		
		contato.setNome(req.getParameter("nome"));
		contato.setEmail(req.getParameter("email"));
		contato.setTelefone(req.getParameter("telefone"));
		
		try{
			contato.setId(Integer.parseInt(req.getParameter("id")));
		}catch(Exception e){
			req.getRequestDispatcher("erro.html").forward(req, res);
		}
		
		try{
			ContatoDao.getInstance().merge(contato);
		}catch(Exception e){
			req.getRequestDispatcher("erro.html").forward(req, res);
		}
		
		return "agenda.jsp";
	}

}
