package br.com.Locadora.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import br.com.Locadora.model.TiposLocacao;

public class TiposLocacaoController {
	EntityManagerFactory factory;
	EntityManager manager;
	
	public TiposLocacaoController(){
		factory = HibernateSingleton.getInstance("HibMysql");
		manager = factory.createEntityManager();
	}
	
	public TiposLocacao consultaId(int id){
		
		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			TiposLocacao tiposLocacao = manager.find(TiposLocacao.class, id);
			manager.getTransaction().commit();
			return tiposLocacao;
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao Buscar Tipo", "Erro Busca", JOptionPane.ERROR_MESSAGE);
			manager.getTransaction().rollback();
			return null;
		} finally{
			manager.close();
		}
	}
	
	
	public boolean update(TiposLocacao tiposLocacao){

		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			manager.merge(tiposLocacao);
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
	
	@SuppressWarnings("unchecked")
	public List<TiposLocacao> ConsultaUpdate(){
		
		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			Query query = manager.createQuery("select t from TiposLocacao t");
			List<TiposLocacao> tiposLocacaos = query.getResultList(); 
			return tiposLocacaos;
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao Buscar Tipos", "Erro Busca", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		
	}
	
	public boolean commit(){
		try {
			manager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
	
	
}
