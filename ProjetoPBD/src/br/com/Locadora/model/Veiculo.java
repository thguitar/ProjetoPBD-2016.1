package br.com.Locadora.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
public class Veiculo {
	@Id
	private String numeroChassi;
	@Column
	private String cor;
	@Column
	private String combustivel;
	@Column
	private String placa;
	@Column
	private String anoModelo;
	@Column
	private String anoFabricacao;
	@Column
	private int numeroPortas;
	@Column
	private int numeroMotor;
	@Column
	private Double quilometragem;
	@Column
	private Double capacidadePassageiroos;
	@Column
	private Double torqueDoMotor;
	
//	private Categoria categoria;
	
	public Veiculo() {
		
	}
	public String getNumeroChassi() {
		return numeroChassi;
	}
	public void setNumeroChassi(String numeroChassi) {
		this.numeroChassi = numeroChassi;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getCombustivel() {
		return combustivel;
	}
	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getAnoModelo() {
		return anoModelo;
	}
	public void setAnoModelo(String anoModelo) {
		this.anoModelo = anoModelo;
	}
	public String getAnoFabricacao() {
		return anoFabricacao;
	}
	public void setAnoFabricacao(String anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	public int getNumeroPortas() {
		return numeroPortas;
	}
	public void setNumeroPortas(int numeroPortas) {
		this.numeroPortas = numeroPortas;
	}
	public int getNumeroMotor() {
		return numeroMotor;
	}
	public void setNumeroMotor(int numeroMotor) {
		this.numeroMotor = numeroMotor;
	}
	public Double getQuilometragem() {
		return quilometragem;
	}
	public void setQuilometragem(Double quilometragem) {
		this.quilometragem = quilometragem;
	}
	public Double getCapacidadePassageiroos() {
		return capacidadePassageiroos;
	}
	public void setCapacidadePassageiroos(Double capacidadePassageiroos) {
		this.capacidadePassageiroos = capacidadePassageiroos;
	}
	public Double getTorqueDoMotor() {
		return torqueDoMotor;
	}
	public void setTorqueDoMotor(Double torqueDoMotor) {
		this.torqueDoMotor = torqueDoMotor;
	}
//	public Categoria getCategoria() {
//		return categoria;
//	}
//	public void setCategoria(Categoria categoria) {
//		this.categoria = categoria;
//	}
	
}
