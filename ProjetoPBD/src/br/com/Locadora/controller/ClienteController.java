package br.com.Locadora.controller;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.RollbackException;





import br.com.Locadora.model.Cliente;
import br.com.Locadora.model.PessoaFisica;
import br.com.Locadora.model.PessoaJuridica;
import br.com.Locadora.view.Warnings;

public class ClienteController {
	EntityManagerFactory factory;
	EntityManager manager;
	
	public ClienteController(){
		factory = HibernateSingleton.getInstance("HibMysql");
		manager = factory.createEntityManager();
	}
	
	public boolean insert(Cliente cliente){
		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			manager.persist(cliente);
			manager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			manager.getTransaction().rollback();
			return false;
		} finally{
			manager.close();
		}
		
	}
	
	public boolean updatePF(PessoaFisica pf){

		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			manager.merge(pf);
			manager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			manager.getTransaction().rollback();
			return false;
		} finally {
			manager.close();
		}
	}
	
	public boolean updatePJ(PessoaJuridica pj){

		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			manager.merge(pj);
			manager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			manager.getTransaction().rollback();
			return false;
		} finally {
			manager.close();
		}
	}

	public boolean deletePF(int id){
		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			PessoaFisica fisica = manager.find(PessoaFisica.class, id);
			manager.remove(fisica);
			manager.getTransaction().commit();
			return true;
		}catch(RollbackException rollbackException){
			rollbackException.printStackTrace();
			if(rollbackException.getCause().getCause().getClass().getName().equals("org.hibernate.exception.ConstraintViolationException"))
				Warnings.showMessageDialog(Warnings.CLIENT_DELETE_ERROR, "\nEste cliente não pode ser eliminado porque está relacionado a outros registros.");
			return false;
		}
		catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
			return false;
		} finally {
			manager.close();
		}

	}
	
	public boolean deletePJ(int id){

		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			PessoaJuridica juridica = manager.find(PessoaJuridica.class, id);
			manager.remove(juridica);
			manager.getTransaction().commit();
			return true;
		}catch(RollbackException rollbackException){
			rollbackException.printStackTrace();
			if(rollbackException.getCause().getCause().getClass().getName().equals("org.hibernate.exception.ConstraintViolationException"))
				Warnings.showMessageDialog(Warnings.CLIENT_DELETE_ERROR, "\nEste cliente não pode ser eliminado porque está relacionado a outros registros.");
			return false;
		}
		catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
			return false;
		} finally {
			manager.close();
		}

	}
	
	public Cliente consultaId(int id){
		manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Cliente cliente = manager.find(Cliente.class, id);
		manager.getTransaction().commit();
		manager.close();
		return cliente;
	}
	
	public PessoaFisica consultaPFId(int id){
		manager = factory.createEntityManager();
		manager.getTransaction().begin();
		PessoaFisica pf = manager.find(PessoaFisica.class, id);
		manager.getTransaction().commit();
		manager.close();
		return pf;
	}
	
	public PessoaJuridica consultaPJId(int id){
		manager = factory.createEntityManager();
		manager.getTransaction().begin();
		PessoaJuridica pj = manager.find(PessoaJuridica.class, id);
		manager.getTransaction().commit();
		manager.close();
		return pj;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> consultaNome(String Nome){
		manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Query query = manager.createQuery("select p from Cliente p where c.nome like :param");
		query.setParameter("param", "%"+Nome+"%");
		List<Cliente> clientes = query.getResultList(); 
		manager.getTransaction().commit();
		return clientes;
	}
	
	@SuppressWarnings("unchecked")
	public List<PessoaFisica> consultaClientesPF(){
		manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Query query = manager.createQuery("select pf from PessoaFisica pf");
		List<PessoaFisica> clientes = query.getResultList(); 
		manager.getTransaction().commit();
		return clientes;
	}
	
	@SuppressWarnings("unchecked")
	public List<PessoaJuridica> consultaClientesPJ(){
		manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Query query = manager.createQuery("select pj from PessoaJuridica pj");
		List<PessoaJuridica> clientes = query.getResultList(); 
		manager.getTransaction().commit();
		return clientes;
	}
	
}
