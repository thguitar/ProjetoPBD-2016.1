package br.com.Locadora.model;



import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
abstract class Categoria {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name = "HRS_RESERVADAS_INICIO")
	@Temporal(TemporalType.TIME)
	private Date horasReservadasInicio;
	@Column(name = "HRS_RESERVADAS_FIM")
	@Temporal(TemporalType.TIME)
	private Date horasReservadasFim;
	@Column(name = "DT_RESERVA")
	@Temporal(TemporalType.DATE)
	private Calendar dataReservada;
	@Column(name = "KM_P_REVISAO")
	private int kmParaRevisao;

	public Categoria(int kmParaRevisao) {
		this.kmParaRevisao = kmParaRevisao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getKmParaRevisao() {
		return kmParaRevisao;
	}

	public void setKmParaRevisao(int kmParaRevisao) {
		this.kmParaRevisao = kmParaRevisao;
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
	
}
