package br.com.Locadora.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
abstract class Categoria {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private int kmParaRevisao;
	@Column
	private Date horasReservadasInicio;
	@Column
	private Date horasReservadasFim;
	@Column
	private Date dataReservada;
	
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

	public Date getDataReservada() {
		return dataReservada;
	}

	public void setDataReservada(Date dataReservada) {
		this.dataReservada = dataReservada;
	}
	
	
	
}
