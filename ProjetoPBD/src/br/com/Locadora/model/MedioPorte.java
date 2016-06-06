package br.com.Locadora.model;

public class MedioPorte extends Categoria{
	private Acessorios acessorios;
	private String airBag;
	private boolean direcaoAssistida, cintosTraseirosRetrateis, rodasDeLigaLeve, controleDePoluicao;
	public MedioPorte(int id, int kmParaRevisao, Acessorios acessorios,
			String airBag, boolean direcaoAssistida,
			boolean cintosTraseirosRetrateis, boolean rodasDeLigaLeve,
			boolean controleDePoluicao) {
		super(id, kmParaRevisao);
		this.acessorios = acessorios;
		this.airBag = airBag;
		this.direcaoAssistida = direcaoAssistida;
		this.cintosTraseirosRetrateis = cintosTraseirosRetrateis;
		this.rodasDeLigaLeve = rodasDeLigaLeve;
		this.controleDePoluicao = controleDePoluicao;
	}
	public Acessorios getAcessorios() {
		return acessorios;
	}
	public void setAcessorios(Acessorios acessorios) {
		this.acessorios = acessorios;
	}
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
