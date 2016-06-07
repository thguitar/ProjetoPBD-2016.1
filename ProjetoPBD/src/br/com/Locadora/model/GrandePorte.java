package br.com.Locadora.model;

public class GrandePorte extends Categoria{
	private int capacidadeDeCarga, distanciaEntreEixos, desempenhoDoVeiculo, volumeDeAbastecimento;
	private String acionamentoEmbreagem;
	private Double potenciaMotor;
	public GrandePorte(int id, int kmParaRevisao, int capacidadeDeCarga,
			int distanciaEntreEixos, int desempenhoDoVeiculo,
			int volumeDeAbastecimento, String acionamentoEmbreagem,
			Double potenciaMotor) {
		super(id, kmParaRevisao);
		this.capacidadeDeCarga = capacidadeDeCarga;
		this.distanciaEntreEixos = distanciaEntreEixos;
		this.desempenhoDoVeiculo = desempenhoDoVeiculo;
		this.volumeDeAbastecimento = volumeDeAbastecimento;
		this.acionamentoEmbreagem = acionamentoEmbreagem;
		this.potenciaMotor = potenciaMotor;
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
	public int getVolumeDeAbastecimento() {
		return volumeDeAbastecimento;
	}
	public void setVolumeDeAbastecimento(int volumeDeAbastecimento) {
		this.volumeDeAbastecimento = volumeDeAbastecimento;
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
	
}