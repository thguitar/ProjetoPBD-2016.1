package br.com.Locadora.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Locacao {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID;
	@OneToOne
	@JoinColumn(name="IDCLIENTE")
	private Cliente cliente;
	@OneToOne
	@JoinColumn(name="IDMOTORISTA")
	private PessoaFisica motorista;
	@OneToOne
	@JoinColumn(name="IDVEICULO")
	private Veiculo veiculo;
	@OneToOne
	@JoinColumn(name="IDEMPRESADESTINO")
	private Empresa empresaDestino;
	@Column(name = "TIPO", length = 20, nullable = false)
	private String tipo;
	@Column(name = "VALOR", nullable = false)
	private Double valor;
	@Column(name = "DATA_HORA_SAIDA")
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date dataHoraSaida;
	@Column(name = "DATA_PREVISTA_DEVOLUCAO", nullable = false)
	@Temporal(value=TemporalType.DATE)
	private Date dataPrevistaDevolucao;
	@Column(name = "STATUS", length = 15)
	private String status;
	@Column(name = "CANCELADA")
	private boolean cancelada;
	@Column(name = "IDRESERVA")
	private int idReservaImportada;
	
	public Locacao() {

	}

	public Locacao(Cliente cliente, PessoaFisica motorista, Veiculo veiculo,
			String tipo, Double valor, Date dataHoraSaida,
			Date dataPrevistaDevolucao, Empresa empresa) {
		this.cliente = cliente;
		this.motorista = motorista;
		this.veiculo = veiculo;
		this.empresaDestino = empresa;
		this.tipo = tipo;
		this.valor = valor;
		this.dataHoraSaida = dataHoraSaida;
		this.dataPrevistaDevolucao = dataPrevistaDevolucao;
		this.status = "EM ABERTO";
	}

	public Locacao(int iD, Cliente cliente, PessoaFisica motorista,
			Veiculo veiculo, Empresa empresa, String tipo, Double valor, Date dataHoraSaida,
			Date dataPrevistaDevolucao, String status, boolean cancelada, int idReservaImportada) {
		ID = iD;
		this.cliente = cliente;
		this.motorista = motorista;
		this.veiculo = veiculo;
		this.empresaDestino = empresa;
		this.tipo = tipo;
		this.valor = valor;
		this.dataHoraSaida = dataHoraSaida;
		this.dataPrevistaDevolucao = dataPrevistaDevolucao;
		this.status = status;
		this.cancelada = cancelada;
		this.idReservaImportada = idReservaImportada; 
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public PessoaFisica getMotorista() {
		return motorista;
	}

	public void setMotorista(PessoaFisica motorista) {
		this.motorista = motorista;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getDataHoraSaida() {
		return dataHoraSaida;
	}

	public void setDataHoraSaida(Date dataHoraSaida) {
		this.dataHoraSaida = dataHoraSaida;
	}

	public Date getDataPrevistaDevolucao() {
		return dataPrevistaDevolucao;
	}

	public void setDataPrevistaDevolucao(Date dataPrevistaDevolucao) {
		this.dataPrevistaDevolucao = dataPrevistaDevolucao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isCancelada() {
		return cancelada;
	}

	public void setCancelada(boolean cancelada) {
		this.cancelada = cancelada;
	}

	public Empresa getEmpresaDestino() {
		return empresaDestino;
	}

	public void setEmpresaDestino(Empresa empresaDestino) {
		this.empresaDestino = empresaDestino;
	}

	public int getIdReservaImportada() {
		return idReservaImportada;
	}

	public void setIdReservaImportada(int idReservaImportada) {
		this.idReservaImportada = idReservaImportada;
	}
	
}
