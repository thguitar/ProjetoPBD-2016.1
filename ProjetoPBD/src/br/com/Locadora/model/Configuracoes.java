package br.com.Locadora.model;

import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
//@Table(name = "CONFIGURACOES")
public class Configuracoes {

	private String pathPlanodeFundo; 


	public Configuracoes(){

	}

	public Configuracoes(String pathPlanodeFundo){
		this.pathPlanodeFundo = pathPlanodeFundo;
	}

	public String getPathPlanodeFundo() {
		return pathPlanodeFundo;
	}

	public void setPathPlanodeFundo(String pathPlanodeFundo) {
		this.pathPlanodeFundo = pathPlanodeFundo;
	}
	
}
