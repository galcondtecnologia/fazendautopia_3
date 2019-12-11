package br.com.fazendautopia.DaoTeste;

import org.junit.Test;

import br.com.fazendautopia.dao.ClienteDAO;
import br.com.fazendautopia.dao.RegiaoDAO;
import br.com.fazendautopia.dao.UsuarioDAO;
import br.com.fazendautopia.domain.Cliente;
import br.com.fazendautopia.domain.Regiao;
import br.com.fazendautopia.domain.Usuario;

public class ClienteDAOTest {

	@Test
	public void salvar() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.Buscar(3L);

		RegiaoDAO regiaoDAO = new RegiaoDAO();
		Regiao regiao = regiaoDAO.Buscar(1L);

		Cliente cliente = new Cliente();
		cliente.setTelefone("999999999");
		cliente.setUsuario(usuario);
		cliente.setNome("Sebastião Firmino");
		cliente.setCep("75535-260");
		cliente.setCidade("Itumbira");
		cliente.setEstado("GO");
		cliente.setCodIbge("5252877");
		cliente.setRegiao(regiao);
		cliente.setAvisoRegiao(true);
		ClienteDAO dao = new ClienteDAO();
		dao.salvar(cliente);

		System.out.println("Cliente salvo com sucesso: " + cliente);

	}

}
