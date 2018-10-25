package br.com.javafacestest.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.javafacestest.model.Usuario;
import br.com.javafacestest.seguranca.SessionContext;
import br.com.javafacestest.service.UsuarioService;
import br.com.javafacestest.service.impo.UsuarioServiceImpl;
import br.com.javafacestest.view.util.JSFUtil;

@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable{

	private static final long serialVersionUID = 1673622671234420111L;

	private UsuarioService usuarioService;
	
	private List<Usuario> usuarios;
	
	private Usuario usuarioCadastro = new Usuario();
	private Usuario usuarioRemocao = new Usuario();
	private Boolean erroValidacao;
	
	private Usuario usuarioLogado;
	
	@PostConstruct
	public void init() {
		
		try {
			
			usuarioService = new UsuarioServiceImpl();
			usuarios = usuarioService.listar();
			usuarioLogado = SessionContext.getInstance().getUsuarioLogado();
			
			System.out.println(usuarioLogado);
			
			erroValidacao = Boolean.FALSE;
			
		} catch (Exception e) {
			JSFUtil.tratarExcecao(e);
		}
		
	}
	
	public UsuarioBean(){
		
		try {
			
		} catch (Exception e) {
			JSFUtil.tratarExcecao(e);
		}
	}
	
	public void resetForm(){
		
		try {

			usuarioCadastro = new Usuario();
			erroValidacao = Boolean.FALSE;
			
		} catch (Exception e) {
			JSFUtil.tratarExcecao(e);
		}
	}
	
	public void cadastrarUsuario() {
		
		try {
			
			usuarioService.salvar(usuarioCadastro);
			usuarios = usuarioService.listar();
			resetForm();
			
			JSFUtil.addInfoMessage("Usuário cadastrado com sucesso");
			
		} catch (Exception e) {
			JSFUtil.tratarExcecao(e);
		}
		
	}
	
	public void selecionarUsuarioRemocao(Usuario usuarioRemocaoSelecionado) {
		usuarioRemocao = usuarioRemocaoSelecionado;
	}
	
	public void removerUsuario() {
		
		try {
			
			if(!usuarioRemocao.equals(usuarioLogado)) {
				usuarioService.remover(usuarioRemocao);
				usuarios = usuarioService.listar();
			}else {
				JSFUtil.addErrorMessage("Você não pode remover o seu próprio usuário!");
			}
			
		} catch (Exception e) {
			JSFUtil.tratarExcecao(e);
		}
		
	}

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}


	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}


	public List<Usuario> getUsuarios() {
		return usuarios;
	}


	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario getUsuarioCadastro() {
		return usuarioCadastro;
	}

	public void setUsuarioCadastro(Usuario usuarioCadastro) {
		this.usuarioCadastro = usuarioCadastro;
	}

	public Boolean getErroValidacao() {
		return erroValidacao;
	}

	public void setErroValidacao(Boolean erroValidacao) {
		this.erroValidacao = erroValidacao;
	}

	public Usuario getUsuarioRemocao() {
		return usuarioRemocao;
	}

	public void setUsuarioRemocao(Usuario usuarioRemocao) {
		this.usuarioRemocao = usuarioRemocao;
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

}
