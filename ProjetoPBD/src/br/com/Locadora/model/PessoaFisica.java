package br.com.Locadora.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@PrimaryKeyJoinColumn(name="IDCLIENTE")
public class PessoaFisica extends Cliente{
	
	@Column(name = "CPF")
	private String cpf;	
	@Column(name = "NUM_HAB")
	private int numeroHabilitacao;
	@Column(name = "DT_VENC_HAB")
	@Temporal(TemporalType.DATE)
	private Date dataVencimentoHailitacao;
	@Column(name = "DT_NASCI")
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	@Column(name = "SEXO")
	private char sexo;
	
	public PessoaFisica(int numeroEndereco, String nome, String rua,
			String bairro, String cidade, String estado) {
		super(nome, rua, bairro, numeroEndereco, cidade, estado);
	}

	public PessoaFisica(int numeroEndereco, String nome, String rua,
			String bairro, String cidade, String estado, char sexo,
			int numeroHabilitacao, Date dataVencimentoHailitacao, Date dataNascimento, String cpf) {
		super(nome, rua, bairro, numeroEndereco, cidade, estado);
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
