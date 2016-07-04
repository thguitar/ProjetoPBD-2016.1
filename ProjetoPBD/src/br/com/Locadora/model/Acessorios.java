package br.com.Locadora.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Acessorios {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID;
	@Column(name = "AR_CONDICIONADO")
	private boolean arCondicionado;
	@Column(name = "RADIO")
	private boolean radio;
	@Column(name = "DVD")
	private boolean dvd;
	@Column(name = "DIRECAO_HIDRAULICA")
	private boolean direcaoHidraulica;
	@Column(name = "MP3")
	private boolean mp3;
	@Column(name = "CAMERA_RE")
	private boolean cameraDeRe;
	@Column(name = "TIPO_CAMBIO")
	private String TipoDeCambio;

	public Acessorios() {
		
	}
	
	public Acessorios(boolean arCondicionado, boolean radio, boolean dvd,
			boolean direcaoHidraulica, boolean mp3, boolean cameraDeRe,
			String tipoDeCambio) {
		super();
		this.arCondicionado = arCondicionado;
		this.radio = radio;
		this.dvd = dvd;
		this.direcaoHidraulica = direcaoHidraulica;
		this.mp3 = mp3;
		this.cameraDeRe = cameraDeRe;
		TipoDeCambio = tipoDeCambio;
	}

	public int getId() {
		return ID;
	}
	public void setId(int id) {
		this.ID = id;
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
