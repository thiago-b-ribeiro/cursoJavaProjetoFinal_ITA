package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

public class DAO {
	
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/areadetestes04?Timezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "Recomeco137!";
	
	public DAO() {
		// TODO Auto-generated constructor stub
	}
	
	private Connection conectar() {
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,user,password);
			System.out.println("Conexão realizada com sucesso.");
			return con;
		} catch (Exception e) {
			System.out.println("Falha na conexão ao BD: " + e);
			return null;
		}
	}
	
	public void cadastrarUsuario(Usuario usuario) {
		String sql = "INSERT INTO areadetestes04.usuario(login, email, nome, senha, pontos) VALUES(?,?,?,?,0)";
		
		try {
			Connection con = conectar();
			
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, usuario.getLogin());
			pst.setString(2, usuario.getEmail());
			pst.setString(3, usuario.getNome());
			pst.setString(4, usuario.getSenha());
			pst.executeUpdate();
	
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public Usuario consultarUsuario (String loginConsulta) {
		String sql = "SELECT * FROM areadetestes04.usuario WHERE login = ?";
		Usuario usuario = null;
		
		try {
			Connection con = conectar();
			
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, loginConsulta);
			ResultSet rs = pst.executeQuery();
			
			if(rs != null) {
				while(rs.next()) {
					String login = rs.getString("login");
					String email = rs.getString("email");
					String nome = rs.getString("nome");
					String senha = rs.getString("senha");
					int pontos = rs.getInt("pontos");
					
					usuario = new Usuario(login, email, nome, senha, pontos);
				} 
			} else {
				return usuario;
			}
			
			return usuario;			
		
		} catch (Exception e) {
			System.out.println(e);
			return usuario;
		}
	}
	
	public ArrayList<Usuario> rankearUsuario (){
		String sql = "SELECT * FROM areadetestes04.usuario ORDER BY pontos";
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		try {
			Connection con = conectar();
			
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String login = rs.getString("login");
				String email = rs.getString("email");
				String nome = rs.getString("nome");
				String senha = rs.getString("senha");
				int pontos = rs.getInt("pontos");
				
				usuarios.add(new Usuario(login, email, nome, senha, pontos));
			}
			
			return usuarios;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public void inserirTopico(Topico topico) {
		String sql = "INSERT INTO areadetestes04.topico(titulo, conteudo, topico_login) VALUES (?,?,?)";
		
		try {
			Connection con = conectar();
			
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, topico.getTitulo());
			pst.setString(2, topico.getConteudo());
			pst.setString(3, topico.getTopicoLogin());
			pst.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public ArrayList<Topico> consultarTopicos (Object login){
		String sql = "SELECT * FROM areadetestes04.topico WHERE topico_login=?";
		ArrayList<Topico> topicos = new ArrayList<Topico>();
		
		try {
			Connection con = conectar();
			
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setObject(1, login);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				int id_topico = rs.getInt("id_topico");
				String titulo = rs.getString("titulo");
				String conteudo = rs.getString("conteudo");
				String topico_login = rs.getString("topico_login");
				
				topicos.add(new Topico(id_topico, titulo, conteudo, topico_login));
			}
			return topicos;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	
	public Topico exibirTopico(Object idTopico) {
		String sql = "SELECT * FROM areadetestes04.topico WHERE id_topico = ?";
		Topico topico = new Topico();
		
		try {
			Connection con = conectar();
			
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setObject(1, idTopico);
			ResultSet rs = pst.executeQuery();
			
			if (rs!=null) {
				while(rs.next()) {
					int id_Topico = rs.getInt("id_topico");
					String titulo = rs.getString("titulo");
					String conteudo = rs.getString("conteudo");
					String topico_login = rs.getString("topico_login");
					
					topico = new Topico(id_Topico, titulo, conteudo, topico_login);
				}
				return topico;
			}
		} catch (Exception e) {
			System.out.println(e);
			return topico;
		}
		
		return topico;
	}
	
	public void inserirComentario(Comentario comentario) {
		String sql = "INSERT INTO areadetestes04.comentario (comentario, comentario_login, id_topico) VALUES(?, ?, ?)";
		
		try {
			Connection con = conectar();
			
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, comentario.getComentario());
			pst.setString(2, comentario.getComentarioLogin());
			pst.setInt(3, comentario.getIdTopico());
			pst.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public ArrayList<Comentario> consultarComentarios(int idTopico){
		String sql = "SELECT * FROM areadetestes04.comentario WHERE id_topico = ?";
		ArrayList<Comentario> comentarios = new ArrayList<>();
		
		try {
			Connection con = conectar();
			
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, idTopico);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				int idComentario = rs.getInt("id_comentario");
				String comentario = rs.getString("comentario");
				String comentarioLogin = rs.getString("comentario_login");
				int id_Topico = rs.getInt("id_topico");
				
				comentarios.add(new Comentario(idComentario, comentario, comentarioLogin, id_Topico));
			}
			
			return comentarios;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
