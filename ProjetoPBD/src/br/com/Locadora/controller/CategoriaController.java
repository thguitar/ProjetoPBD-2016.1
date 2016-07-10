package br.com.Locadora.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import br.com.Locadora.model.Categoria;

public class CategoriaController {
	EntityManagerFactory factory;
	EntityManager manager;
	
	public CategoriaController(){
		factory = HibernateSingleton.getInstance("HibMysql");
		manager = factory.createEntityManager();
	}
	
	public Categoria consultaId(int id){
		
		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			Categoria categoria = manager.find(Categoria.class, id);
			manager.getTransaction().commit();
			return categoria;
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao Buscar Categoria", "Erro Busca", JOptionPane.ERROR_MESSAGE);
			manager.getTransaction().rollback();
			return null;
		} finally{
			manager.close();
		}
	}
	
	public boolean insert(Categoria categoria){
		
		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			manager.persist(categoria);
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
	
	public boolean update(Categoria categoria){

		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			manager.merge(categoria);
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
	
	public void delete(int id){
		
		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			Categoria categoria = manager.find(Categoria.class, id);
			manager.remove(categoria);
			manager.getTransaction().commit();
			JOptionPane.showMessageDialog(null, "Categoria Excluída com Sucesso", "Mensagem Cadastro", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao Deletar Categoria", "Erro Remoção", JOptionPane.ERROR_MESSAGE);
		} finally {
			manager.close();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Categoria> consultaDescricao(String descricao){
		
		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			Query query = manager.createQuery("select c from Categoria c where c.descricao like :param");
			query.setParameter("param", "%"+descricao+"%");
			List<Categoria> categorias = query.getResultList(); 
			manager.getTransaction().commit();
			return categorias;
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao Buscar Categoria", "Erro Busca", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Categoria> ListALL(){
		
		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			Query query = manager.createQuery("select c from Categoria c");
			List<Categoria> categorias = query.getResultList(); 
			manager.getTransaction().commit();
			return categorias;
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao Buscar Categoria", "Erro Busca", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		
	}
	
}
