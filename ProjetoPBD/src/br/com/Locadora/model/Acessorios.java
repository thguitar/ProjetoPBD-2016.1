package br.com.Locadora.model;

public class Acessorios {
	private int id;
	private String TipoDeCambio;
	private boolean dvd, radio, arCondicionado, direcaoHidraulica, mp3, cameraDeRe;
	public Acessorios(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipoDeCambio() {
		return TipoDeCambio;
	}
	public void setTipoDeCambio(String tipoDeCambio) {
		TipoDeCambio = tipoDeCambio;
	}
	public boolean isDvd() {
		return dvd;
	}
	public void setDvd(boolean dvd) {
		this.dvd = dvd;
	}
	public boolean isRadio() {
		return radio;
	}
	public void setRadio(boolean radio) {
		this.radio = radio;
	}
	public boolean isArCondicionado() {
		return arCondicionado;
	}
	public void setArCondicionado(boolean arCondicionado) {
		this.arCondicionado = arCondicionado;
	}
	public boolean isDirecaoHidraulica() {
		return direcaoHidraulica;
	}
	public void setDirecaoHidraulica(boolean direcaoHidraulica) {
		this.direcaoHidraulica = direcaoHidraulica;
	}
	public boolean isMp3() {
		return mp3;
	}
	public void setMp3(boolean mp3) {
		this.mp3 = mp3;
	}
	public boolean isCameraDeRe() {
		return cameraDeRe;
	}
	public void setCameraDeRe(boolean cameraDeRe) {
		this.cameraDeRe = cameraDeRe;
	}
	
	
}
