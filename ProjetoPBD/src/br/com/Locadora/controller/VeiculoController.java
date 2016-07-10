package br.com.Locadora.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import br.com.Locadora.model.Veiculo;

public class VeiculoController {
	EntityManagerFactory factory;
	EntityManager manager;
	
	public VeiculoController(){
		factory = HibernateSingleton.getInstance("HibMysql");
		manager = factory.createEntityManager();
	}
	
	public Veiculo consultaId(int codigo){
		
		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			Veiculo veiculo = manager.find(Veiculo.class, codigo);
			manager.getTransaction().commit();
			return veiculo;
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao Buscar Veículo", "Erro Busca", JOptionPane.ERROR_MESSAGE);
			manager.getTransaction().rollback();
			return null;
		} finally{
			manager.close();
		}
	}
	
	public Veiculo consultaIdUpdate(int codigo){
		
		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			Veiculo veiculo = manager.find(Veiculo.class, codigo);
			return veiculo;
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao Buscar Veículo", "Erro Busca", JOptionPane.ERROR_MESSAGE);
			manager.getTransaction().rollback();
			return null;
		} finally{
			manager.close();
		}
	}
	
	public boolean insert(Veiculo veiculo){
		
		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			manager.persist(veiculo);
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
	
	public boolean update(Veiculo veiculo){

		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			manager.merge(veiculo);
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
	
	public boolean delete(String chassi){
		
		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			Veiculo veiculo = manager.find(Veiculo.class, chassi);
			manager.remove(veiculo);
			manager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
			return false;
		} finally {
			manager.close();
		}
		
	}
	
	public Veiculo consultaPlaca(String placa){
		
		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			Query query = manager.createQuery("select v from Veiculo v where v.placa = :param");
			query.setParameter("param", placa);
			Veiculo veiculo = (Veiculo) query.getSingleResult(); 
			manager.getTransaction().commit();
			return veiculo;
		} catch (NoResultException noResultException) {
			manager.getTransaction().rollback();
			noResultException.printStackTrace();
			return null;
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao Buscar Veículo", "Erro Busca", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Veiculo> ListAll(){
		
		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			Query query = manager.createQuery("select v from Veiculo v");
			List<Veiculo> veiculos = query.getResultList(); 
			manager.getTransaction().commit();
			return veiculos;
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao Buscar Veículo", "Erro Busca", JOptionPane.ERROR_MESSAGE);
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
