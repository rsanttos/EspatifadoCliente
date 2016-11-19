package br.com.ufrn.bti.concorrente.espatifado.cliente.dominio;

import java.io.Serializable;

public class Musica implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6927402813202455674L;

	private int id;
	
	private String nome;
	
	private String cantor;
	
	private String caminhoArquivo;
	
	private double preco;
	
	private double tamanho;
	
	public Musica(){
		
	}

	public Musica(int id, String nome, String cantor, double preco, double tamanho) {
		super();
		this.id = id;
		this.nome = nome;
		this.cantor = cantor;
		this.preco = preco;
		this.tamanho = tamanho;
	}
	
	public Musica(int id, String nome, String cantor, String caminhoArquivo, double preco, double tamanho) {
		super();
		this.id = id;
		this.nome = nome;
		this.cantor = cantor;
		this.caminhoArquivo = caminhoArquivo;
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

	public String getCantor() {
		return cantor;
	}

	public void setCantor(String cantor) {
		this.cantor = cantor;
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

	public String getCaminhoArquivo() {
		return caminhoArquivo;
	}

	public void setCaminhoArquivo(String caminhoArquivo) {
		this.caminhoArquivo = caminhoArquivo;
	}
	
}
