package br.com.fazendautopia.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

// http://localhost:8080/fazendautopia_3/rest/fazendautopia
@Path("fazendautopia")
public class FazendaUtopiaService {
	@GET
	public String exibir() {
		return "Curso de Java";
	}

}
