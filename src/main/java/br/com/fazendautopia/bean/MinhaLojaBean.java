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

import br.com.fazendautopia.dao.MinhaLojaDAO;
import br.com.fazendautopia.domain.MinhaLoja;
import br.com.fazendautopia.util.CepWebService;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class MinhaLojaBean implements Serializable {

	private MinhaLoja minhaloja;
	private List<MinhaLoja> minhalojas;

	@PostConstruct
	public void listar() {

		try {
			MinhaLojaDAO dao = new MinhaLojaDAO();
			minhalojas = dao.listar();
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar Lojas!");
			e.printStackTrace();

		}

	}

	public void novo() {
		minhaloja = new MinhaLoja();
	}

	public void salvar() {

		try {

			MinhaLojaDAO dao = new MinhaLojaDAO();
			dao.merge(minhaloja);

			minhaloja = new MinhaLoja();

			MinhaLojaDAO dao1 = new MinhaLojaDAO();
			minhalojas = dao1.listar();

			Messages.addGlobalInfo("Loja salva com sucesso!");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o Loja!");
			e.printStackTrace();

		}

	}

	public void excluir(ActionEvent evento) {
		try {

			minhaloja = (MinhaLoja) evento.getComponent().getAttributes().get("minhalojaSelecionada");
			MinhaLojaDAO dao = new MinhaLojaDAO();
			dao.excluir(minhaloja);

			minhalojas = dao.listar();

			Messages.addGlobalInfo("Fonecedor removido com sucesso!");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar excluir o minhaloja!");
			e.printStackTrace();

		}
	}

	public void editar(ActionEvent evento) {
		try {

			minhaloja = (MinhaLoja) evento.getComponent().getAttributes().get("minhalojaSelecionada");
			Messages.addGlobalInfo("Loja alterada com sucesso!");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar alterar a loja! " + e);
			e.printStackTrace();

		}
	}

	public void encontraCEP() {
		// minhaloja minhaloja = new minhaloja();
		CepWebService cepWebService = new CepWebService(minhaloja.getCep());

		if (cepWebService.getResultado() == 1) {
			minhaloja.setLogradouro(cepWebService.getLogradouro());
			minhaloja.setEstado(cepWebService.getEstado());
			minhaloja.setCidade(cepWebService.getCidade());
			minhaloja.setBairro(cepWebService.getBairro());

		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Servidor não está respondendo", "Servidor não está respondendo"));
		}
	}

	public MinhaLoja getMinhaloja() {
		return minhaloja;
	}

	public void setMinhaloja(MinhaLoja minhaloja) {
		this.minhaloja = minhaloja;
	}

	public List<MinhaLoja> getMinhalojas() {
		return minhalojas;
	}

	public void setMinhalojas(List<MinhaLoja> minhalojas) {
		this.minhalojas = minhalojas;
	}

}
