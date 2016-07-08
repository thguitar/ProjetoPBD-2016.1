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
	private int ID;
	@Column(name = "NOME", length = 100, nullable = false)
	private String nome;
	@Column(name = "RUA", length = 50, nullable = false)
	private String rua;
	@Column(name = "BAIRRO", length = 50, nullable = false)
	private String bairro;
	@Column(name = "NUMERO", length = 14)
	private String numero;
	@Column(name = "CIDADE", length = 50, nullable = false)
	private String cidade;
	@Column(name = "ESTADO", length = 20, nullable = false)
	private String estado;
	@Column(name = "INATIVO")
	private boolean inativo;

	public Cliente(){
		
	}
	
	public Cliente(int ID, String nome, String rua, String bairro, String numero, 
			String cidade, String estado, boolean inativo) {
		this.ID = ID;
		this.numero = numero;
		this.nome = nome;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.inativo = inativo;
	}
	
	public Cliente(String nome, String rua, String bairro, String numero, 
			String cidade, String estado) {
		this.numero = numero;
		this.nome = nome;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.inativo = false;
	}
	
	public int getId() {
		return ID;
	}

	public void setId(int ID) {
		this.ID = ID;
	}

	public String getnumeroEndereco() {
		return numero;
	}

	public void setnumeroEndereco(String numeroEndereco) {
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

	public boolean isInativo() {
		return inativo;
	}

	public void setInativo(boolean inativo) {
		this.inativo = inativo;
	}
	

}
