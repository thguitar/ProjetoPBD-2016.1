package br.com.Locadora.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "CLIENTE")
public abstract class Cliente {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name = "NOME")
	private String nome;
	@Column(name = "RUA")
	private String rua;
	@Column(name = "BAIRRO")
	private String bairro;
	@Column(name = "NUMERO")
	private int numero;
	@Column(name = "CIDADE")
	private String cidade;
	@Column(name = "ESTADO")
	private String estado;

	public Cliente(int id, String nome, String rua, String bairro, int numero, 
			String cidade, String estado) {
		this.id = id;
		this.numero = numero;
		this.nome = nome;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}
	
	public Cliente(String nome, String rua, String bairro, int numero, 
			String cidade, String estado) {
		this.numero = numero;
		this.nome = nome;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getnumeroEndereco() {
		return numero;
	}

	public void setnumeroEndereco(int numeroEndereco) {
		this.numero = numeroEndereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
