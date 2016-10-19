package com.mvc.logica;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.dao.ContatoDao;

public class ExcluirLogica extends HttpServlet implements Logica{

	private static final long serialVersionUID = 1L;

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int id = -1;
		
		//pega o id informado no post do formulário e transforma em inteiro
		try{
			id = Integer.parseInt(request.getParameter("id"));
			
		}catch (Exception e) {
			return "erro.html";
		}
		
		//chamando método do banco de dados para remover pelo id
		ContatoDao.getInstance().removeById(id);
		
		System.out.println("Excluindo contato...");
		
		return "agenda.jsp";
	}
	
}
