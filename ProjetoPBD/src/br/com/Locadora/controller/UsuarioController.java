package br.com.Locadora.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;


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
			return null;
		} finally{
			manager.close();
		}

	}

	public boolean insert(Usuario u){

		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			
			StoredProcedureQuery storedProcedure = manager.createStoredProcedureQuery("CADASTRAR_USUARIO");
			storedProcedure.registerStoredProcedureParameter("P_ADMIN", Boolean.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("P_EMAIL", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("P_LOGIN", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("P_NOME", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("P_SENHA", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("P_IDEMPRESA", Integer.class, ParameterMode.IN);
			
			storedProcedure.setParameter("P_ADMIN", u.isAdmin());
			storedProcedure.setParameter("P_EMAIL", u.getEmail());
			storedProcedure.setParameter("P_LOGIN", u.getLogin());
			storedProcedure.setParameter("P_NOME", u.getNome());
			storedProcedure.setParameter("P_SENHA", u.getSenha());
			storedProcedure.setParameter("P_IDEMPRESA", u.getEmpresa().getId());
			
			storedProcedure.execute();
			
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

	public boolean update(Usuario u, boolean upSenha){

		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			
			StoredProcedureQuery storedProcedure = manager.createStoredProcedureQuery("ALTERAR_USUARIO");
			storedProcedure.registerStoredProcedureParameter("P_ID", Integer.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("P_ADMIN", Boolean.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("P_EMAIL", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("P_LOGIN", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("P_NOME", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("P_SENHA", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("P_IDEMPRESA", Integer.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("P_UPSENHA", Integer.class, ParameterMode.IN);
			
			storedProcedure.setParameter("P_ID", u.getId());
			storedProcedure.setParameter("P_ADMIN", u.isAdmin());
			storedProcedure.setParameter("P_EMAIL", u.getEmail());
			storedProcedure.setParameter("P_LOGIN", u.getLogin());
			storedProcedure.setParameter("P_NOME", u.getNome());
			storedProcedure.setParameter("P_SENHA", u.getSenha());
			storedProcedure.setParameter("P_IDEMPRESA", u.getEmpresa().getId());
			if(upSenha)
				storedProcedure.setParameter("P_UPSENHA", 1);
			else 
				storedProcedure.setParameter("P_UPSENHA", 0);
			
			storedProcedure.execute();
			
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

	public boolean delete(int id){

		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			Usuario usuario = manager.find(Usuario.class, id);
			manager.remove(usuario);
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
	public List<Usuario> consultaNome(String Nome){

		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			Query query = manager.createQuery("select u from Usuario u where u.nome like :param");
			query.setParameter("param", "%"+Nome+"%");
			List<Usuario> usuarios = query.getResultList();
			manager.getTransaction().commit();
			return usuarios;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			manager.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> consultaLogin(String Login){

		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			Query query = manager.createQuery("select u from Usuario u where u.login like :param");
			query.setParameter("param", "%"+Login+"%");
			List<Usuario> usuarios = query.getResultList();
			manager.getTransaction().commit();
			return usuarios;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			manager.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> listarTodos(){

		try {
			manager = factory.createEntityManager();
			manager.getTransaction().begin();
			Query consulta = manager.createQuery("select usuario from Usuario usuario");
			List<Usuario> usuarios = consulta.getResultList();
			manager.getTransaction().commit();
			return usuarios;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			manager.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Empresa> consultaEmpresas(){
		manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Query query = manager.createQuery("select u from Empresa u");
		List<Empresa>empresas = query.getResultList(); 
		manager.getTransaction().commit();
		return empresas;
	}
	
	public Empresa consultaEmpresa(int id){
		manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Empresa empresa = manager.find(Empresa.class, id);
		manager.getTransaction().commit();
		return empresa;
	}
}
