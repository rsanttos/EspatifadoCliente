package br.com.ufrn.bti.concorrente.espatifado.cliente.dominio;

import java.io.Serializable;

/**
 * 
 */

import java.util.Date;

import org.dom4j.tree.AbstractEntity;


public class Pessoa extends AbstractEntity implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 5950037841442058299L;

	/**
	 * ID da entidade
	 */
	private int id;
	
	private String nome;
	
	private String cpf;
	

	private Date dataNascimento;
	
	/**
	 * Sexo da pessoa
	 * M = Masculino
	 * F = Feminino
	 * 
	 */
	private char sexo = 'I';
	
	private String email;
	
	/**
	 * Atributo de controle que indica se a pessoa está ativa ou não
	 * Necessário para exclusão lógica no sistema
	 * TRUE  = ativo
	 * FALSE = inativo
	 */
	private boolean ativo;
	/**
	 * Cidade e Estado da pessoa
	 */
	private String cidadeEstado;
	
	
	/**
	 * Construtor da entidade
	 */
	public Pessoa() {
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
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return the dataNascimento
	 */
	public Date getDataNascimento() {
		return dataNascimento;
	}

	/**
	 * @param dataNascimento the dataNascimento to set
	 */
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	/**
	 * @return the sexo
	 */
	public char getSexo() {
		return sexo;
	}

	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
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

	/**
	 * @return the cidadeEstado
	 */
	public String getCidadeEstado() {
		return cidadeEstado;
	}

	/**
	 * @param cidadeEstado the cidadeEstado to set
	 */
	public void setCidadeEstado(String cidadeEstado) {
		this.cidadeEstado = cidadeEstado;
	}
	
	/***
	 * 
	 */
	public String getSexoExtenso(){
		if(this.sexo == 'F') {
			return "Feminino";
		} else {
			return "Masculino";
		}
	}

	/**
	 * Mï¿½todo que retorna o CPF da pessoa com a mï¿½scara
	 * @return
	 */
	public String getCpfMask() {
		String cpfMask = "";
		if (cpf != null && !cpf.isEmpty()) {
			cpfMask = cpf;
			cpfMask = cpfMask.substring(0,3)+"."+cpfMask.substring(3,6)+"."+cpfMask.substring(6,9)+"-"+cpfMask.substring(9,11);	
		}
		return cpfMask;
	}	

	
	public boolean equals(Object obj) {
		try{
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pessoa other = (Pessoa) obj;
			if (id != other.id)
				return false;
			if (!cpf.equals(other.cpf))
				return false;
		}catch(NullPointerException e){
			return false;
		}
		return true;
	}
	

}
