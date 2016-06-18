package br.com.Locadora.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.Locadora.model.Usuario;

public class UsuarioController {
	EntityManagerFactory emf;
	EntityManager em;
	
	public UsuarioController(){
		emf = Persistence.createEntityManagerFactory("Brito");
		em = emf.createEntityManager();
	}
	public void salvar(Usuario u){
		em.getTransaction().begin();
		em.merge(u);
		em.getTransaction().commit();
		em.close();
	}
	
	public void remover(Usuario u){
		em.getTransaction().begin();
		em.remove(u);
		em.getTransaction().commit();
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> listarTodos(){
		em.getTransaction().begin();
		Query consulta = em.createQuery("select usuario from Usuario usuario");
		List<Usuario> usuarios = consulta.getResultList();
		em.getTransaction().commit();
		em.close();
		return usuarios;
	}
}
