package br.com.Locadora.controller;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;



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
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao Connectar o Banco de Dados.\n        O Sistema será Finalizado\n","Erro de Conexão",JOptionPane.ERROR_MESSAGE);
			System.exit(0);
			return null;
		}

	}

	public static void closeFactory(){
		instance.close();
	}
	
}
