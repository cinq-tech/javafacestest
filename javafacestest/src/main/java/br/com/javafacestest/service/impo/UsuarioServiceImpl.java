package br.com.javafacestest.service.impo;

import java.util.List;

import br.com.javafacestest.model.Usuario;
import br.com.javafacestest.repository.UsuarioRepository;
import br.com.javafacestest.repository.impl.UsuarioRepositoryImpl;
import br.com.javafacestest.service.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService{

	private UsuarioRepository usuarioRepository;
	
	public UsuarioServiceImpl() {
		usuarioRepository = new UsuarioRepositoryImpl();
	}
	
	public Usuario salvar(Usuario usuario) {
		return usuarioRepository.salvar(usuario);
	}

	public Usuario obter(String email) {
		return usuarioRepository.obter(email);
	}

	public void remover(Usuario usuario) {
		usuarioRepository.remover(usuario);
	}

	public List<Usuario> listar() {
		return usuarioRepository.listar();
	}

}
