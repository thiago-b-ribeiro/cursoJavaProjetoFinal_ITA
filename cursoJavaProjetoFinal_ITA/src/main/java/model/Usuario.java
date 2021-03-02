package model;

public class Usuario {
	
	private String login;
	private String email;
	private String nome;
	private String senha;
	private int pontos;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	public Usuario(String login, String email, String nome, String senha, int pontos) {
		super();
		this.login = login;
		this.email = email;
		this.nome = nome;
		this.senha = senha;
		this.pontos = pontos;
	}

	public Usuario(String login, String email, String nome, String senha) {
		super();
		this.login = login;
		this.email = email;
		this.nome = nome;
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	
	public boolean validarUsuario (String login, String senha) {
		DAO dao = new DAO();
		Usuario usuario = dao.consultarUsuario(login);
		
		if (usuario !=null && usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
			return true;
		} else {
			return false;
		}
	}

}
