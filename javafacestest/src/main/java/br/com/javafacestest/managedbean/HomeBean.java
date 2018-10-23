package br.com.javafacestest.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.annotation.PostConstruct;

@ManagedBean
@ViewScoped
public class HomeBean {

	private String mensagem;

	@PostConstruct
    public void init() {
		mensagem = "Java Faces Test";
    }

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
}
