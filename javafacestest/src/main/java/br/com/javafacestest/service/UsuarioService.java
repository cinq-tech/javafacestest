package br.com.javafacestest.service;

import java.util.List;
import java.util.Optional;

import br.com.javafacestest.model.Usuario;

public interface UsuarioService {

	public Usuario salvar(Usuario usuario);
	
	public Optional<Usuario> obter(String email);
	
	public void remover(Usuario usuario);
	
	public List<Usuario> listar();
}
