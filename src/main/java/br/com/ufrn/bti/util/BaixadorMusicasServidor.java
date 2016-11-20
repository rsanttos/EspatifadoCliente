package br.com.ufrn.bti.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class BaixadorMusicasServidor {

	public BaixadorMusicasServidor() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		int porta = 5678;

		ServerSocket escuta = new ServerSocket(porta);

		System.out.println("*** Cliente ***");
		System.out.println("*** Porta de escuta (listen): " + porta);

		while (true) {
			Socket cliente = escuta.accept();
			System.out.println("*** conexao aceita de (remoto): " + cliente.getRemoteSocketAddress());

			ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());

			String nomeArquivo = (String) ois.readObject();
			byte[] arquivoBytes = (byte[]) ois.readObject();

			FileOutputStream fileOuputStream = new FileOutputStream(nomeArquivo);
			fileOuputStream.write(arquivoBytes);
			fileOuputStream.close();
		}
	}

}
