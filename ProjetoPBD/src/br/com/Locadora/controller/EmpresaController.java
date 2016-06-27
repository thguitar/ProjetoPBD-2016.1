package br.com.Locadora.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import br.com.Locadora.model.Empresa;

public class EmpresaController {
	EntityManagerFactory factory;
	EntityManager manager;
	
	public EmpresaController(){
		factory = HibernateSingleton.getInstance("HibMysql");
		manager = factory.createEntityManager();
	}
	
	public Empresa consultaId(int id){
		manager.getTransaction().begin();
		Empresa emp = manager.find(Empresa.class, id);
		manager.getTransaction().commit();
		manager.close();
		return emp;
	}
	
	public void salvar(Empresa emp){
		manager.getTransaction().begin();
		manager.persist(emp);
		manager.getTransaction().commit();
		manager.close();
	}
	
	public void remover(Empresa emp){
		manager.getTransaction().begin();
		manager.remove(emp);
		manager.getTransaction().commit();
		manager.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Empresa> consultaNome(String Nome){
		manager.getTransaction().begin();
		Query query = manager.createQuery("select e from Empresa e where e.nome like :param");
		query.setParameter("param", "%"+Nome+"%");
		List<Empresa> empresas = query.getResultList(); 
		manager.getTransaction().commit();
		return empresas;
	}
	
	@SuppressWarnings("unchecked")
	public List<Empresa> consultaEmpresas(){
		manager.getTransaction().begin();
		Query query = manager.createQuery("select e from Empresa e");
		List<Empresa>empresas = query.getResultList(); 
		manager.getTransaction().commit();
		return empresas;
	}
}
