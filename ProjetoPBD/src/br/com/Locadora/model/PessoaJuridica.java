package br.com.Locadora.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pessoaJuridica")
public class PessoaJuridica extends Cliente{
	@Column
	private String inscricaoEstadual;
	@Column
	private String cnpj;

	public PessoaJuridica(int numeroEndereco, String nome, String rua,
			String bairro, String cidade, String estado,
			String inscricaoEstadual, String cnpj) {
		super(numeroEndereco, nome, rua, bairro, cidade, estado);
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
