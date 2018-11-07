package br.com.javafacestest.model;

import com.owlike.genson.annotation.JsonIgnore;
import com.owlike.genson.annotation.JsonProperty;

public class Album {

	@JsonProperty("userId")
	private String userId;
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("id")
	private String title;
	
	@JsonProperty("Body")
    private String body;
	
	public Album() {

	}
	
	@JsonIgnore
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@JsonIgnore
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@JsonIgnore
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@JsonIgnore
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    
}
