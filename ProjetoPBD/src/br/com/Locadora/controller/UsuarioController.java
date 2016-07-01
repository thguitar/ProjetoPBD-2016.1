package br.com.Locadora.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import br.com.Locadora.model.Empresa;
import br.com.Locadora.model.Usuario;

public class UsuarioController {
	EntityManagerFactory factory;
	EntityManager manager;

	public UsuarioController(){
		factory = HibernateSingleton.getInstance("HibMysql");
		manager = factory.createEntityManager();
	}

	public Usuario consultaId(int id){

		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			Usuario usuario = manager.find(Usuario.class, id);
			manager.getTransaction().commit();
			return usuario;
		} catch (Exception e) {
			e.printStackTrace();
			manager.getTransaction().rollback();
			JOptionPane.showMessageDialog(null, "Erro ao Consultar Usuário", null, JOptionPane.ERROR_MESSAGE);
			return null;
		} finally{
			manager.close();
		}

	}

	public void insert(Usuario u){

		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			manager.persist(u);
			manager.getTransaction().commit();
			JOptionPane.showMessageDialog(null, "Usuário Cadastrado com Sucesso", null, JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			manager.getTransaction().rollback();
			JOptionPane.showMessageDialog(null, "Erro ao Inserir Usuário", null, JOptionPane.ERROR_MESSAGE);
		} finally {
			manager.close();
		}

	}

	public void update(Usuario u){

		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			manager.merge(u);
			manager.getTransaction().commit();
			JOptionPane.showMessageDialog(null, "Usuário Alterado com Sucesso", null, JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			manager.getTransaction().rollback();
			JOptionPane.showMessageDialog(null, "Erro ao Alterar Usuário", null, JOptionPane.ERROR_MESSAGE);
		} finally {
			manager.close();
		}
	}

	public void delete(Usuario u){

		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			Usuario usuario = manager.find(Usuario.class, u.getId());
			manager.remove(usuario);
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

	@SuppressWarnings("unchecked")
	public List<Usuario> consultaNome(String Nome){

		try {
			manager.getTransaction().begin();
			Query query = manager.createQuery("select u from Usuario u where u.nome like :param");
			query.setParameter("param", "%"+Nome+"%");
			List<Usuario> usuarios = query.getResultList();
			manager.getTransaction().commit();
			return usuarios;
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao Consultar Usuários", null, JOptionPane.ERROR_MESSAGE);
			return null;
		} finally {
			manager.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> listarTodos(){

		try {
			manager.getTransaction().begin();
			Query consulta = manager.createQuery("select usuario from Usuario usuario");
			List<Usuario> usuarios = consulta.getResultList();
			manager.getTransaction().commit();
			return usuarios;
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao Consultar Usuários", null, JOptionPane.ERROR_MESSAGE);
			return null;
		} finally {
			manager.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Empresa> consultaEmpresas(){
		manager.getTransaction().begin();
		Query query = manager.createQuery("select u from Empresa u");
		List<Empresa>empresas = query.getResultList(); 
		manager.getTransaction().commit();
		return empresas;
	}
}
