package br.com.Locadora.model;



import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Categoria {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID;
	@Column(name = "DESCRICAO", nullable = false)
	private String descricao;
	@Column(name = "HRS_RESERVADAS_INICIO", nullable = false)
	@Temporal(TemporalType.TIME)
	private Date horasReservadasInicio;
	@Column(name = "HRS_RESERVADAS_FIM", nullable = false)
	@Temporal(TemporalType.TIME)
	private Date horasReservadasFim;
	@Column(name = "DT_RESERVA", nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar dataReservada;
	@Column(name = "KM_PARA_REVISAO", nullable = false)
	private int kmParaRevisao;

	public Categoria(){
		
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getHorasReservadasInicio() {
		return horasReservadasInicio;
	}

	public void setHorasReservadasInicio(Date horasReservadasInicio) {
		this.horasReservadasInicio = horasReservadasInicio;
	}

	public Date getHorasReservadasFim() {
		return horasReservadasFim;
	}

	public void setHorasReservadasFim(Date horasReservadasFim) {
		this.horasReservadasFim = horasReservadasFim;
	}

	public Calendar getDataReservada() {
		return dataReservada;
	}

	public void setDataReservada(Calendar dataReservada) {
		this.dataReservada = dataReservada;
	}

	public int getKmParaRevisao() {
		return kmParaRevisao;
	}

	public void setKmParaRevisao(int kmParaRevisao) {
		this.kmParaRevisao = kmParaRevisao;
	}
	

}
