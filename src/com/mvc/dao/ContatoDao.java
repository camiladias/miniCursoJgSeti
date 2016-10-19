package com.mvc.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.mvc.model.Contato;

public class ContatoDao {
	
	private static ContatoDao instance;
	protected EntityManager entityManager;

	//contrustor sempre vai chamar o getEntityManager()
	public ContatoDao() {
		entityManager = getEntityManager();
	}
	
	/*getEntityManager() é responsável por criar uma instância de EntityManager.*/
	private EntityManager getEntityManager() {
		//agenda é a persistence-unit do persistence.xml, com as configurações do banco
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("agenda");
		if (entityManager == null) {
			entityManager = factory.createEntityManager(); //esse metodo só pode rodar uma vez, não pode haver dois EntityManager ao mesmo tempo 
		}
		return entityManager;
	}

	//garante que somente uma instancia do EntityManager esteja ativa pra uma persistence-unit 
	public static ContatoDao getInstance(){
		if (instance == null){
			instance = new ContatoDao();
		}
		return instance;
	}
	
		
	/*find() chamado do EntityManager passando o tipo da classe o id que deve ser buscado, já traz um objeto*/
	public Contato getById(final int id) {
		return entityManager.find(Contato.class, id);
	}

	/*createQuery que recebe uma String JPQL que é uma alternativa ao SQL em forma de orientação a objetos*/
	@SuppressWarnings("unchecked")
	public List<Contato> findAll() {
		return entityManager.createQuery("FROM " + Contato.class.getName()).getResultList();
	}
 
	/*Método que irá salvar o objeto no banco*/
	public void persist(Contato contato) {
		try {
			entityManager.getTransaction().begin(); //Inicia uma transação
			entityManager.persist(contato);			//salva o objeto 
			entityManager.getTransaction().commit();//finaliza a transação
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();//Caso algum erro ocorra,todas as alterações são desfeitas
		}
	}
		
	/*Método que irá atualizar o objeto no banco. Se o registro não existir no banco, ele irá inserir o mesmo.*/
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
	
	/*Método que irá deleta o objeto no banco.*/
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

	/*Método que irá deleta o objeto no banco pelo ID.*/
	public void removeById(final int id) {
		try {
			Contato contato = getById(id);
			remove(contato);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
