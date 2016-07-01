package br.com.Locadora.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name = "LOGIN", unique = true, nullable = false)
	private String login;
	@Column(name = "SENHA", nullable = false)
	private String senha;
	@Column(name = "NOME", unique = false, nullable = false)
	private String nome;
	@Column(name = "ADMIN")
	private boolean admin;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "EMPRESA", nullable = false)
	private int empresa;
	
	public Usuario() {
		
	}
	
	public Usuario(String nomeLogin, String senha){
		this.login = nomeLogin;
		this.senha = senha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getEmpresa() {
		return empresa;
	}

	public void setEmpresa(int empresa) {
		this.empresa = empresa;
	}
	
}
