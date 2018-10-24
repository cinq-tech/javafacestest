package br.com.javafacestest.test;

import java.util.List;
import java.util.Optional;

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
	
	//@Test
	public void cadastrarUsuario() {
		
		List<Usuario> usuariosAnteriorInsercao = usuarioService.listar();
		List<Usuario> usuariosAposInsercao = null;
		
		Usuario usuario = new Usuario("Thiago", "thiago@gmail.com", "123");
		usuarioService.salvar(usuario);
		
		usuariosAposInsercao = usuarioService.listar();
		
		Assert.assertEquals(usuariosAposInsercao.size(), usuariosAnteriorInsercao.size() + 1);
		
	}
	
	@Test
	public void obterUsuario() {
		
		Optional<Usuario> optUsuario = usuarioService.obter("thiago@gmail.com");
		Usuario usuario = optUsuario.get();
		Assert.assertEquals(usuario.getEmail(), "thiago@gmail.com");
		
	}
		
}
