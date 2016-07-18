package br.com.Locadora.controller;

import java.sql.Connection;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.internal.SessionImpl;

public class ConnectionSingleton {

	private static Connection instance;

	public static synchronized Connection getConnection(){
		try {
			if (instance == null) {
				EntityManager entityManager = HibernateSingleton.getInstance(HibernateSingleton.HIBERNATE_MYSQL).createEntityManager();
				entityManager.getTransaction().begin();

				Session hibernateSession = (Session) entityManager.unwrap(Session.class);
				return instance = ((SessionImpl) hibernateSession).connection();
			}
			
			return instance;
		} catch (Exception e) {
			return null;
		}
	}
}
