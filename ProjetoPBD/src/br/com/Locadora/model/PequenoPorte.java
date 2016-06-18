package br.com.Locadora.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
public class PequenoPorte extends Categoria{
//	@Column
//	private Acessorios acessorios;

	public PequenoPorte(int kmParaRevisao) {
		super(kmParaRevisao);
		
	}

//	public Acessorios getAcessorios() {
//		return acessorios;
//	}
//
//	public void setAcessorios(Acessorios acessorios) {
//		this.acessorios = acessorios;
//	}
	
}
