package br.com.fazendautopia.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.google.gson.Gson;

import br.com.fazendautopia.dao.ItensDAO;
import br.com.fazendautopia.domain.Itens;

@Path("item")
public class ItensService {
	@GET
	public String Lista() {
		ItensDAO dao = new ItensDAO();
		List<Itens> itens = dao.listar();
		Gson gson = new Gson();
		String json = gson.toJson(itens);
		return json;
	}

	@GET
	@Path("{codigoBusca}")
	public String buscarPorCod(@PathParam("codigoBusca") Long codigo) {
		ItensDAO dao = new ItensDAO();
		Itens iten = dao.Buscar(codigo);
		Gson gson = new Gson();
		String json = gson.toJson(iten);
		return json;
	}

	@POST
	public String salvar(String json) {
		Gson gson = new Gson();
		Itens itens = gson.fromJson(json, Itens.class);
		System.out.println(itens);
		ItensDAO dao = new ItensDAO();
		itens = dao.merge(itens);

		String jsonSaida = gson.toJson(itens);
		System.out.println(jsonSaida);
		Long cod = itens.getCodigo();
		return cod.toString();

	}

	@DELETE
	@Path("{codigoBusca}")
	public String excluir(@PathParam("codigoBusca") Long codigo) {
		ItensDAO dao = new ItensDAO();
		Itens iten = dao.Buscar(codigo);
		dao.excluir(iten);
		Gson gson = new Gson();
		String json = gson.toJson(iten);
		return json;
	}
	

	@PUT
	@Path("{codigoBusca}")
	public String editar(@PathParam("codigoBusca") Long codigo, String json) {
		Gson gson = new Gson();
		ItensDAO dao = new ItensDAO();
		Itens itenEditado = gson.fromJson(json, Itens.class);
		Itens iten = dao.Buscar(codigo);
		iten = dao.merge(itenEditado);
		String jsonSaida = gson.toJson(iten);
		return jsonSaida;
	}
}
