package br.com.Locadora.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import br.com.Locadora.model.Empresa;
import br.com.Locadora.model.Usuario;

public class UsuarioController {
	EntityManagerFactory factory;
	EntityManager manager;
	
	public UsuarioController(){
		factory = HibernateSingleton.getInstance("HibMysql");
		manager = factory.createEntityManager();
	}
	
	public Usuario consultaId(int id){
		manager.getTransaction().begin();
		Usuario usuario = manager.find(Usuario.class, id);
		manager.getTransaction().commit();
		manager.close();
		return usuario;
	}
	
	public void salvar(Usuario u){
		manager.getTransaction().begin();
		manager.merge(u);
		manager.getTransaction().commit();
		manager.close();
	}
	
	public void remover(Usuario u){
		manager.getTransaction().begin();
		manager.remove(u);
		manager.getTransaction().commit();
		manager.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> consultaNome(String Nome){
		manager.getTransaction().begin();
		Query query = manager.createQuery("select u from Usuario u where u.nome like :param");
		query.setParameter("param", "%"+Nome+"%");
		List<Usuario> usuarios = query.getResultList();
		manager.getTransaction().commit();
		manager.close();
		return usuarios;
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> listarTodos(){
		manager.getTransaction().begin();
		Query consulta = manager.createQuery("select usuario from Usuario usuario");
		List<Usuario> usuarios = consulta.getResultList();
		manager.getTransaction().commit();
		manager.close();
		return usuarios;
	}
	
	@SuppressWarnings("unchecked")
	public List<Empresa> consultaEmpresas(){
		manager.getTransaction().begin();
		Query query = manager.createQuery("select u from Empresa u");
		List<Empresa>empresas = query.getResultList(); 
		manager.getTransaction().commit();
		return empresas;
	}
}
