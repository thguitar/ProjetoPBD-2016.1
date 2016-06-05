package br.com.Locadora.model;

import java.sql.Date;

public class PessoaFisica extends Cliente{
	
	private char sexo;
	private int numeroHabilitacao;
	private Date dataVencimentoHailitacao;
	private String cpf;

	public PessoaFisica(int id, int numeroEndereco, String nome, String rua,
			String bairro, String cidade, String estado, char sexo,
			int numeroHabilitacao, Date dataVencimentoHailitacao, String cpf) {
		super(id, numeroEndereco, nome, rua, bairro, cidade, estado);
		this.sexo = sexo;
		this.numeroHabilitacao = numeroHabilitacao;
		this.dataVencimentoHailitacao = dataVencimentoHailitacao;
		this.cpf = cpf;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public int getNumeroHabilitacao() {
		return numeroHabilitacao;
	}

	public void setNumeroHabilitacao(int numeroHabilitacao) {
		this.numeroHabilitacao = numeroHabilitacao;
	}

	public Date getDataVencimentoHailitacao() {
		return dataVencimentoHailitacao;
	}

	public void setDataVencimentoHailitacao(Date dataVencimentoHailitacao) {
		this.dataVencimentoHailitacao = dataVencimentoHailitacao;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
}
