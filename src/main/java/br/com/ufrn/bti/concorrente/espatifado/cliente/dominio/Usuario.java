package br.com.ufrn.bti.concorrente.espatifado.cliente.dominio;

public class Usuario {
	
	private int id;
	
	private String login;
	
	private String senha;
	
	public Usuario(){
		
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
