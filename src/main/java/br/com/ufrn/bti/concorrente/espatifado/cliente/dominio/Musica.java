package br.com.ufrn.bti.concorrente.espatifado.cliente.dominio;

public class Musica {

	private int id;
	
	private String nome;
	
	private String cantor;
	
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
	
}
