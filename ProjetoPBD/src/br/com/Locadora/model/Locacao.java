package br.com.Locadora.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "locacao")
public class Locacao {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private Cliente cliente;
	@Column
	private PessoaFisica pessoaFisica;
	@Column
	private String modalidade;
	@Column
	private Double valorTotal;
	@Column
	private Date horaLocacao;
	@Column
	private Date tempoDevolucao;
	@Column
	private Devolucao devolucao;
	
	public Locacao(Cliente cliente, PessoaFisica pessoaFisica,
			String modalidade, Double valorTotal, Date horaLocacao,
			Date tempoDevolucao) {
		this.cliente = cliente;
		this.pessoaFisica = pessoaFisica;
		this.modalidade = modalidade;
		this.valorTotal = valorTotal;
		this.horaLocacao = horaLocacao;
		this.tempoDevolucao = tempoDevolucao;
	}
	public int getId() {
		return id;
	}
	public Date getTempoDevolucao() {
		return tempoDevolucao;
	}
	public void setTempoDevolucao(Date tempoDevolucao) {
		this.tempoDevolucao = tempoDevolucao;
	}
	public Devolucao getDevolucao() {
		return devolucao;
	}
	public void setDevolucao(Devolucao devolucao) {
		this.devolucao = devolucao;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}
	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}
	public String getModalidade() {
		return modalidade;
	}
	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public Date getHoraLocacao() {
		return horaLocacao;
	}
	public void setHoraLocacao(Date horaLocacao) {
		this.horaLocacao = horaLocacao;
	}
	
	
}
