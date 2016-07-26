package br.com.Locadora.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import br.com.Locadora.controller.Validations;

@Entity
@PrimaryKeyJoinColumn(name="IDCLIENTE")
public class PessoaJuridica extends Cliente{
	
	@Column(name = "CNPJ", length = 14, nullable = false, unique = true)
	private String cnpj;
	@Column(name = "INSC_ESTADUAL", length = 20, nullable = false, unique = true)
	private String inscricaoEstadual;

	public PessoaJuridica(){
		
	}
	
	public PessoaJuridica(String numeroEndereco, String nome, String rua,
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
		if(Validations.isValidCNPJ(cnpj)){
			this.cnpj = cnpj;
		}
		else
			throw new CPFCNPJInvalidException("O CNPJ é Inválido");
	}
	
	
}
