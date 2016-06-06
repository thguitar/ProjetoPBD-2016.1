package br.com.Locadora.model;

public class Veiculo {
	private String numeroChassi, cor, combustivel, placa, anoModelo, anoFabricacao;
	private int numeroPortas, numeroMotor;
	private Double quilometragem, capacidadePassageiroos, torqueDoMotor;
	private Categoria categoria;
	public Veiculo(String numeroChassi, String cor, String combustivel,
			String placa, String anoModelo, String anoFabricacao,
			int numeroPortas, int numeroMotor, Double quilometragem,
			Double capacidadePassageiroos, Double torqueDoMotor,
			Categoria categoria) {
		super();
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
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
}
