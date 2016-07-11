package br.com.Locadora.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Empresa {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID;
	@Column(name = "NOME", length = 50, nullable = false)
	private String nome;
	@Column(name = "FILIAL")
	private boolean filial;
	@Column(name = "RUA", length = 50, nullable = false)
	private String endRua;
	@Column(name = "BAIRRO", length = 50, nullable = false)
	private String endBairro;
	@Column(name = "NUMERO", length = 14)
	private String endNumero;
	@Column(name = "CIDADE", length = 50, nullable = false)
	private String endCidade;
	@Column(name = "ESTADO", length = 50, nullable = false)
	private String endEstado;

	public Empresa(){

	}

	public Empresa(boolean filial, String nome, String endRua,
			String endBairro, String endNumero, String endCidade,
			String endEstado) {
		this.filial = filial;
		this.nome = nome;
		this.endRua = endRua;
		this.endBairro = endBairro;
		this.endNumero = endNumero;
		this.endCidade = endCidade;
		this.endEstado = endEstado;
	}

	public Empresa(int ID){
		this.ID = ID;
	}

	public int getId() {
		return ID;
	}
	public void setId(int id) {
		this.ID = id;
	}
	public boolean isFilial() {
		return filial;
	}
	public void setFilial(boolean filial) {
		this.filial = filial;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndRua() {
		return endRua;
	}
	public void setEndRua(String endRua) {
		this.endRua = endRua;
	}
	public String getEndBairro() {
		return endBairro;
	}
	public void setEndBairro(String endBairro) {
		this.endBairro = endBairro;
	}
	public String getEndNumero() {
		return endNumero;
	}
	public void setEndNumero(String endNumero) {
		this.endNumero = endNumero;
	}
	public String getEndCidade() {
		return endCidade;
	}
	public void setEndCidade(String endCidade) {
		this.endCidade = endCidade;
	}
	public String getEndEstado() {
		return endEstado;
	}
	public void setEndEstado(String endEstado) {
		this.endEstado = endEstado;
	}

}
