package br.com.javafacestest.repository.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.com.javafacestest.model.Usuario;
import br.com.javafacestest.repository.UsuarioRepository;
import br.com.javafacestest.util.ArquivoUtil;

public class UsuarioRepositoryImpl implements UsuarioRepository{

	private ArquivoUtil arquivoUtil;
	private Gson gson = null;
	private TypeToken<List<Usuario>> token = null;
	
	public UsuarioRepositoryImpl(){
		arquivoUtil = ArquivoUtil.getInstancia();
		gson = new Gson();
		token = new TypeToken<List<Usuario>>() {};
	}
	
	public Usuario salvar(Usuario usuario){
		
		try {
			
			List<Usuario> usuarios = this.listar();
			usuarios.add(usuario);
			arquivoUtil.gravar(gson.toJson(usuarios));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return usuario;
		
	}
	
	public Usuario atualizar(Usuario usuarioAtualizar) {
		
		try {
			
			List<Usuario> usuarios = this.listar();
			
			usuarios.stream()
					.filter(usuario -> usuario.getEmail().equals(usuarioAtualizar.getEmail()))
					.forEach(u -> {
						u.setNome(usuarioAtualizar.getNome());
						u.setSenha(usuarioAtualizar.getSenha());
					});
							
			arquivoUtil.gravar(gson.toJson(usuarios));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return usuarioAtualizar;
	}

	public Optional<Usuario> obter(String email) {
		
		try {
			
			List<Usuario> usuarios = this.listar();
			
			return usuarios.stream().filter(usuario -> usuario.getEmail().equals(email)).findFirst();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public void remover(Usuario usuario) {
		
	}

	public List<Usuario> listar() {
		
		List<Usuario> usuarios = null;
		
		try {
			
			String jsonUsuarios = arquivoUtil.ler();
					
			if(jsonUsuarios != null) {
				usuarios = gson.fromJson(jsonUsuarios, token.getType());
			}else {
				usuarios = new ArrayList<>();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return usuarios;
	}
	

}
