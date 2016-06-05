package br.com.Locadora.model;

public class PessoaJuridica extends Cliente{
	
	private String inscricaoEstadual, cnpj;

	public PessoaJuridica(int id, int numeroEndereco, String nome, String rua,
			String bairro, String cidade, String estado,
			String inscricaoEstadual, String cnpj) {
		super(id, numeroEndereco, nome, rua, bairro, cidade, estado);
		this.inscricaoEstadual = inscricaoEstadual;
		this.cnpj = cnpj;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	
}
