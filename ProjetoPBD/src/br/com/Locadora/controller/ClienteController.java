package br.com.Locadora.controller;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.swing.JOptionPane;

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
	
	public void insert(Cliente cliente){
		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			manager.persist(cliente);
			manager.getTransaction().commit();
			JOptionPane.showMessageDialog(null, "Cliente Cadastrado com Sucesso", null, JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			manager.getTransaction().rollback();
			JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Cliente", null, JOptionPane.ERROR_MESSAGE);
		} finally{
			manager.close();
		}
		
	}
	
	public void updatePF(PessoaFisica pf){

		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			manager.merge(pf);
			manager.getTransaction().commit();
			JOptionPane.showMessageDialog(null, "Cliente Alterado com Sucesso", null, JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			manager.getTransaction().rollback();
			JOptionPane.showMessageDialog(null, "Erro ao Alterar Cliente", null, JOptionPane.ERROR_MESSAGE);
		} finally {
			manager.close();
		}
	}
	
	public void updatePJ(PessoaJuridica pj){

		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			manager.merge(pj);
			manager.getTransaction().commit();
			JOptionPane.showMessageDialog(null, "Cliente Alterado com Sucesso", null, JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			manager.getTransaction().rollback();
			JOptionPane.showMessageDialog(null, "Erro ao Alterar Cliente", null, JOptionPane.ERROR_MESSAGE);
		} finally {
			manager.close();
		}
	}

	public void delete(PessoaFisica pf){

		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			PessoaFisica fisica = manager.find(PessoaFisica.class, pf.getId());
			manager.remove(fisica);
			manager.getTransaction().commit();
			JOptionPane.showMessageDialog(null, "Usuário Excluído com Sucesso", null, JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao Deletar Usuário", null, JOptionPane.ERROR_MESSAGE);
		} finally {
			manager.close();
		}

	}
	
	public void delete(PessoaJuridica pj){

		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			PessoaJuridica juridica = manager.find(PessoaJuridica.class, pj.getId());
			manager.remove(juridica);
			manager.getTransaction().commit();
			JOptionPane.showMessageDialog(null, "Usuário Excluído com Sucesso", null, JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao Deletar Usuário", null, JOptionPane.ERROR_MESSAGE);
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
