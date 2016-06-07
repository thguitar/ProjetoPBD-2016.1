package br.com.Locadora.model;

public class Usuario {
	private int id;
	private String senha, nomeLogin, nome, email;
	private boolean admin;
	public Usuario(int id, String senha, String nomeLogin, String nome,
			String email, boolean admin) {
		this.id = id;
		this.senha = senha;
		this.nomeLogin = nomeLogin;
		this.nome = nome;
		this.email = email;
		this.admin = admin;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNomeLogin() {
		return nomeLogin;
	}
	public void setNomeLogin(String nomeLogin) {
		this.nomeLogin = nomeLogin;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
}
