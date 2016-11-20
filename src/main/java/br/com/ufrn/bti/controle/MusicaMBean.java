package br.com.ufrn.bti.controle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONException;

import br.com.ufrn.bti.dominio.Musica;
import br.com.ufrn.bti.dominio.Usuario;
import br.com.ufrn.bti.servico.MusicaService;
import br.com.ufrn.bti.util.DownloadFileHandler;
import br.com.ufrn.bti.util.JSONProcessor;

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

	public DataModel<Musica> getListagem() throws JSONException, IOException {
		// List<Musica> musicas = musicaService.simulaMusicas();
		// String json = JSONProcessor.toJSON(musicas);
		// json = trataJson(json);

		String json = musicaService.puxaMusicasDoServidor();

		json = trataJson(json);

		if (json != null) {
			listagem = new ListDataModel<Musica>(musicaService.populaMusicas(json));
		} else {
			listagem = new ListDataModel<Musica>();
		}

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

	public String voltarParaListagem() {

		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		session.setAttribute("MUSICAS_CARRINHO", musicasCarrinho);

		return "/pages/listMusicas.jsf";
	}

	public String finalizaCompra() throws FileNotFoundException {
		double valorPagamento = getValorTotalCompra();

		Usuario usuarioLogado = new Usuario();

		usuarioLogado = getUsuarioLogado();

		if (musicaService.efetuaPagamentoMusicas(usuarioLogado, valorPagamento)) {
			musicasCarrinho = new ArrayList<Musica>();
			musicasCarrinho = populaMusicasCarrinho(musicasCarrinho);

			if(musicasCarrinho.size() > 1){
				List<File> arquivos = new ArrayList<File>();

				for (Musica m : musicasCarrinho) {
					File arquivo = new File(m.getCaminhoArquivoCliente());
					arquivos.add(arquivo);
				}

				compactaArquivos(arquivos);

				File arquivo = new File(
						"/home/inacio-medeiros/Music/cliente/musicasParaDownload.zip");
				DownloadFileHandler.downloadFile("espatifado_download.zip", arquivo, "application/zip",
						FacesContext.getCurrentInstance());
				arquivo.delete();	
			} else {
				File arquivo = new File(musicasCarrinho.get(0).getCaminhoArquivoCliente());
				DownloadFileHandler.downloadFile(musicasCarrinho.get(0).getNome() + ".mp3", arquivo, "audio/mpeg3",
						FacesContext.getCurrentInstance());
			}

			return "/pages/listMusicas.jsf";
		} else {
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	public List<Musica> populaMusicasCarrinho(List<Musica> musicas) {

		List<Musica> musicasAux = new ArrayList<Musica>();

		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		HttpServletRequest request = (HttpServletRequest) req;
		HttpSession session = (HttpSession) request.getSession();

		musicasAux = (List<Musica>) session.getAttribute("MUSICAS_CARRINHO");

		if (musicasAux == null) {
			return musicas;
		} else {
			return musicasAux;
		}
	}

	public void compactaArquivos(List<File> arquivos) {
		try {
			FileOutputStream fos = new FileOutputStream(
					"/home/inacio-medeiros/Music/cliente/musicasParaDownload.zip");

			ZipOutputStream zipOut = new ZipOutputStream(fos);

			for (File arq : arquivos) {
				zipOut.putNextEntry(new ZipEntry(arq.getName().toString()));

				FileInputStream fis = new FileInputStream(arq);

				int content;
				while ((content = fis.read()) != -1) {
					zipOut.write(content);
				}

				zipOut.closeEntry();

			}

			zipOut.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String visualizarMusicas() {
		return "/pages/listMusicas.jsf";
	}

	public String visualizarCarrinho() {
		return "/pages/carrinho.jsf";
	}

	public String trataJson(String json) {
		int tamanho = json.length();
		String novoJson = new String();
		if (json.charAt(0) == '\'' && json.charAt(tamanho - 1) == '\'') {
			novoJson = json;
			novoJson = json.replace("'[", "[");
			novoJson = novoJson.replace("]'", "]");
			return novoJson;
		} else {
			return json;
		}
	}

	public String getMusicasCarrinhoJson() {
		String json = new String();

		List<Musica> musicasAux = new ArrayList<Musica>();

		musicasAux = populaMusicasCarrinho(musicasAux);

		json = JSONProcessor.toJSON(musicasAux);
		json = trataJson(json);

		return json;
	}

	public double getValorTotalCompra() {
		List<Musica> musicasAux = new ArrayList<Musica>();

		musicasAux = populaMusicasCarrinho(musicasAux);

		double valor = 0;

		if (musicasAux != null) {
			for (Musica m : musicasAux) {
				valor += m.getPreco();
			}
		}

		return valor;
	}

	public Usuario getUsuarioLogado() {
		Usuario usuarioLogado = new Usuario();

		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		HttpServletRequest request = (HttpServletRequest) req;
		HttpSession session = (HttpSession) request.getSession();

		usuarioLogado = (Usuario) session.getAttribute("USUARIO_LOGADO");

		return usuarioLogado;
	}
}
