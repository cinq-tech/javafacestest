package br.com.javafacestest.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.javafacestest.model.Album;
import br.com.javafacestest.rest.AlbumREST;
import br.com.javafacestest.view.util.JSFUtil;

@ManagedBean
@ViewScoped
public class AlbumBean implements Serializable{

	private static final long serialVersionUID = -1187472108637196965L;

	private List<Album> albuns;
	private AlbumREST rest;
	
	@PostConstruct
	public void init() {
		
		try {
			
			rest = new AlbumREST();
			setAlbuns(rest.listar());
			
		} catch (Exception e) {
			JSFUtil.tratarExcecao(e);
		}
		
	}
	
	public AlbumBean(){
		
		try {
			
		} catch (Exception e) {
			JSFUtil.tratarExcecao(e);
		}
	}

	public List<Album> getAlbuns() {
		return albuns;
	}

	public void setAlbuns(List<Album> albuns) {
		this.albuns = albuns;
	}
	
}
