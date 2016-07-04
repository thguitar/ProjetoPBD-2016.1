package br.com.Locadora.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="IDCATEGORIA")
public class PequenoPorte extends Categoria{
	@OneToOne
	@JoinColumn(name = "acessorios_ID")
	private Acessorios acessorios;

	public PequenoPorte(int kmParaRevisao) {
		super(kmParaRevisao);

	}

	public Acessorios getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(Acessorios acessorios) {
		this.acessorios = acessorios;
	}

}
