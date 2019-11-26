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

/**
 * Servlet implementation class ServletAutenticacao
 */
@WebServlet("/pages/ServletAutenticacao")
public class ServletAutenticacao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletAutenticacao() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UsuarioDAO dao = new UsuarioDAO();
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		if (email.equalsIgnoreCase("admin") && senha.equalsIgnoreCase("admin")) {

			Usuario userLogado = new Usuario();
			userLogado.setEmail(email);
			userLogado.setSenha(senha);

			// adciona o usuario na session
			HttpServletRequest req = (HttpServletRequest) request;

			HttpSession session = req.getSession();
			session.setAttribute("usuario", userLogado);

			// redireciona para o sistema e altoriaza o uusario
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.xhtml");
			dispatcher.forward(request, response);
		} else {

			RequestDispatcher dispatcher = request.getRequestDispatcher("/loginTeste.xhtml");
			dispatcher.forward(request, response);
		}

	}

}
