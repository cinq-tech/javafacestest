package br.com.javafacestest.rest;

import java.util.List;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.LoggingFilter;

import br.com.javafacestest.model.Album;

public class AlbumREST {
	
    private Client client;
    private WebResource webResource;

    public AlbumREST() {
        ClientConfig clientConfig = new DefaultClientConfig(GensonProvider.class);
        client = Client.create(clientConfig);
        client.addFilter(new LoggingFilter(System.out));
        webResource = client.resource("https://jsonplaceholder.typicode.com/albums");
    }

    public List<Album> listar() {
        return webResource.path("albums").get(new GenericType<List<Album>>() {});
    }

}
