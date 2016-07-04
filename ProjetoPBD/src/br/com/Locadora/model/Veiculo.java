package br.com.Locadora.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Veiculo {
	//@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "ID")
	//private int id;
	@Id
	@Column(name = "NUM_CHASSI", unique = true, nullable = false)
	private String numeroChassi;
	@Column(name = "COR", nullable = false)
	private String cor;
	@Column(name = "COMBUSTIVEL", length = 11, nullable = false)
	private String combustivel;
	@Column(name = "PLACA", unique = true, length = 7, nullable = false)
	private String placa;
	@Column(name = "ANO_MODELO", nullable = false)
	private int anoModelo;
	@Column(name = "ANO_FABRICACAO", nullable = false)
	private int anoFabricacao;
	@Column(name = "NUM_PORTAS", length = 10, nullable = false)
	private int numeroPortas;
	@Column(name = "NUM_MOTOR", unique = true, nullable = false)
	private int numeroMotor;
	@Column(name = "QUILOMETRAGEM", nullable = false)
	private Double quilometragem;
	@Column(name = "CAPACIDADE", nullable = false)
	private int capacidadePassageiroos;
	@Column(name = "TORQUE_MOTOR", nullable = false)
	private Double torqueDoMotor;
	@Column(name = "IDCATEGORIA", nullable = false)
	private int categoria;
	private PequenoPorte pequenoPorte;

	public Veiculo() {

	}
	
	public Veiculo(String numeroChassi, String cor, String combustivel,
			String placa, int anoModelo, int anoFabricacao,
			int numeroPortas, int numeroMotor, Double quilometragem,
			int capacidadePassageiroos, Double torqueDoMotor,
			int categoria) {
		this.numeroChassi = numeroChassi;
		this.cor = cor;
		this.combustivel = combustivel;
		this.placa = placa;
		this.anoModelo = anoModelo;
		this.anoFabricacao = anoFabricacao;
		this.numeroPortas = numeroPortas;
		this.numeroMotor = numeroMotor;
		this.quilometragem = quilometragem;
		this.capacidadePassageiroos = capacidadePassageiroos;
		this.torqueDoMotor = torqueDoMotor;
		this.categoria = categoria;
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
	public int getAnoModelo() {
		return anoModelo;
	}
	public void setAnoModelo(int anoModelo) {
		this.anoModelo = anoModelo;
	}
	public int getAnoFabricacao() {
		return anoFabricacao;
	}
	public void setAnoFabricacao(int anoFabricacao) {
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
	public int getCapacidadePassageiroos() {
		return capacidadePassageiroos;
	}
	public void setCapacidadePassageiroos(int capacidadePassageiroos) {
		this.capacidadePassageiroos = capacidadePassageiroos;
	}
	public Double getTorqueDoMotor() {
		return torqueDoMotor;
	}
	public void setTorqueDoMotor(Double torqueDoMotor) {
		this.torqueDoMotor = torqueDoMotor;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	
	public void setPorte(PequenoPorte pequenoPorte){
		this.pequenoPorte = pequenoPorte;
	}
}
