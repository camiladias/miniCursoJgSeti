package com.mvc.dao;
import javax.persistence.*;

public class ContatoDao {
	
	private static ContatoDao instance;
	protected EntityManager entityManager;

	private ContatoDao() {
		entityManager = getEntityManager();
	}

	public static ContatoDao getInstance(){
		if (instance == null){
			instance = new ContatoDao();
		}
		return instance;
	}
	
	/*getEntityManager() � respons�vel por criar uma inst�ncia de EntityManager.*/
	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("agenda");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}
	
	

}
