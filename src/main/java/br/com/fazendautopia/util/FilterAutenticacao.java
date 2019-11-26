package br.com.fazendautopia.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.fazendautopia.domain.Usuario;

/**
 * Servlet Filter implementation class FilterAutenticacao
 */
@WebFilter(urlPatterns = { "/pages/confirmacao-pedidos.xhtml" })
public class FilterAutenticacao implements Filter {

	/**
	 * Default constructor.
	 */
	public FilterAutenticacao() {
		// TODO Auto-generated constructor stub
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		// intercepta a sessao
		HttpSession session = req.getSession();
		// inteceptar o usuario da Sessao
		// retorna nulo caso nao esteja logado
		Usuario userlogado = (Usuario) session.getAttribute("usuario");

		if (userlogado == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/loginTeste.xhtml");
			dispatcher.forward(request, response);
			return;
		}
		// executa as acoes do resquest e response
		chain.doFilter(request, response);

		System.out.println("Precisa ser logado");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
