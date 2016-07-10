package br.com.Locadora.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import br.com.Locadora.model.Reserva;

public class ReservaController {
	EntityManagerFactory factory;
	EntityManager manager;

	public ReservaController(){
		factory = HibernateSingleton.getInstance("HibMysql");
		manager = factory.createEntityManager();
	}

	public Reserva consultaId(int id){

		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			Reserva reserva = manager.find(Reserva.class, id);
			manager.getTransaction().commit();
			return reserva;
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao Buscar Empresa", "Erro Busca", JOptionPane.ERROR_MESSAGE);
			manager.getTransaction().rollback();
			return null;
		} finally{
			manager.close();
		}
	}

	public Reserva consultaUpdate(int id){

		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			Reserva reserva = manager.find(Reserva.class, id);
			return reserva;
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao Buscar Empresa", "Erro Busca", JOptionPane.ERROR_MESSAGE);
			manager.getTransaction().rollback();
			return null;
		} finally{
			manager.close();
		}
	}

	public boolean insert(Reserva reserva){

		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			manager.persist(reserva);
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

	public void update(Reserva reserva){

		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			manager.merge(reserva);
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
			Reserva reserva = manager.find(Reserva.class, id);
			manager.remove(reserva);
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
	public List<Reserva> consultaNome(String Descricao){
		manager.getTransaction().begin();
		Query query = manager.createQuery("select r from Reserva r where r.descricao like :param");
		query.setParameter("param", "%"+Descricao+"%");
		List<Reserva> reservas = query.getResultList(); 
		manager.getTransaction().commit();
		return reservas;
	}

	@SuppressWarnings("unchecked")
	public List<Reserva> listALL(){
		manager.getTransaction().begin();
		Query query = manager.createQuery("select r from Reserva r");
		List<Reserva> reservas = query.getResultList(); 
		manager.getTransaction().commit();
		return reservas;
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
