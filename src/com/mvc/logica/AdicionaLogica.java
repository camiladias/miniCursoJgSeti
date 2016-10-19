package com.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.dao.ContatoDao;
import com.mvc.model.Contato;

public class AdicionaLogica implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		Contato contato = new Contato(req.getParameter("nome"),req.getParameter("telefone"),req.getParameter("email"));
		
		//chamando m�todo do banco de dados para salvar o objeto
		//somente uma inst�ncia roda pois apenas uma se��o no banco pode estar aberta
		ContatoDao.getInstance().persist(contato);
		
		return "agenda.jsp";
		
	}
}
