package br.com.Locadora.model;

import java.sql.Date;

public class Devolucao {
	private int id;
	private boolean tanqueCheio, carroLavado;
	private Date horarioDevolucao;
	private Double multa;
	private String descricao;
	public Devolucao(int id, boolean tanqueCheio, boolean carroLavado,
			Date horarioDevolucao) {
		this.id = id;
		this.tanqueCheio = tanqueCheio;
		this.carroLavado = carroLavado;
		this.horarioDevolucao = horarioDevolucao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isTanqueCheio() {
		return tanqueCheio;
	}
	public void setTanqueCheio(boolean tanqueCheio) {
		this.tanqueCheio = tanqueCheio;
	}
	public boolean isCarroLavado() {
		return carroLavado;
	}
	public void setCarroLavado(boolean carroLavado) {
		this.carroLavado = carroLavado;
	}
	public Date getHorarioDevolucao() {
		return horarioDevolucao;
	}
	public void setHorarioDevolucao(Date horarioDevolucao) {
		this.horarioDevolucao = horarioDevolucao;
	}
	public Double getMulta() {
		return multa;
	}
	public void setMulta(Double multa) {
		this.multa = multa;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	

}
