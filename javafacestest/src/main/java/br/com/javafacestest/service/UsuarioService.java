package br.com.javafacestest.service;

import java.util.List;

import br.com.javafacestest.model.Usuario;

public interface UsuarioService {

	public Usuario salvar(Usuario usuario);
	
	public Usuario atualizar(Usuario usuario);
	
	public Usuario obter(String email);
	
	public void remover(Usuario usuario);
	
	public List<Usuario> listar();
	
	public Usuario login(String email, String senha);
	
}
