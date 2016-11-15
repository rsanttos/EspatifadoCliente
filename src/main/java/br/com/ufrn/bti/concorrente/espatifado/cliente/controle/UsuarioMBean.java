package br.com.ufrn.bti.concorrente.espatifado.cliente.controle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class UsuarioMBean {
	
	public UsuarioMBean(){
		
	}
	
	public String realizarLogin(){
		return "/pages/listMusicas.jsf";
	}
}
