package br.com.Locadora.controller;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.Locadora.view.Warnings;



public class HibernateSingleton {
	private static EntityManagerFactory instance;

	public static final String HIBERNATE_MYSQL = "HibMysql";
	
	public HibernateSingleton(){

	}

	public static synchronized EntityManagerFactory getInstance(String unitName){
		try {
			if (instance == null) {
				return instance = Persistence.createEntityManagerFactory(unitName);
			}

			return instance;
		} catch (Exception e) {
			Warnings.showMessageDialog(Warnings.ERROR_CONNECT_DB, e.getMessage()+"\n"+e.getCause()+"\n"+e.getClass());
			e.printStackTrace();
			System.exit(0);
			return null;
		}

	}

	public static void closeFactory(){
		instance.close();
	}
	
}
