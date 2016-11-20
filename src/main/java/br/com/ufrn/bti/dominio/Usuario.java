package br.com.ufrn.bti.dominio;

import java.io.Serializable;
import java.util.List;

import org.dom4j.tree.AbstractEntity;


public class Usuario extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = -1370492530379526895L;

	/**
	 * ID da entidade
	 */
	private int id;
	
	/**
	 * Login do usuário no sistema
	 */
	private String login;
	
	/**
	 * Senha de acesso do usuário no sistema
	 */
	private String senha;
	
	
	/**
	 * Pessoa que é o usuário no sistema
	 * Relacionamento ORM
	 */
	private Pessoa pessoa;
 	
 	/**
 	 * 
 	 * Atributo que representa se um usuário está ativo ou não no sistema
 	 * 
 	 */
	private boolean ativo;

	/**
	 * 
	 * Musicas que um usuário pode ter no sistema
	 * 
	 */
	private List<Musica> musicas;
	
	
 	/**
 	 * Construtor da classe
 	 */
 	public Usuario() {
		pessoa = new Pessoa();
	}
 	
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}


	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}


	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}


	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}


	/**
	 * @return the pessoa
	 */
	public Pessoa getPessoa() {
		return pessoa;
	}


	/**
	 * @param pessoa the pessoa to set
	 */
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}


	/**
	 * @return the ativo
	 */
	public boolean isAtivo() {
		return ativo;
	}


	/**
	 * @param ativo the ativo to set
	 */
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}


	public List<Musica> getMusicas() {
		return musicas;
	}


	public void setMusicas(List<Musica> musicas) {
		this.musicas = musicas;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	/**
	 * Método que verifica se um objeto da entidade é igual ao objeto recebido como parâmetro
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}