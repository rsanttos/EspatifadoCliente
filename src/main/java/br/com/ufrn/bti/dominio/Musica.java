package br.com.ufrn.bti.dominio;

import java.io.Serializable;

public class Musica {
	
	private static final long serialVersionUID = -1370492530379526895L;

	/**
	 * ID da entidade
	 */
	private int id;
	
	private String nome;
	
	private String banda;
	
	private String caminhoArquivoServidor;
	
	private String caminhoArquivoCliente;
	
	private double preco;
	
	private double tamanho;
	
	public Musica(){
		
	}

	public Musica(int id, String nome, String banda, String caminhoArquivo, double preco, double tamanho) {
		super();
		this.id = id;
		this.nome = nome;
		this.banda = banda;
		this.caminhoArquivoServidor = caminhoArquivo;
		this.preco = preco;
		this.tamanho = tamanho;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getBanda() {
		return banda;
	}

	public void setBanda(String banda) {
		this.banda = banda;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double getTamanho() {
		return tamanho;
	}

	public void setTamanho(double tamanho) {
		this.tamanho = tamanho;
	}

	public String getCaminhoArquivoServidor() {
		return caminhoArquivoServidor;
	}

	public void setCaminhoArquivoServidor(String caminhoArquivoServidor) {
		this.caminhoArquivoServidor = caminhoArquivoServidor;
	}

	public String getCaminhoArquivoCliente() {
		return caminhoArquivoCliente;
	}

	public void setCaminhoArquivoCliente(String caminhoArquivoCliente) {
		this.caminhoArquivoCliente = caminhoArquivoCliente;
	}
	
	
	
}
