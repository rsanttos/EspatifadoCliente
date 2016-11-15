package br.com.ufrn.bti.concorrente.espatifado.cliente.controle;

import javax.faces.bean.ManagedBean;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.ufrn.bti.concorrente.espatifado.cliente.dominio.Musica;
import br.com.ufrn.bti.concorrente.espatifado.cliente.servico.MusicaService;

@ManagedBean
public class MusicaMBean {
	
	private DataModel<Musica> listagem;
	
	private DataModel<Musica> listagemCarrinho;
	
	private Musica musica;
	
	private MusicaService musicaService;
	
	public MusicaMBean(){
		musicaService = new MusicaService();
		musica = new Musica();
	}

	public Musica getMusica() {
		return musica;
	}

	public void setMusica(Musica musica) {
		this.musica = musica;
	}

	public MusicaService getMusicaService() {
		return musicaService;
	}

	public void setMusicaService(MusicaService musicaService) {
		this.musicaService = musicaService;
	}
	
	public String adicionaAoCarrinho(){
		musica = (Musica)listagem.getRowData();
		return "/carrinho.jsf";		
	}

	public DataModel<Musica> getListagem() {
		listagem = new ListDataModel<Musica>(musicaService.populaMusicas());
		return listagem;
	}

	public void setListagem(DataModel<Musica> listagem) {
		this.listagem = listagem;
	}

	public DataModel<Musica> getListagemCarrinho() {
		return listagemCarrinho;
	}

	public void setListagemCarrinho(DataModel<Musica> listagemCarrinho) {
		this.listagemCarrinho = listagemCarrinho;
	}
	
}
