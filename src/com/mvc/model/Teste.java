package com.mvc.model;
import com.mvc.dao.*;

public class Teste {

	public static void main(String[] args) {
		Contato contato1 = new Contato("Camila", "38222598", "camila@camila.com");
		
		ContatoDao.getInstance().merge(contato1);

	}

}
