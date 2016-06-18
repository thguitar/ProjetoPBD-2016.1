package br.com.Locadora.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
@Entity
public class PessoaFisica extends Cliente{
	@Column
	private char sexo;
	@Column
	private int numeroHabilitacao;
	@Column
	private Date dataVencimentoHailitacao;
	@Column
	private Date dataNascimento;
	@Column
	private String cpf;

	public PessoaFisica(int numeroEndereco, String nome, String rua,
			String bairro, String cidade, String estado) {
		super(numeroEndereco, nome, rua, bairro, cidade, estado);
	}

	public PessoaFisica(int numeroEndereco, String nome, String rua,
			String bairro, String cidade, String estado, char sexo,
			int numeroHabilitacao, Date dataVencimentoHailitacao, Date dataNascimento, String cpf) {
		super(numeroEndereco, nome, rua, bairro, cidade, estado);
		this.sexo = sexo;
		this.numeroHabilitacao = numeroHabilitacao;
		this.dataVencimentoHailitacao = dataVencimentoHailitacao;
		this.dataNascimento = dataNascimento;
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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
}
