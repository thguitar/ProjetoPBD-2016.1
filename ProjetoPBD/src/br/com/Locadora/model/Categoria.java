package br.com.Locadora.model;



import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Categoria {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID;
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

	public Categoria(){
		
	}
	
	public Categoria(int kmParaRevisao) {
		this.kmParaRevisao = kmParaRevisao;
	}

	public int getId() {
		return ID;
	}

	public void setId(int id) {
		this.ID = id;
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
