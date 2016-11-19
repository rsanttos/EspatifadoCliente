package br.com.ufrn.bti.concorrente.espatifado.cliente.servico;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import br.com.ufrn.bti.concorrente.espatifado.cliente.comunicacao.MensagemRequisicao;
import br.com.ufrn.bti.concorrente.espatifado.cliente.comunicacao.MensagemResposta;
import br.com.ufrn.bti.concorrente.espatifado.cliente.comunicacao.TipoMensagem;
import br.com.ufrn.bti.concorrente.espatifado.cliente.dominio.Usuario;

public class UsuarioService {

	public UsuarioService() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean efetuarLogin(Usuario usuario){
		try {
			Socket socketServidor = new Socket("localhost", 40123);
			
			ObjectInputStream inputStream = new ObjectInputStream(socketServidor.getInputStream());
			ObjectOutputStream outputStream = new ObjectOutputStream(socketServidor.getOutputStream());
			
			outputStream.writeObject(new MensagemRequisicao<Usuario>(TipoMensagem.LOGIN, usuario));
			
			MensagemResposta<Boolean> mensagemResposta = (MensagemResposta<Boolean>) inputStream.readObject();
			
			inputStream.close();
			outputStream.close();
			socketServidor.close();
			
			return mensagemResposta.isSucesso();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
	}

}
