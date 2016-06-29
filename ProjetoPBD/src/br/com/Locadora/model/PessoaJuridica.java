package br.com.Locadora.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="ID_CLIENTE")
public class PessoaJuridica extends Cliente{
	
	@Column(name = "CNPJ")
	private String cnpj;
	@Column(name = "INSC_ESTADUAL")
	private String inscricaoEstadual;

	public PessoaJuridica(){
		
	}
	
	public PessoaJuridica(int numeroEndereco, String nome, String rua,
			String bairro, String cidade, String estado,
			String inscricaoEstadual, String cnpj) {
		super(nome, rua, bairro, numeroEndereco, cidade, estado);
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
