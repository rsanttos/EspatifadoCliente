package br.com.ufrn.bti.concorrente.espatifado.cliente.controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.ufrn.bti.concorrente.espatifado.cliente.dominio.Musica;
import br.com.ufrn.bti.concorrente.espatifado.cliente.util.JSONProcessor;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Musica m = new Musica();
		List<Musica> musicas = new ArrayList<Musica>();
		String json = "[{\"id\":1,\"nome\":\"aaaa\",\"banda\":\"teste\",\"caminhoArquivo\":\"testeeee\",\"preco\":10.0,\"tamanho\":0.0}, {\"id\":2,\"nome\":\"aaaa\",\"banda\":\"teste\",\"caminhoArquivo\":\"testeaaa\",\"preco\":10.0,\"tamanho\":0.0}]";
		System.out.println(json);
		musicas = JSONProcessor.toList(json, Musica.class);
		System.out.println(musicas.get(1).getCaminhoArquivo());
	}

}
