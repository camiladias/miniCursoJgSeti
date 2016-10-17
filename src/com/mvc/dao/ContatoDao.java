package com.mvc.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.mvc.model.Contato;

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
	
	/*find() chamado do EntityManager passando o tipo da classe o id que deve ser buscado, j� traz um objeto*/
	public Contato getById(final int id) {
		return entityManager.find(Contato.class, id);
	}

	/*createQuery que recebe uma String JPQL que � uma alternativa ao SQL em forma de orienta��o a objetos*/
	@SuppressWarnings("unchecked")
	public List<Contato> findAll() {
		return entityManager.createQuery("FROM " + Contato.class.getName()).getResultList();
	}
 
	/*M�todo que ir� salvar o objeto no banco*/
	public void persist(Contato contato) {
		try {
			entityManager.getTransaction().begin(); //Inicia uma transa��o
			entityManager.persist(contato);			//salva o objeto 
			entityManager.getTransaction().commit();//finaliza a transa��o
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();//Caso algum erro ocorra,todas as altera��es s�o desfeitas
		}
	}
		
	/*M�todo que ir� atualizar o objeto no banco. Se o registro n�o existir no banco, ele ir� inserir o mesmo.*/
	public void merge(Contato contato) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(contato); //atualiza o registro
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
	
	/*M�todo que ir� deleta o objeto no banco.*/
	public void remove(Contato contato) {
		try {
			entityManager.getTransaction().begin();
			contato = entityManager.find(Contato.class, contato.getId());
			entityManager.remove(contato);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	/*M�todo que ir� deleta o objeto no banco pelo ID.*/
	public void removeById(final int id) {
		try {
			Contato contato = getById(id);
			remove(contato);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
