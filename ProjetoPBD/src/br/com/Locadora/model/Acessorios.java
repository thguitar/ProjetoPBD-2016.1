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
	@Column(name = "ARCONDICIONADO")
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
	@Column(name = "AIRBAG")
	private boolean airBag;
	@Column(name = "DIRECAO_ASSISTIDA")
	private boolean direcaoAssistida;
	@Column(name = "CINTOS_TRASEIROS_RETRATEIS")
	private boolean cintosTraseirosRetrateis;
	@Column(name = "RODA_LIGA_LEVE")
	private boolean rodasDeLigaLeve;
	@Column(name = "CONTROLE_POLUICAO")
	private boolean controleDePoluicao;
	@Column(name = "CAPACIDADE_DE_CARGA")
	private double capacidadeDeCarga;
	@Column(name = "DISTANCIA_ENTRE_EIXOS")
	private double distanciaEntreEixos;
	@Column(name = "ACIONAMENTO_EMBREAGEM")
	private boolean acionamentoEmbreagem;
	@Column(name = "DESEMPENHO_VEICULO")
	private double desempenhoDoVeiculo;
	@Column(name = "POTENCIA_MOTOR")
	private double potenciaMotor;
	@Column(name = "VOLUME_ABASTECIMENTO")
	private double volumeDeAbastecimento;


	public Acessorios() {

	}

	//Construtor para o Tipo Pequeno Porte
	public Acessorios(boolean arCondicionado, boolean radio, boolean dvd,
			boolean direcaoHidraulica, boolean mp3, boolean cameraDeRe,
			String tipoDeCambio) {
		this.arCondicionado = arCondicionado;
		this.radio = radio;
		this.dvd = dvd;
		this.direcaoHidraulica = direcaoHidraulica;
		this.mp3 = mp3;
		this.cameraDeRe = cameraDeRe;
		TipoDeCambio = tipoDeCambio;
	}

	//Construtor para o Tipo Medio Porte
	public Acessorios(boolean arCondicionado, boolean radio, boolean dvd,
			boolean direcaoHidraulica, boolean mp3, boolean cameraDeRe,
			String tipoDeCambio, boolean airBag, boolean direcaoAssistida,
			boolean cintosTraseirosRetrateis, boolean rodasDeLigaLeve,
			boolean controleDePoluicao) {
		this.arCondicionado = arCondicionado;
		this.radio = radio;
		this.dvd = dvd;
		this.direcaoHidraulica = direcaoHidraulica;
		this.mp3 = mp3;
		this.cameraDeRe = cameraDeRe;
		TipoDeCambio = tipoDeCambio;
		this.airBag = airBag;
		this.direcaoAssistida = direcaoAssistida;
		this.cintosTraseirosRetrateis = cintosTraseirosRetrateis;
		this.rodasDeLigaLeve = rodasDeLigaLeve;
		this.controleDePoluicao = controleDePoluicao;
	}

	//Construtor para o Tipo Grande Porte
	public Acessorios(boolean arCondicionado, boolean radio, boolean dvd,
			boolean direcaoHidraulica, boolean mp3, boolean cameraDeRe,
			String tipoDeCambio, boolean airBag, boolean direcaoAssistida,
			boolean cintosTraseirosRetrateis, boolean rodasDeLigaLeve,
			boolean controleDePoluicao, int capacidadeDeCarga,
			int distanciaEntreEixos, boolean acionamentoEmbreagem,
			int desempenhoDoVeiculo, Double potenciaMotor,
			int volumeDeAbastecimento) {
		this.arCondicionado = arCondicionado;
		this.radio = radio;
		this.dvd = dvd;
		this.direcaoHidraulica = direcaoHidraulica;
		this.mp3 = mp3;
		this.cameraDeRe = cameraDeRe;
		TipoDeCambio = tipoDeCambio;
		this.airBag = airBag;
		this.direcaoAssistida = direcaoAssistida;
		this.cintosTraseirosRetrateis = cintosTraseirosRetrateis;
		this.rodasDeLigaLeve = rodasDeLigaLeve;
		this.controleDePoluicao = controleDePoluicao;
		this.capacidadeDeCarga = capacidadeDeCarga;
		this.distanciaEntreEixos = distanciaEntreEixos;
		this.acionamentoEmbreagem = acionamentoEmbreagem;
		this.desempenhoDoVeiculo = desempenhoDoVeiculo;
		this.potenciaMotor = potenciaMotor;
		this.volumeDeAbastecimento = volumeDeAbastecimento;
	}

	//Construtor para o Tipo Pequeno Porte with ID
	public Acessorios(int ID, boolean arCondicionado, boolean radio, boolean dvd,
			boolean direcaoHidraulica, boolean mp3, boolean cameraDeRe,
			String tipoDeCambio) {
		this.arCondicionado = arCondicionado;
		this.radio = radio;
		this.dvd = dvd;
		this.direcaoHidraulica = direcaoHidraulica;
		this.mp3 = mp3;
		this.cameraDeRe = cameraDeRe;
		TipoDeCambio = tipoDeCambio;
	}

	//Construtor para o Tipo Medio Porte with ID
	public Acessorios(int ID, boolean arCondicionado, boolean radio, boolean dvd,
			boolean direcaoHidraulica, boolean mp3, boolean cameraDeRe,
			String tipoDeCambio, boolean airBag, boolean direcaoAssistida,
			boolean cintosTraseirosRetrateis, boolean rodasDeLigaLeve,
			boolean controleDePoluicao) {
		this.arCondicionado = arCondicionado;
		this.radio = radio;
		this.dvd = dvd;
		this.direcaoHidraulica = direcaoHidraulica;
		this.mp3 = mp3;
		this.cameraDeRe = cameraDeRe;
		TipoDeCambio = tipoDeCambio;
		this.airBag = airBag;
		this.direcaoAssistida = direcaoAssistida;
		this.cintosTraseirosRetrateis = cintosTraseirosRetrateis;
		this.rodasDeLigaLeve = rodasDeLigaLeve;
		this.controleDePoluicao = controleDePoluicao;
	}

	//Construtor para o Tipo Grande Porte with ID
	public Acessorios(int ID, boolean arCondicionado, boolean radio, boolean dvd,
			boolean direcaoHidraulica, boolean mp3, boolean cameraDeRe,
			String tipoDeCambio, boolean airBag, boolean direcaoAssistida,
			boolean cintosTraseirosRetrateis, boolean rodasDeLigaLeve,
			boolean controleDePoluicao, int capacidadeDeCarga,
			int distanciaEntreEixos, boolean acionamentoEmbreagem,
			int desempenhoDoVeiculo, Double potenciaMotor,
			int volumeDeAbastecimento) {
		this.arCondicionado = arCondicionado;
		this.radio = radio;
		this.dvd = dvd;
		this.direcaoHidraulica = direcaoHidraulica;
		this.mp3 = mp3;
		this.cameraDeRe = cameraDeRe;
		TipoDeCambio = tipoDeCambio;
		this.airBag = airBag;
		this.direcaoAssistida = direcaoAssistida;
		this.cintosTraseirosRetrateis = cintosTraseirosRetrateis;
		this.rodasDeLigaLeve = rodasDeLigaLeve;
		this.controleDePoluicao = controleDePoluicao;
		this.capacidadeDeCarga = capacidadeDeCarga;
		this.distanciaEntreEixos = distanciaEntreEixos;
		this.acionamentoEmbreagem = acionamentoEmbreagem;
		this.desempenhoDoVeiculo = desempenhoDoVeiculo;
		this.potenciaMotor = potenciaMotor;
		this.volumeDeAbastecimento = volumeDeAbastecimento;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public boolean isArCondicionado() {
		return arCondicionado;
	}

	public void setArCondicionado(boolean arCondicionado) {
		this.arCondicionado = arCondicionado;
	}

	public boolean isRadio() {
		return radio;
	}

	public void setRadio(boolean radio) {
		this.radio = radio;
	}

	public boolean isDvd() {
		return dvd;
	}

	public void setDvd(boolean dvd) {
		this.dvd = dvd;
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

	public String getTipoDeCambio() {
		return TipoDeCambio;
	}

	public void setTipoDeCambio(String tipoDeCambio) {
		TipoDeCambio = tipoDeCambio;
	}

	public boolean getAirBag() {
		return airBag;
	}

	public void setAirBag(boolean airBag) {
		this.airBag = airBag;
	}

	public boolean isDirecaoAssistida() {
		return direcaoAssistida;
	}

	public void setDirecaoAssistida(boolean direcaoAssistida) {
		this.direcaoAssistida = direcaoAssistida;
	}

	public boolean isCintosTraseirosRetrateis() {
		return cintosTraseirosRetrateis;
	}

	public void setCintosTraseirosRetrateis(boolean cintosTraseirosRetrateis) {
		this.cintosTraseirosRetrateis = cintosTraseirosRetrateis;
	}

	public boolean isRodasDeLigaLeve() {
		return rodasDeLigaLeve;
	}

	public void setRodasDeLigaLeve(boolean rodasDeLigaLeve) {
		this.rodasDeLigaLeve = rodasDeLigaLeve;
	}

	public boolean isControleDePoluicao() {
		return controleDePoluicao;
	}

	public void setControleDePoluicao(boolean controleDePoluicao) {
		this.controleDePoluicao = controleDePoluicao;
	}

	public double getCapacidadeDeCarga() {
		return capacidadeDeCarga;
	}

	public void setCapacidadeDeCarga(int capacidadeDeCarga) {
		this.capacidadeDeCarga = capacidadeDeCarga;
	}

	public double getDistanciaEntreEixos() {
		return distanciaEntreEixos;
	}

	public void setDistanciaEntreEixos(int distanciaEntreEixos) {
		this.distanciaEntreEixos = distanciaEntreEixos;
	}

	public boolean getAcionamentoEmbreagem() {
		return acionamentoEmbreagem;
	}

	public void setAcionamentoEmbreagem(boolean acionamentoEmbreagem) {
		this.acionamentoEmbreagem = acionamentoEmbreagem;
	}

	public double getDesempenhoDoVeiculo() {
		return desempenhoDoVeiculo;
	}

	public void setDesempenhoDoVeiculo(int desempenhoDoVeiculo) {
		this.desempenhoDoVeiculo = desempenhoDoVeiculo;
	}

	public Double getPotenciaMotor() {
		return potenciaMotor;
	}

	public void setPotenciaMotor(Double potenciaMotor) {
		this.potenciaMotor = potenciaMotor;
	}

	public double getVolumeDeAbastecimento() {
		return volumeDeAbastecimento;
	}

	public void setVolumeDeAbastecimento(int volumeDeAbastecimento) {
		this.volumeDeAbastecimento = volumeDeAbastecimento;
	}
	
}
