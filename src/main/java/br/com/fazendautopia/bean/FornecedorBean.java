package br.com.fazendautopia.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.fazendautopia.dao.FornecedorDAO;
import br.com.fazendautopia.domain.Fornecedor;
import br.com.fazendautopia.util.CepWebService;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class FornecedorBean implements Serializable {

	private Fornecedor fornecedor;
	private List<Fornecedor> fornecedores;

	@PostConstruct
	public void listar() {

		try {
			FornecedorDAO dao = new FornecedorDAO();
			fornecedores = dao.listar();
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar as Categoria Cestas!");
			e.printStackTrace();

		}

	}

	public void novo() {
		fornecedor = new Fornecedor();
	}

	public void salvar() {

		try {

			FornecedorDAO dao = new FornecedorDAO();
			dao.merge(fornecedor);

			fornecedor = new Fornecedor();

			FornecedorDAO dao1 = new FornecedorDAO();
			fornecedores = dao1.listar();

			Messages.addGlobalInfo("Fornecedor salvo com sucesso!");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o Fornecedor!");
			e.printStackTrace();

		}

	}

	public void excluir(ActionEvent evento) {
		try {

			fornecedor = (Fornecedor) evento.getComponent().getAttributes().get("fornecedorSelecionado");
			FornecedorDAO dao = new FornecedorDAO();
			dao.excluir(fornecedor);

			fornecedores = dao.listar();

			Messages.addGlobalInfo("Fonecedor removido com sucesso!");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar excluir o Fornecedor!");
			e.printStackTrace();

		}
	}

	public void editar(ActionEvent evento) {
		try {

			fornecedor = (Fornecedor) evento.getComponent().getAttributes().get("fornecedorSelecionado");
			Messages.addGlobalInfo("Fonecedor alterado com sucesso!");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar alterar o Fornecedor! " + e);
			e.printStackTrace();

		}
	}

	public void encontraCEP() {
		// Fornecedor fornecedor = new Fornecedor();
		CepWebService cepWebService = new CepWebService(fornecedor.getCep());

		if (cepWebService.getResultado() == 1) {
			fornecedor.setLogradouro(cepWebService.getLogradouro());
			fornecedor.setEstado(cepWebService.getEstado());
			fornecedor.setCidade(cepWebService.getCidade());

		} else {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Servidor não está respondendo", "Servidor não está respondendo"));
		}
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

}
