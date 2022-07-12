package br.com.juan.model;

public class Palavra {
	private Integer id;
	private String content;
	
	public Palavra() {
		super();
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
