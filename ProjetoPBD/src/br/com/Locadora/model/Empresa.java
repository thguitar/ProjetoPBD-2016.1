package br.com.Locadora.model;

import java.util.ArrayList;

public class Empresa {
	private int id;
	private boolean filial;
	private String nome, endRua, endBairro, endNumero, endCidade, endEstado;
	private ArrayList<Usuario> usuarios;
	private ArrayList<Reserva> reservas;
	public Empresa(int id, boolean filial, String nome, String endRua,
			String endBairro, String endNumero, String endCidade,
			String endEstado) {
		this.id = id;
		this.filial = filial;
		this.nome = nome;
		this.endRua = endRua;
		this.endBairro = endBairro;
		this.endNumero = endNumero;
		this.endCidade = endCidade;
		this.endEstado = endEstado;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	public ArrayList<Reserva> getReservas() {
		return reservas;
	}
	public void setReservas(ArrayList<Reserva> reservas) {
		this.reservas = reservas;
	}
	
}
