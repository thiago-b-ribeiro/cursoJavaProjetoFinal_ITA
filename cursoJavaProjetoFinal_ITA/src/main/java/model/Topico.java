package model;

public class Topico {
	
	private int idTopico;
	private String titulo;
	private String conteudo;
	private String topicoLogin;
	
	public Topico() {
		// TODO Auto-generated constructor stub
	}

	public Topico(int idTopico, String titulo, String conteudo, String topicoLogin) {
		super();
		this.idTopico = idTopico;
		this.titulo = titulo;
		this.conteudo = conteudo;
		this.topicoLogin = topicoLogin;
	}

	public Topico(String titulo, String conteudo, String topicoLogin) {
		super();
		this.titulo = titulo;
		this.conteudo = conteudo;
		this.topicoLogin = topicoLogin;
	}
	
	public Topico(String titulo, String conteudo, Object topicoLogin) {
		super();
		this.titulo = titulo;
		this.conteudo = conteudo;
		this.topicoLogin = (String) topicoLogin;
	}

	public int getIdTopico() {
		return idTopico;
	}

	public void setIdTopico(int idTopico) {
		this.idTopico = idTopico;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public String getTopicoLogin() {
		return topicoLogin;
	}

	public void setTopicoLogin(String topicoLogin) {
		this.topicoLogin = topicoLogin;
	}
	
	

}
