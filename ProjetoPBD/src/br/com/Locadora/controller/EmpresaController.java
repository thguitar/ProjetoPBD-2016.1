package br.com.Locadora.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import br.com.Locadora.model.Empresa;

public class EmpresaController {
	EntityManagerFactory factory;
	EntityManager manager;
	
	public EmpresaController(){
		factory = HibernateSingleton.getInstance("HibMysql");
		manager = factory.createEntityManager();
	}
	
	public Empresa consultaId(int id){
		
		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			Empresa emp = manager.find(Empresa.class, id);
			manager.getTransaction().commit();
			return emp;
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao Buscar Empresa", "Erro Busca", JOptionPane.ERROR_MESSAGE);
			manager.getTransaction().rollback();
			return null;
		} finally{
			manager.close();
		}
	}
	
	public void insert(Empresa emp){
		
		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			manager.persist(emp);
			manager.getTransaction().commit();
			JOptionPane.showMessageDialog(null, "Empresa Cadastrada com Sucesso", "Mensagem Cadastro", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			manager.getTransaction().rollback();
			JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Empresa", "Erro Inserção", JOptionPane.ERROR_MESSAGE);
		} finally{
			manager.close();
		}
	}
	
	public void update(Empresa emp){

		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			manager.merge(emp);
			manager.getTransaction().commit();
			JOptionPane.showMessageDialog(null, "Empresa Alterada com Sucesso", "Mensagem Cadastro", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			manager.getTransaction().rollback();
			JOptionPane.showMessageDialog(null, "Erro ao Alterar Empresa", "Erro Autalização", JOptionPane.ERROR_MESSAGE);
		} finally {
			manager.close();
		}
	}
	
	public void delete(int id){
		
		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			Empresa empresa = manager.find(Empresa.class, id);
			manager.remove(empresa);
			manager.getTransaction().commit();
			JOptionPane.showMessageDialog(null, "Empresa Excluída com Sucesso", "Mensagem Cadastro", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao Deletar Empresa", "Erro Remoção", JOptionPane.ERROR_MESSAGE);
		} finally {
			manager.close();
		}
		
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
	
	@SuppressWarnings("unchecked")
	public List<Empresa> listALL(){
		manager.getTransaction().begin();
		Query query = manager.createQuery("select e from Empresa e");
		List<Empresa>empresas = query.getResultList(); 
		manager.getTransaction().commit();
		return empresas;
	}
}
