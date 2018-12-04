package br.ufac.academico.repositorios;

import java.util.*;
import javax.persistence.*;
import br.ufac.academico.entidades.*;

public class BancosRepositorio {

	private EntityManagerFactory emf;
	private EntityManager em;	
	
	public BancosRepositorio() {
		emf = Persistence.createEntityManagerFactory("AcademicoJPA");
		em = emf.createEntityManager();
	}

	public void adicionar(Banco banco) {	
		em.getTransaction().begin();
		em.persist(banco);
		em.getTransaction().commit();
		
	}
	
	public Banco recuperar(long id) {
		return em.find(Banco.class, id);
	}
	
	public void atualizar (Banco Bancos) {
		em.getTransaction().begin();
		em.merge(Bancos);
		em.getTransaction().commit();
	}
	
	public void remover(Banco Bancos) {
		em.getTransaction().begin();
		em.remove(Bancos);
		em.getTransaction().commit();
		
	}
	
	public List<Banco> recuperarTodos(){
		Query query = em.createNamedQuery("Bancos.todos");
		return query.getResultList();
		
	}

	public List<Banco> recuperarTodosPorNome(){
		Query query = em.createNamedQuery("Bancos.todosPorNome");
		return query.getResultList();
		
	}
	
	public List<Banco> recuperarTodosPorNomeContendo(String termo){
		return em.createNamedQuery("Bancos.todosPorNomeContendo")
				.setParameter("termo", "%"+termo+"%")
				.getResultList();
	}
	
	public void encerrar() {
		em.close();
		emf.close();
	}
	
}