package br.com.Locadora.model;

import java.sql.Date;

public class Locacao {
	private int id;
	private Cliente cliente;
	private PessoaFisica pessoaFisica;
	private String modalidade;
	private Double valorTotal;
	private Date horaLocacao, horaDevolucao;
	public Locacao(int id, Cliente cliente, PessoaFisica pessoaFisica,
			String modalidade, Double valorTotal, Date horaLocacao,
			Date horaDevolucao) {
		this.id = id;
		this.cliente = cliente;
		this.pessoaFisica = pessoaFisica;
		this.modalidade = modalidade;
		this.valorTotal = valorTotal;
		this.horaLocacao = horaLocacao;
		this.horaDevolucao = horaDevolucao;
	}
	public int getId() {
		return id;
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
	public Date getHoraDevolucao() {
		return horaDevolucao;
	}
	public void setHoraDevolucao(Date horaDevolucao) {
		this.horaDevolucao = horaDevolucao;
	}
	
	
}
