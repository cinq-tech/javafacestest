package br.com.javafacestest.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.javafacestest.model.Usuario;
import br.com.javafacestest.service.UsuarioService;
import br.com.javafacestest.service.impo.UsuarioServiceImpl;

public class UsuarioTest {

	private UsuarioService usuarioService = null;
	
	@Before
	public void init() {
		usuarioService = new UsuarioServiceImpl();
	}
	
	@Test
	public void cadastrarUsuario() {
		
		List<Usuario> usuariosAnteriorInsercao = usuarioService.listar();
		List<Usuario> usuariosAposInsercao = null;
		
		Usuario usuario = new Usuario("Diego", "diego@gmail.com", "123");
		usuarioService.salvar(usuario);
		
		usuariosAposInsercao = usuarioService.listar();
		
		Assert.assertEquals(usuariosAposInsercao.size(), usuariosAnteriorInsercao.size() + 1);
		
	}
	
	@Test
	public void obterUsuario() {
		
		Usuario usuario = usuarioService.obter("thiago@gmail.com");
		Assert.assertEquals(usuario.getEmail(), "thiago@gmail.com");
		
	}
	
	@Test
	public void atualizarUsuario() {
		
		Usuario usuarioOriginal = usuarioService.obter("thiago@gmail.com");
		
		usuarioOriginal.setNome("Lucas");
		usuarioOriginal.setSenha("222");
		usuarioOriginal = usuarioService.atualizar(usuarioOriginal);
		
		Usuario usuarioAtualizado = usuarioService.obter("thiago@gmail.com");
		
		Assert.assertEquals(usuarioAtualizado.getNome(), usuarioOriginal.getNome());
		Assert.assertEquals(usuarioAtualizado.getSenha(), usuarioOriginal.getSenha());
		
	}
		
}
