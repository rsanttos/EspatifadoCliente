package br.com.ufrn.bti.concorrente.espatifado.cliente.dominio;

import java.io.Serializable;

public class Usuario implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5846796897460964406L;

	private int id;
	
	private String login;
	
	private String senha;
	
	private Pessoa pessoa;
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

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
