package br.com.ufrn.bti.concorrente.espatifado.cliente.comunicacao;

public class MensagemRequisicao<T> extends AbstractMensagem<T> {

	public MensagemRequisicao(TipoMensagem tipoMensagem, T conteudo) {
		super(tipoMensagem, conteudo);
	}

	public MensagemRequisicao(){}

}
