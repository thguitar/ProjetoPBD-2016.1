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

	public PequenoPorte(boolean arCondicionado, boolean radio, boolean dvd,
			boolean direcaoHidraulica, boolean mp3, boolean cameraDeRe,
			String tipoDeCambio){
		
		acessorios = new Acessorios(arCondicionado, radio, dvd, direcaoHidraulica, mp3, cameraDeRe, tipoDeCambio);
		
	}
	
	public PequenoPorte() {

	}
	
	
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
