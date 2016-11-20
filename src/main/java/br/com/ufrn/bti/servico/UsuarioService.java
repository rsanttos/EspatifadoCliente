package br.com.ufrn.bti.servico;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import br.com.ufrn.bti.comunicacao.MensagemRequisicao;
import br.com.ufrn.bti.comunicacao.MensagemResposta;
import br.com.ufrn.bti.comunicacao.TipoMensagem;
import br.com.ufrn.bti.dominio.Usuario;

public class UsuarioService {

	public UsuarioService() {
		// TODO Auto-generated constructor stub
	}

	public boolean efetuarLogin(Usuario usuario) {
		Socket s = null;

		try {
			s = new Socket("localhost", 6789);
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
			
			MensagemRequisicao<Usuario> m = new MensagemRequisicao<Usuario>();
			m.setTipoMensagem(TipoMensagem.LOGIN);
			m.setConteudo(usuario);
			
			oos.writeObject(m);
			System.out.println("Flushando..");
			oos.flush();
			
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			MensagemResposta<Boolean> mr;
			
			mr = (MensagemResposta<Boolean>) ois.readObject();
			
			return mr.isSucesso();
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
			System.out.println("!!! Erro no recebimento de mensagem: " + e.getMessage());
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

}
