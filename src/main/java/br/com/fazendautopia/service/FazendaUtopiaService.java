package br.com.fazendautopia.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import com.google.gson.Gson;

import br.com.fazendautopia.dao.UnidadeMedidaDAO;
import br.com.fazendautopia.domain.Pedido;
import br.com.fazendautopia.domain.UnidadeMedida;

// http://localhost:8080/fazendautopia_3/rest/fazendautopia
@Path("fazendautopia")
public class FazendaUtopiaService {

//	// @GET
//	public String exibir() {
//		return "Curso de Java";
//	}

	@GET
	public String gerarlista() {
		UnidadeMedidaDAO unidadeMedidasDao = new UnidadeMedidaDAO();
		List<UnidadeMedida> unidades = unidadeMedidasDao.listar();

		Gson gson = new Gson();
		String json = gson.toJson(unidades);

		return json;
	}

//	@POST
//	public String salvarpedido(String dados) {
//		Gson gson = new Gson();
//
//		String saida = gson.toJson(dados);
//		return saida;
//
//	}

}
