package br.com.ufrn.bti.concorrente.espatifado.cliente.controle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.ufrn.bti.concorrente.espatifado.cliente.dominio.Usuario;
import br.com.ufrn.bti.concorrente.espatifado.cliente.servico.UsuarioService;

@ManagedBean
@SessionScoped
public class UsuarioMBean {
	
	private UsuarioService servicoUsuario;
	
	private Usuario usuario;
	
	public UsuarioMBean(){
		this.usuario = new Usuario();
		this.servicoUsuario = new UsuarioService();
	}
	
	public String realizarLogin(){
		
		if(this.servicoUsuario.efetuarLogin(usuario)){
			return "/pages/listMusicas.jsf";	
		} else {
			return "/pages/login.jsf";	
		}
	}
	
	public String login(){
		return "/pages/login.jsf";
	}

	public UsuarioService getServicoUsuario() {
		return servicoUsuario;
	}

	public void setServicoUsuario(UsuarioService servicoUsuario) {
		this.servicoUsuario = servicoUsuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
