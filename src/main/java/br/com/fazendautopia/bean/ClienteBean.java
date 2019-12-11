package br.com.fazendautopia.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.fazendautopia.dao.ClienteDAO;
import br.com.fazendautopia.domain.Cliente;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ClienteBean implements Serializable {

	private Cliente cliente;
	private List<Cliente> clientes;

	@PostConstruct
	public void listar() {
		ClienteDAO dao = new ClienteDAO();
		clientes = dao.listar();
		try {
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os Clientes!");
			e.printStackTrace();

		}

	}

	public void novo() {
		cliente = new Cliente();
	}

	public void salvar() {

		try {

			ClienteDAO dao = new ClienteDAO();
			dao.merge(cliente);

			cliente = new Cliente();

			ClienteDAO dao2 = new ClienteDAO();
			clientes = dao2.listar();

			Messages.addGlobalInfo("Cliente salvo com sucesso!");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o Cliente!");
			e.printStackTrace();

		}

	}

	public void excluir(ActionEvent evento) {
		try {
			Messages.addGlobalInfo("CategoriaCesta removida com sucesso!");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar excluir a categoriaCesta!");
			e.printStackTrace();

		}
	}

	public void editar(ActionEvent evento) {
		try {
			Messages.addGlobalInfo("CategoriaCesta alterada com sucesso!");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar alterar a categoriaCesta! " + e);
			e.printStackTrace();

		}
	}
}
