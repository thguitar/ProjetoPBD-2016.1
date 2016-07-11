package br.com.Locadora.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import br.com.Locadora.model.Locacao;
import br.com.Locadora.model.TiposLocacao;

public class LocacaoController {
	EntityManagerFactory factory;
	EntityManager manager;

	public LocacaoController(){
		factory = HibernateSingleton.getInstance("HibMysql");
		manager = factory.createEntityManager();
	}

	public Locacao consultaId(int id){

		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			Locacao locacao = manager.find(Locacao.class, id);
			manager.getTransaction().commit();
			return locacao;
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao Buscar Locação", "Erro Busca", JOptionPane.ERROR_MESSAGE);
			manager.getTransaction().rollback();
			return null;
		} finally{
			manager.close();
		}
	}

	public Locacao consultaUpdate(int id){

		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			Locacao locacao = manager.find(Locacao.class, id);
			return locacao;
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao Buscar Locação", "Erro Busca", JOptionPane.ERROR_MESSAGE);
			manager.getTransaction().rollback();
			return null;
		} finally{
			manager.close();
		}
	}

	public boolean insert(Locacao locacao){

		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			manager.persist(locacao);
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

	public void update(Locacao locacao){

		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			manager.merge(locacao);
			manager.getTransaction().commit();
			JOptionPane.showMessageDialog(null, "Reserva Alterada com Sucesso", "Mensagem Reserva", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			manager.getTransaction().rollback();
			JOptionPane.showMessageDialog(null, "Erro ao Alterar Reserva", "Erro Autalização", JOptionPane.ERROR_MESSAGE);
		} finally {
			manager.close();
		}
	}

	public boolean delete(int id){

		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			Locacao locacao = manager.find(Locacao.class, id);
			manager.remove(locacao);
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

	@SuppressWarnings("unchecked")
	public List<Locacao> listALL(){
		manager.getTransaction().begin();
		Query query = manager.createQuery("select l from Locacao l where cancelada = 0");
		List<Locacao> locacoes = query.getResultList(); 
		manager.getTransaction().commit();
		return locacoes;
	}
	
	@SuppressWarnings("unchecked")
	public List<Locacao> consultaByCliente(String Nome){
		manager.getTransaction().begin();
		Query query = manager.createQuery("select l from Locacao l where cancelada = 0 and cliente.ID = (select c.ID from Cliente c where nome like :param)");
		query.setParameter("param", "%"+Nome+"%");
		List<Locacao> locacoes = query.getResultList(); 
		manager.getTransaction().commit();
		return locacoes;
	}
	
	@SuppressWarnings("unchecked")
	public List<TiposLocacao> listTipoLocacao(){
		manager.getTransaction().begin();
		Query query = manager.createQuery("select t from TiposLocacao t");
		List<TiposLocacao> tiposLocacaos = query.getResultList(); 
		manager.getTransaction().commit();
		return tiposLocacaos;
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
