package br.com.Locadora.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class MedioPorte extends Categoria{
//	@Column
//	private Acessorios acessorios;
	@Column
	private String airBag;
	@Column
	private boolean direcaoAssistida;
	@Column
	private boolean cintosTraseirosRetrateis;
	@Column
	private boolean rodasDeLigaLeve;
	@Column
	private boolean controleDePoluicao;
	
	public MedioPorte(int kmParaRevisao,
			String airBag, boolean direcaoAssistida,
			boolean cintosTraseirosRetrateis, boolean rodasDeLigaLeve,
			boolean controleDePoluicao) {
		super(kmParaRevisao);
//		this.acessorios = acessorios;
		this.airBag = airBag;
		this.direcaoAssistida = direcaoAssistida;
		this.cintosTraseirosRetrateis = cintosTraseirosRetrateis;
		this.rodasDeLigaLeve = rodasDeLigaLeve;
		this.controleDePoluicao = controleDePoluicao;
	}
//	public Acessorios getAcessorios() {
//		return acessorios;
//	}
//	public void setAcessorios(Acessorios acessorios) {
//		this.acessorios = acessorios;
//	}
	public String getAirBag() {
		return airBag;
	}
	public void setAirBag(String airBag) {
		this.airBag = airBag;
	}
	public boolean isDirecaoAssistida() {
		return direcaoAssistida;
	}
	public void setDirecaoAssistida(boolean direcaoAssistida) {
		this.direcaoAssistida = direcaoAssistida;
	}
	public boolean isCintosTraseirosRetrateis() {
		return cintosTraseirosRetrateis;
	}
	public void setCintosTraseirosRetrateis(boolean cintosTraseirosRetrateis) {
		this.cintosTraseirosRetrateis = cintosTraseirosRetrateis;
	}
	public boolean isRodasDeLigaLeve() {
		return rodasDeLigaLeve;
	}
	public void setRodasDeLigaLeve(boolean rodasDeLigaLeve) {
		this.rodasDeLigaLeve = rodasDeLigaLeve;
	}
	public boolean isControleDePoluicao() {
		return controleDePoluicao;
	}
	public void setControleDePoluicao(boolean controleDePoluicao) {
		this.controleDePoluicao = controleDePoluicao;
	}
	
	
}
