package br.com.javafacestest.managedbean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.javafacestest.model.Usuario;
import br.com.javafacestest.seguranca.SessionContext;
import br.com.javafacestest.service.UsuarioService;
import br.com.javafacestest.service.impo.UsuarioServiceImpl;

@ManagedBean
@SessionScoped
public class LoginBean {

	private UsuarioService usuarioService;

	private String email;
	private String senha;

	@PostConstruct
	public void init() {
		setUsuarioService(new UsuarioServiceImpl());
	}

	public Usuario getUsuarioLogado() {
		return (Usuario) SessionContext.getInstance().getUsuarioLogado();
	}

	public String doLogin() {
		try {

			Usuario usuario = getUsuarioService().login(email, senha);

			if (usuario == null) {
				return "";
			}

			SessionContext.getInstance().setAttribute("usuarioLogado", usuario);
			return "/restrito/index.xhtml?faces-redirect=true";

		} catch (Exception e) {
			System.out.println(e.getMessage());
			FacesContext.getCurrentInstance().validationFailed();
			e.printStackTrace();
			return "";
		}

	}

	public String doLogout() {
		SessionContext.getInstance().encerrarSessao();
		return "/login.xhtml?faces-redirect=true";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

}
