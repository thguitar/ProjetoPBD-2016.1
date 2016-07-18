package br.com.Locadora.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Configuracoes {
	
	@Id
	private int ID;
	@Column(name = "NOME", length = 50, nullable = false)
	private String pathPlanodeFundo; 

	public Configuracoes(){

	}

	public Configuracoes(String pathPlanodeFundo) {
		super();
		this.pathPlanodeFundo = pathPlanodeFundo;
	}

	public Configuracoes(int iD, String pathPlanodeFundo) {
		super();
		ID = iD;
		this.pathPlanodeFundo = pathPlanodeFundo;
	}

	public String getPathPlanodeFundo() {
		return pathPlanodeFundo;
	}

	public void setPathPlanodeFundo(String pathPlanodeFundo) {
		this.pathPlanodeFundo = pathPlanodeFundo;
	}

	public int getID() {
		return ID;
	}

}
