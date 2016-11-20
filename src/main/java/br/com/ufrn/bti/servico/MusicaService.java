package br.com.ufrn.bti.servico;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;

import br.com.ufrn.bti.comunicacao.conteudo.ConteudoRequisicaoPagamento;
import br.com.ufrn.bti.dominio.Musica;
import br.com.ufrn.bti.dominio.Usuario;
import br.com.ufrn.bti.util.JSONProcessor;

public class MusicaService {

	public MusicaService() {

	}

	public List<Musica> populaMusicas(String json) throws JSONException, IOException {

		List<Musica> musicas = new ArrayList<Musica>();
		musicas = JSONProcessor.toList(json, Musica.class);
		return musicas;

	}

	public String puxaMusicasDoServidor() {
		Socket s = null;

		try {
			s = new Socket("localhost", 6790);

			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());

			String json = (String) ois.readObject();

			return json;
		} catch (UnknownHostException e) {
			System.out.println("!!! Servidor Desconhecido: " + e.getMessage());
			return "[]";
		} catch (EOFException e) {
			System.out.println("!!! Não há mais dados de entrada: " + e.getMessage());
			return "[]";
		} catch (IOException e) {
			System.out.println("!!! E/S: " + e.getMessage());
			return "[]";
		} catch (ClassNotFoundException e) {
			System.out.println("!!! Erro no recebimento de mensagem: " + e.getMessage());
			return "[]";
		} finally {
			if (s != null) {
				try {
					s.close();
				} catch (IOException e) {
					System.out.println("!!! Encerramento do socket falhou: " + e.getMessage());
					return "[]";
				}
			}
		}
	}
	
	public boolean efetuaPagamentoMusicas(Usuario usuario, double valorPagamento){
		ConteudoRequisicaoPagamento conteudo = new ConteudoRequisicaoPagamento();
		conteudo.setUsuario(usuario);
		conteudo.setValorPagamento(valorPagamento);
		
		Socket s = null;

		try {
			s = new Socket("localhost", 6791);

			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(conteudo);
			
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			
			boolean deuCerto = (Boolean) ois.readObject();

			return deuCerto;
		} catch (UnknownHostException e) {
			System.out.println("!!! Servidor Desconhecido: " + e.getMessage());
			return false;
		} catch (EOFException e) {
			System.out.println("!!! Não há mais dados de entrada: " + e.getMessage());
			return false;
		} catch (IOException e) {
			System.out.println("!!! E/S: " + e.getMessage());
			return false;
		} catch (ClassNotFoundException e) {
			System.out.println("!!! Erro na leitura do objeto: " + e.getMessage());
			return false;
		} finally {
			if (s != null) {
				try {
					s.close();
				} catch (IOException e) {
					System.out.println("!!! Encerramento do socket falhou: " + e.getMessage());
					return false;
				}
			}
		}
	}

	public List<Musica> simulaMusicas() {
		Musica m1 = new Musica(1, "m1", "c2",
				"/Users/ramonsantos/bti/workspaces/concorrente_distribuida/EspatifadoFiles/1.mp3",
				(double) Math.random() * 100, (double) Math.random() * 10000);
		Musica m2 = new Musica(2, "m2", "c3",
				"/Users/ramonsantos/bti/workspaces/concorrente_distribuida/EspatifadoFiles/2.mp3",
				(double) Math.random() * 100, (double) Math.random() * 10000);
		Musica m3 = new Musica(3, "m3", "c4",
				"/Users/ramonsantos/bti/workspaces/concorrente_distribuida/EspatifadoFiles/3.mp3",
				(double) Math.random() * 100, (double) Math.random() * 10000);
		Musica m4 = new Musica(4, "m4", "c5",
				"/Users/ramonsantos/bti/workspaces/concorrente_distribuida/EspatifadoFiles/4.mp3",
				(double) Math.random() * 100, (double) Math.random() * 10000);
		Musica m5 = new Musica(5, "m5", "c6",
				"/Users/ramonsantos/bti/workspaces/concorrente_distribuida/EspatifadoFiles/5.mp3",
				(double) Math.random() * 100, (double) Math.random() * 10000);
		Musica m6 = new Musica(6, "m6", "c7",
				"/Users/ramonsantos/bti/workspaces/concorrente_distribuida/EspatifadoFiles/6.mp3",
				(double) Math.random() * 100, (double) Math.random() * 10000);
		Musica m7 = new Musica(7, "m7", "c8",
				"/Users/ramonsantos/bti/workspaces/concorrente_distribuida/EspatifadoFiles/7.mp3",
				(double) Math.random() * 100, (double) Math.random() * 10000);

		List<Musica> musicas = new ArrayList<Musica>();

		musicas.add(m1);
		musicas.add(m2);
		musicas.add(m3);
		musicas.add(m4);
		musicas.add(m5);
		musicas.add(m6);
		musicas.add(m7);

		return musicas;

	}

}
