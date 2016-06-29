package br.com.Locadora.controller;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import br.com.Locadora.model.Cliente;
import br.com.Locadora.model.PessoaFisica;
import br.com.Locadora.model.PessoaJuridica;

public class ClienteController {
	EntityManagerFactory factory;
	EntityManager manager;
	
	public ClienteController(){
		factory = HibernateSingleton.getInstance("HibMysql");
		manager = factory.createEntityManager();
	}
	
	public void salvar(Cliente cliente){
		manager.getTransaction().begin();
		manager.persist(cliente);
		manager.getTransaction().commit();
		manager.close();
	}
	
	public Cliente consultaId(int id){
		manager.getTransaction().begin();
		Cliente cliente = manager.find(Cliente.class, id);
		manager.getTransaction().commit();
		manager.close();
		return cliente;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> consultaNome(String Nome){
		manager.getTransaction().begin();
		Query query = manager.createQuery("select p from Cliente p where c.nome like :param");
		query.setParameter("param", "%"+Nome+"%");
		List<Cliente> clientes = query.getResultList(); 
		manager.getTransaction().commit();
		return clientes;
	}
	
	@SuppressWarnings("unchecked")
	public List<PessoaFisica> consultaClientesPF(){
		manager.getTransaction().begin();
		Query query = manager.createQuery("select pf from PessoaFisica pf");
		List<PessoaFisica> clientes = query.getResultList(); 
		manager.getTransaction().commit();
		return clientes;
	}
	
	@SuppressWarnings("unchecked")
	public List<PessoaJuridica> consultaClientesPJ(){
		manager.getTransaction().begin();
		Query query = manager.createQuery("select pj from PessoaJuridica pj");
		List<PessoaJuridica> clientes = query.getResultList(); 
		manager.getTransaction().commit();
		return clientes;
	}
	
}
