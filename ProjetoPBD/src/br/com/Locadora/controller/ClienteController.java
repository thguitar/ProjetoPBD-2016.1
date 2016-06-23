package br.com.Locadora.controller;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.Locadora.model.Cliente;

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
	
}
