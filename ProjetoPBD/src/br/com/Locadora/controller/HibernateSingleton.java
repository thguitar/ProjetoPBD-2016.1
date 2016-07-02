package br.com.Locadora.controller;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateSingleton {
	private static EntityManagerFactory instance;
	
	public HibernateSingleton(){
		
	}
	
	public static synchronized EntityManagerFactory getInstance(String unitName){
		if (instance == null) {
			return instance = Persistence.createEntityManagerFactory(unitName);
		}
		
		return instance;
	}
	
	public static void closeFactory(){
		instance.close();
	}
}
