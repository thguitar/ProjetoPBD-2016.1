package br.com.Locadora.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Reserva {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID;
	@OneToOne
	@JoinColumn(name="IDCLIENTE")
	private Cliente cliente;
	@OneToOne
	@JoinColumn(name="IDCATEGORIA")
	private Categoria categoria;
	@OneToOne
	@JoinColumn(name="IDEMPRESA")
	private Empresa empresa;
	@Column(name = "DESCRICAO", length = 50, nullable = false)
	private String descricao;
	@Column(name = "STATUS", length = 20, nullable = false)
	private String status;
	@Column(name = "DATA_MOVIMENTO", nullable = false)
	private Date data;
	
	public Reserva() {
	
	}

	public Reserva(String descricao, Cliente cliente, Categoria categoria,
			Empresa empresa, Date data) {
		this.descricao = descricao;
		this.cliente = cliente;
		this.categoria = categoria;
		this.empresa = empresa;
		this.status = "ABERTA";
		this.data = data;
		
	}

	public Reserva(int iD, String descricao, String status, Cliente cliente,
			Categoria categoria, Empresa empresa, Date data) {
		ID = iD;
		this.descricao = descricao;
		this.status = status;
		this.cliente = cliente;
		this.categoria = categoria;
		this.empresa = empresa;
		this.data  = data;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
