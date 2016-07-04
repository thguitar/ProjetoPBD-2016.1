package br.com.Locadora.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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
	
	public Veiculo consultaId(int id){
		
		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			Veiculo veiculo = manager.find(Veiculo.class, id);
			manager.getTransaction().commit();
			return veiculo;
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao Buscar Ve�culo", "Erro Busca", JOptionPane.ERROR_MESSAGE);
			manager.getTransaction().rollback();
			return null;
		} finally{
			manager.close();
		}
	}
	
	public void insert(Veiculo veiculo){
		
		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			manager.persist(veiculo);
			manager.getTransaction().commit();
			JOptionPane.showMessageDialog(null, "Ve�culo Cadastrado com Sucesso", "Mensagem Cadastro", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			manager.getTransaction().rollback();
			JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Ve�culo", "Erro Inser��o", JOptionPane.ERROR_MESSAGE);
		} finally{
			manager.close();
		}
	}
	
	public void update(Veiculo veiculo){

		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			manager.merge(veiculo);
			manager.getTransaction().commit();
			JOptionPane.showMessageDialog(null, "Ve�culo Alterado com Sucesso", "Mensagem Cadastro", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			manager.getTransaction().rollback();
			JOptionPane.showMessageDialog(null, "Erro ao Alterar Ve�culo", "Erro Autaliza��o", JOptionPane.ERROR_MESSAGE);
		} finally {
			manager.close();
		}
	}
	
	public void delete(int id){
		
		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			Veiculo veiculo = manager.find(Veiculo.class, id);
			manager.remove(veiculo);
			manager.getTransaction().commit();
			JOptionPane.showMessageDialog(null, "Ve�culo Exclu�do com Sucesso", "Mensagem Cadastro", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao Deletar Ve�culo", "Erro Remo��o", JOptionPane.ERROR_MESSAGE);
		} finally {
			manager.close();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Veiculo> consultaPlaca(String placa){
		
		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			Query query = manager.createQuery("select v from Veiculo v where v.PLACA = :param");
			query.setParameter("param", "placa");
			List<Veiculo> veiculos = query.getResultList(); 
			manager.getTransaction().commit();
			return veiculos;
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao Buscar Ve�culo", "Erro Busca", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		
	}
	
}
