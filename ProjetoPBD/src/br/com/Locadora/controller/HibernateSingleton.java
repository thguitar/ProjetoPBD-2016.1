package br.com.Locadora.controller;

import java.sql.Connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.internal.SessionImpl;


public class HibernateSingleton {
	private static EntityManagerFactory instance;

	public HibernateSingleton(){

	}

	public static synchronized EntityManagerFactory getInstance(String unitName){
		try {
			if (instance == null) {
				return instance = Persistence.createEntityManagerFactory(unitName);
			}

			return instance;
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao Connectar o Banco de Dados.\n        O Sistema será Finalizado\n","Erro de Conexão",JOptionPane.ERROR_MESSAGE);
			System.exit(0);
			return null;
		}

	}

	public static void closeFactory(){
		instance.close();
	}
	
	public static Connection Connection(){
		EntityManager entityManager = getInstance("HibMysql").createEntityManager();
		entityManager.getTransaction().begin();
		
		Session hibernateSession = (Session) entityManager.unwrap(Session.class);
		Connection jdbcConnection = ((SessionImpl) hibernateSession).connection();
		return jdbcConnection;
		
	}
}
