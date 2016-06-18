package br.com.Locadora.model;

import javax.persistence.Column;
import javax.persistence.Entity;
@Entity
public class PequenoPorte extends Categoria{
	@Column
	private Acessorios acessorios;

	public PequenoPorte(int kmParaRevisao, Acessorios acessorios) {
		super(kmParaRevisao);
		this.acessorios = acessorios;
	}

	public Acessorios getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(Acessorios acessorios) {
		this.acessorios = acessorios;
	}
	
}
