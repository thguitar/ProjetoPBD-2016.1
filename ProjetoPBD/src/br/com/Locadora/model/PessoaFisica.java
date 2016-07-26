package br.com.Locadora.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.Locadora.controller.Validations;

@Entity
@PrimaryKeyJoinColumn(name="IDCLIENTE")
public class PessoaFisica extends Cliente{
	
	@Column(name = "CPF", length = 11, nullable = false, unique = true)
	private String cpf;	
	@Column(name = "NUM_HAB", length = 11, nullable = false, unique = true)
	private String numeroHabilitacao;
	@Column(name = "DT_VENC_HAB", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataVencimentoHailitacao;
	@Column(name = "DT_NASCI", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	@Column(name = "SEXO", nullable = false)
	private char sexo;
	
	
	public PessoaFisica() {

	}
	
	public PessoaFisica(String numeroEndereco, String nome, String rua,
			String bairro, String cidade, String estado) {
		super(nome, rua, bairro, numeroEndereco, cidade, estado);
	}

	public PessoaFisica(String numeroEndereco, String nome, String rua,
			String bairro, String cidade, String estado, char sexo,
			String numeroHabilitacao, Date dataVencimentoHailitacao, Date dataNascimento, String cpf) {
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
	
	public String getSexoCompleto() {
		if (sexo == 'M') {
			return "MASCULINO";
		} 
		return "FEMININO";
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getNumeroHabilitacao() {
		return numeroHabilitacao;
	}

	public void setNumeroHabilitacao(String numeroHabilitacao) {
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
		if (Validations.isValidCPF(cpf)) {
			this.cpf = cpf;
		}else {
			throw new CPFCNPJInvalidException("O CPF é Inválido");
		}
		
	}
	
}
