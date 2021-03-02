package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Comentario;
import model.DAO;
import model.Topico;
import model.Usuario;

@WebServlet(urlPatterns = {"/cadastrarUsuario", "/validarUsuario", "/inserirTopico", "/consultarTopicos", "/exibirTopico", "/inserirComentario", "/rankearUsuarios" })
public class ServletPrimaria extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DAO dao = new DAO();

	public ServletPrimaria() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {

		switch (request.getServletPath()) {
		case "/cadastrarUsuario":
			cadastrarUsuario(request, response);
			break;
		case "/validarUsuario":
			validarUsuario(request, response);
			break;
		case "/inserirTopico":
			inserirTopico(request, response);
			break;
		case "/consultarTopicos":
			consultarTopicos(request, response);
			break;
		case "/inserirComentario":
			inserirComentario(request, response);
			break;
		case "/rankearUsuarios":
			rankearUsuarios(request, response);
		break;
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		switch (request.getServletPath()) {
		case "/exibirTopico":
			exibirTopico(request, response);
			break;
		}		
	}

	protected void cadastrarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = new Usuario(request.getParameter("login"), request.getParameter("email"), request.getParameter("nome"), request.getParameter("senha"));
		dao.cadastrarUsuario(usuario);
		response.sendRedirect("index.jsp");
	}
	
	protected void validarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (new Usuario().validarUsuario(request.getParameter("login"), request.getParameter("senha"))) {
			request.getSession().setAttribute("login", request.getParameter("login"));
			request.getRequestDispatcher("consultarTopicos").forward(request, response);
		} else {
			request.setAttribute("falhaAcesso", "Login/senha estão errados ou não foram cadastrados.");
			response.sendRedirect("index.jsp");
		}
	}
	
	protected void inserirTopico(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Topico topico = new Topico(request.getParameter("titulo"), request.getParameter("conteudo"), request.getSession().getAttribute("login"));
		dao.inserirTopico(topico);
		consultarTopicos(request, response);
	}

	protected void consultarTopicos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Topico> topicos = dao.consultarTopicos(request.getSession().getAttribute("login"));
		request.setAttribute("topicos", topicos);		
		request.getRequestDispatcher("jsp/topicos.jsp").forward(request, response);
	}
	
	protected void exibirTopico (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Topico topico = dao.exibirTopico(request.getParameter("idTopico"));
		request.setAttribute("topicos", topico);
		consultarComentario(request, response);
		request.getRequestDispatcher("jsp/exibeTopico.jsp").forward(request, response);
	}
	
	protected void inserirComentario (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Comentario comentario = new Comentario(request.getParameter("comentario"), request.getSession().getAttribute("login"), Integer.parseInt(request.getParameter("idTopico")));
		dao.inserirComentario(comentario);
		exibirTopico(request, response);
	}
	
	protected void consultarComentario (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Comentario> comentarios = dao.consultarComentarios(Integer.parseInt(request.getParameter("idTopico")));
		request.setAttribute("comentarios", comentarios);
	}
	
	protected void rankearUsuarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Usuario> usuarios = dao.rankearUsuario();
		request.setAttribute("usuarios", usuarios);
		request.getRequestDispatcher("jsp/ranking.jsp").forward(request, response);
	}
	
}
