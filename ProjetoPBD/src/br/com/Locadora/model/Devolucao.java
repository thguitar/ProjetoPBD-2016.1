package br.com.Locadora.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Devolucao {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID;
	@Column(name = "TANQUE_CHEIO")
	private boolean tanqueCheio;
	@Column(name = "CARRO_LAVADO")
	private boolean carroLavado;
	@Column(name = "DATA_DEVOLUCAO", nullable = false)
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date horarioDevolucao;
	@Column(name = "VALOR_MULTA")
	private Double multa;
	@Column(name = "OBSERVACAO", length = 50)
	private String observacao;
	
	public Devolucao() {

	}

	public Devolucao(boolean tanqueCheio, boolean carroLavado,
			Date horarioDevolucao, Double multa, String observacao) {
		super();
		this.tanqueCheio = tanqueCheio;
		this.carroLavado = carroLavado;
		this.horarioDevolucao = horarioDevolucao;
		this.multa = multa;
		this.observacao = observacao;
	}
	
	public Devolucao(int iD, boolean tanqueCheio, boolean carroLavado,
			Date horarioDevolucao, Double multa, String observacao) {
		super();
		ID = iD;
		this.tanqueCheio = tanqueCheio;
		this.carroLavado = carroLavado;
		this.horarioDevolucao = horarioDevolucao;
		this.multa = multa;
		this.observacao = observacao;
	}

	public int getId() {
		return ID;
	}
	public void setId(int id) {
		this.ID = id;
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
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

}
