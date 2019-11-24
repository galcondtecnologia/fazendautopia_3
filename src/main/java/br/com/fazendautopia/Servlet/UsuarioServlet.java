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

		String userName = JSON.getString("nomeUsuario");
		System.out.println(userName);
		

//		JSON.getJSONArray("nomeUsuario");
//		System.out.println("Usuário >" + JSON.getJSONArray("nomeUsuario"));

//		UsuarioDAO dao = new UsuarioDAO();
//		Usuario usuario = new Usuario();
//
//		usuario.setEmail(eco);
//
//		dao.salvar(usuario);
//		System.out.println("Salvo com suses: " + usuario.getEmail());

		int indiceProdutoNumero = 0;
		String indiceProdutoString = "" + indiceProdutoNumero;
		int indiceItemNumero = 0;
		String indiceItemString = "" + indiceItemNumero;
		
		//Listando os produtos do pedido 
		try {
		while (JSON.getString("produto" + indiceProdutoString + "item" + indiceItemString) != null) {
			
			//Obter a descrição do produto / preco do produto / qtd de item por produto
			System.out.println(JSON.getString("produtodescricao" + indiceProdutoString));
			System.out.println(JSON.getString("produtopreco" + indiceProdutoString));
			System.out.println(JSON.getString("qtdItem" + indiceProdutoString));
			
			try {
				String item = JSON.getString("produto" + indiceProdutoString + "item" + indiceItemString);
				while (item != null || item != "") {
					
					//Imprime cada item do produto ------------------
					System.out.println(item);
					//CODIGO PARA INCREMENTAR CADA PRODUTO EM UM ARRAY AQUI ------------

					item = JSON.getString("produto" + indiceProdutoString + "item" + indiceItemString);
					indiceItemNumero++;
					indiceItemString = "" + indiceItemNumero;
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("-------------------------------------------------------");
				System.out.println("Não encontrado o produto: " + "produto" + indiceProdutoString + "item" + indiceItemString);
				//Reiniciar o indice de itens 
				indiceItemNumero = 0;
				indiceItemString = "" + indiceItemNumero;
			}
			indiceProdutoNumero++;
			indiceProdutoString = "" + indiceProdutoNumero;
		}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Não encontrado o produto: " + "produto" + indiceProdutoString + "item" + indiceItemString);
		}
	}

}
