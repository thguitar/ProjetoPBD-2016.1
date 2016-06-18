package br.com.Locadora.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Devolucao {
	@Id
	@GeneratedValue
	private int id;
	@Column
	private boolean tanqueCheio;
	@Column
	private boolean carroLavado;
	@Column
	private Date horarioDevolucao;
	@Column
	private Double multa;
	@Column
	private String descricao;
	public Devolucao(boolean tanqueCheio, boolean carroLavado,
			Date horarioDevolucao) {
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
