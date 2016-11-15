package br.com.ufrn.bti.concorrente.espatifado.cliente.controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.ufrn.bti.concorrente.espatifado.cliente.dominio.Musica;
import br.com.ufrn.bti.concorrente.espatifado.cliente.servico.MusicaService;

@ManagedBean
@ViewScoped
public class MusicaMBean {

	private DataModel<Musica> listagem;

	private DataModel<Musica> listagemCarrinho;

	private List<Musica> musicasCarrinho;

	private Musica musica;

	private MusicaService musicaService;

	public MusicaMBean() {
		musicaService = new MusicaService();
		musica = new Musica();
		musicasCarrinho = new ArrayList<Musica>();
		musicasCarrinho = populaMusicasCarrinho(musicasCarrinho);
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

	@SuppressWarnings("unchecked")
	public String adicionaAoCarrinho() {

		musica = (Musica) listagem.getRowData();

		musicasCarrinho = new ArrayList<Musica>();
		musicasCarrinho = populaMusicasCarrinho(musicasCarrinho);
		
		musicasCarrinho.add(musica);

		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		session.setAttribute("MUSICAS_CARRINHO", musicasCarrinho);

		return "/pages/carrinho.jsf";
	}

	public DataModel<Musica> getListagem() {
		listagem = new ListDataModel<Musica>(musicaService.populaMusicas());
		return listagem;
	}

	public void setListagem(DataModel<Musica> listagem) {
		this.listagem = listagem;
	}

	@SuppressWarnings("unchecked")
	public DataModel<Musica> getListagemCarrinho() {

		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		HttpServletRequest request = (HttpServletRequest) req;
		HttpSession session = (HttpSession) request.getSession();

		musicasCarrinho = (List<Musica>) session.getAttribute("MUSICAS_CARRINHO");

		listagemCarrinho = new ListDataModel<Musica>(musicasCarrinho);
		
		return listagemCarrinho;
	}

	public void setListagemCarrinho(DataModel<Musica> listagemCarrinho) {
		this.listagemCarrinho = listagemCarrinho;
	}

	public List<Musica> getMusicasCarrinho() {
		return musicasCarrinho;
	}

	public void setMusicasCarrinho(List<Musica> musicasCarrinho) {
		this.musicasCarrinho = musicasCarrinho;
	}
	
	public String voltarParaListagem(){

		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		session.setAttribute("MUSICAS_CARRINHO", musicasCarrinho);
		
		
		return "/pages/listMusicas.jsf";
	}
	
	public String finalizaCompra(){
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Musica> populaMusicasCarrinho(List<Musica> musicas){
		
		List<Musica> musicasAux = new ArrayList<Musica>();
		
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		HttpServletRequest request = (HttpServletRequest) req;
		HttpSession session = (HttpSession) request.getSession();

		musicasAux = (List<Musica>) session.getAttribute("MUSICAS_CARRINHO");
		
		if(musicasAux == null){
			return musicas;
		} else {
			return musicasAux;
		}
	}

}
