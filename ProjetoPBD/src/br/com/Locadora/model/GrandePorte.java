package br.com.Locadora.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class GrandePorte extends Categoria{
	@Column(name = "CAP_DE_CARGA")
	private int capacidadeDeCarga;
	@Column(name = "DIST_ENTRE_EIXOS")
	private int distanciaEntreEixos;
	@Column(name = "ACION_EMBREAGEM")
	private String acionamentoEmbreagem;
	@Column(name = "DESEMP_VEICULO")
	private int desempenhoDoVeiculo;
	@Column(name = "POTENCIA_MOTOR")
	private Double potenciaMotor;
	@Column(name = "VOL_ABASTECIMENTO")
	private int volumeDeAbastecimento;

	public GrandePorte(int id, int kmParaRevisao, int capacidadeDeCarga,
			int distanciaEntreEixos, int desempenhoDoVeiculo,
			String acionamentoEmbreagem, Double potenciaMotor, int volumeDeAbastecimento) {
		super(kmParaRevisao);
		this.capacidadeDeCarga = capacidadeDeCarga;
		this.distanciaEntreEixos = distanciaEntreEixos;
		this.desempenhoDoVeiculo = desempenhoDoVeiculo;
		this.acionamentoEmbreagem = acionamentoEmbreagem;
		this.potenciaMotor = potenciaMotor;
		this.volumeDeAbastecimento = volumeDeAbastecimento;
	}
	public int getCapacidadeDeCarga() {
		return capacidadeDeCarga;
	}
	public void setCapacidadeDeCarga(int capacidadeDeCarga) {
		this.capacidadeDeCarga = capacidadeDeCarga;
	}
	public int getDistanciaEntreEixos() {
		return distanciaEntreEixos;
	}
	public void setDistanciaEntreEixos(int distanciaEntreEixos) {
		this.distanciaEntreEixos = distanciaEntreEixos;
	}
	public int getDesempenhoDoVeiculo() {
		return desempenhoDoVeiculo;
	}
	public void setDesempenhoDoVeiculo(int desempenhoDoVeiculo) {
		this.desempenhoDoVeiculo = desempenhoDoVeiculo;
	}
	public String getAcionamentoEmbreagem() {
		return acionamentoEmbreagem;
	}
	public void setAcionamentoEmbreagem(String acionamentoEmbreagem) {
		this.acionamentoEmbreagem = acionamentoEmbreagem;
	}
	public Double getPotenciaMotor() {
		return potenciaMotor;
	}
	public void setPotenciaMotor(Double potenciaMotor) {
		this.potenciaMotor = potenciaMotor;
	}
	public int getVolumeDeAbastecimento() {
		return volumeDeAbastecimento;
	}
	public void setVolumeDeAbastecimento(int volumeDeAbastecimento) {
		this.volumeDeAbastecimento = volumeDeAbastecimento;
	}
	
}
