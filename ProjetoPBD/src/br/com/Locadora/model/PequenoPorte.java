package br.com.Locadora.model;

public class PequenoPorte extends Categoria{
	private Acessorios acessorios;

	public PequenoPorte(int id, int kmParaRevisao, Acessorios acessorios) {
		super(id, kmParaRevisao);
		this.acessorios = acessorios;
	}

	public Acessorios getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(Acessorios acessorios) {
		this.acessorios = acessorios;
	}
	
}
