package br.com.fazendautopia.Servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.engine.transaction.jta.platform.internal.JOnASJtaPlatform;
import org.primefaces.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import br.com.fazendautopia.dao.UsuarioDAO;
import br.com.fazendautopia.domain.Pedido;
import br.com.fazendautopia.domain.Usuario;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet(value = "/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	List<Pedido> pedidos = new LinkedList<Pedido>();
	Gson gson = new Gson();

	public UsuarioServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));

		String Json = "";

		if (br != null) {
			Json = br.readLine();
			System.out.println(Json);
		}
		JSONObject JSON = new JSONObject(Json);
		
//		String eco = JSON.getString("produtos");
		
		JSON.getJSONArray("produtos");
		System.out.println("ECO >" + JSON.getJSONArray("produtos"));

//		UsuarioDAO dao = new UsuarioDAO();
//		Usuario usuario = new Usuario();
//
//		usuario.setEmail(eco);
//
//		dao.salvar(usuario);
//		System.out.println("Salvo com suses: " + usuario.getEmail());

//		int i = 0;
//
//		String str = "" + i;
//
//		while (i < eco.length()) {
//			System.out.println(eco + i);
//			i++;
//		}

//		while (request.getParameter("email" + str) != null) {
//			System.out.println(request.getParameter("email" + str));
//			i++;
//			str = "" + i;
//		}

	}

}
