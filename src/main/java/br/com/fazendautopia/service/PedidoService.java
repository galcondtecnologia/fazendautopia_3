package br.com.fazendautopia.service;

import java.util.Date;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.google.gson.Gson;

import br.com.fazendautopia.dao.PedidoDAO;
import br.com.fazendautopia.domain.Pedido;

@Path("pedido")
public class PedidoService {
	// http://localhost:8080/fazendautopia_3/rest/pedido
	@GET
	public String gerarLista() {
		PedidoDAO dao = new PedidoDAO();
		List<Pedido> pedidos = dao.listar();
		Gson gson = new Gson();
		String json = gson.toJson(pedidos);

		return json;
	}

	// http://localhost:8080/fazendautopia_3/rest/pedido/10
	@GET
	@Path("{codigoBusca}")
	public String buscar(@PathParam("codigoBusca") Long codigo) {
		PedidoDAO dao = new PedidoDAO();
		Pedido pedido = dao.Buscar(codigo);
		Gson gson = new Gson();
		String json = gson.toJson(pedido);
		return json;
	}

	// http://localhost:8080/fazendautopia_3/rest/pedido
	@POST
	public String salvar(String json) {
		Gson gson = new Gson();
		Pedido pedido = gson.fromJson(json, Pedido.class);

		PedidoDAO dao = new PedidoDAO();
		pedido.setDataeHora(new Date());
		pedido = dao.merge(pedido);

		String jsonSaida = gson.toJson(pedido);
		
		System.out.println(jsonSaida);
		// retornar o objeto ou o codigo 200
		return jsonSaida;

	}

	// http://localhost:8080/fazendautopia_3/rest/pedido
//	@PUT
	public String editar(String json) {
		Gson gson = new Gson();
		Pedido pedido = gson.fromJson(json, Pedido.class);

		PedidoDAO dao = new PedidoDAO();
		dao.editar(pedido);

		String jsonSaida = gson.toJson(pedido);
		// retornar o objeto ou o codigo 200
		return jsonSaida;

	}

	// http://localhost:8080/fazendautopia_3/rest/pedido/{codigo}
	@DELETE
	@Path("{codigoBusca}")
	public String excluir(@PathParam("codigo") Long codigo) {

		PedidoDAO dao = new PedidoDAO();

		Pedido pedido = dao.Buscar(codigo);
		dao.excluir(pedido);
		Gson gson = new Gson();
		String jsonSaida = gson.toJson(pedido);

		return jsonSaida;

	}

}
