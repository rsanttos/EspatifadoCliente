package br.com.ufrn.bti.concorrente.espatifado.cliente.controle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.ufrn.bti.concorrente.espatifado.cliente.dominio.Usuario;
import br.com.ufrn.bti.concorrente.espatifado.cliente.servico.UsuarioService;

@ManagedBean
@SessionScoped
public class UsuarioMBean {
	
	private UsuarioService servicoUsuario;
	
	public UsuarioMBean(){
		this.servicoUsuario = new UsuarioService();
	}
	
	public String realizarLogin(){
		Usuario usuario = new Usuario();
		usuario.setLogin("boyinacio");
		usuario.setSenha("123");
		
		if(this.servicoUsuario.efetuarLogin(usuario)){
			return "/pages/listMusicas.jsf";	
		} else {
			return "/pages/login.jsf";	
		}
	}
}
