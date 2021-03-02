package model;

public class Comentario {
	
	private int idComentario;
	private String comentario;
	private String comentarioLogin;
	private int idTopico;
	
	public Comentario() {
		// TODO Auto-generated constructor stub
	}

	public Comentario(int idComentario, String comentario, String comentarioLogin, int idTopico) {
		super();
		this.idComentario = idComentario;
		this.comentario = comentario;
		this.comentarioLogin = comentarioLogin;
		this.idTopico = idTopico;
	}
	
	public Comentario(String comentario, Object comentarioLogin, int idTopico) {
		super();
		this.comentario = comentario;
		this.comentarioLogin = (String) comentarioLogin;
		this.idTopico = idTopico;
	}

	public int getIdComentario() {
		return idComentario;
	}

	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getComentarioLogin() {
		return comentarioLogin;
	}

	public void setComentarioLogin(String comentarioLogin) {
		this.comentarioLogin = comentarioLogin;
	}

	public int getIdTopico() {
		return idTopico;
	}

	public void setIdTopico(int idTopico) {
		this.idTopico = idTopico;
	}
	
	

}
