package br.com.Locadora.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class TiposLocacao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID;
	@Column(name = "TIPO", length = 20, nullable = false)
	private String tipo;
	@Column(name = "VALOR", nullable = false)
	private double valor;
	
	public TiposLocacao() {
	
	}
	
	public TiposLocacao(String tipo, double valor) {
		super();
		this.tipo = tipo;
		this.valor = valor;
	}

	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
}
