package br.com.Locadora.model;

import java.sql.Date;

abstract class Categoria {
	private int id, kmParaRevisao;
	private Date horasReservadasInicio, horasReservadasFim, dataReservada;
	
	public Categoria(int id, int kmParaRevisao) {
		this.id = id;
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
