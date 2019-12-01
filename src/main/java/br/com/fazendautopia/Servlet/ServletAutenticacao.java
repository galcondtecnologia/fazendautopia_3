package br.com.fazendautopia.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fazendautopia.dao.UsuarioDAO;
import br.com.fazendautopia.domain.Usuario;

@WebServlet("/pages/ServletAutenticacao")
public class ServletAutenticacao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletAutenticacao() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println(request.getParameter("deslogar"));
		if (Boolean.parseBoolean(request.getParameter("deslogar"))) {
			HttpServletRequest req = (HttpServletRequest) request;

			HttpSession session = req.getSession();
			session.invalidate();

			response.sendRedirect("../index.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UsuarioDAO dao = new UsuarioDAO();
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String url = request.getParameter("url");
		if (email.equalsIgnoreCase("admin") && senha.equalsIgnoreCase("admin")) {

			Usuario userLogado = new Usuario();
			userLogado.setEmail(email);
			userLogado.setSenha(senha);

			// adciona o usuario na session
			HttpServletRequest req = (HttpServletRequest) request;

			HttpSession session = req.getSession();
			session.setAttribute("usuario", userLogado);

			// redireciona para o sistema e altoriaza o uusario
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");

			dispatcher.forward(request, response);
		}

	}

}
