package br.com.javafacestest.repository.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

	public Usuario obter(String email) {
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
