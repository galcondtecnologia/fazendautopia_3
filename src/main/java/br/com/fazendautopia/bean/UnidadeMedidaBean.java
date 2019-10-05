package br.com.fazendautopia.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.fazendautopia.dao.UnidadeMedidaDAO;
import br.com.fazendautopia.domain.UnidadeMedida;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class UnidadeMedidaBean implements Serializable {

	private UnidadeMedida unidadeMedida;

	private List<UnidadeMedida> unidadeMedidas;

	@PostConstruct
	public void listar() {

		try {
			UnidadeMedidaDAO dao = new UnidadeMedidaDAO();
			unidadeMedidas = dao.listar();

		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar as Unidades de Medidas!");
			e.printStackTrace();

		}

	}

	public void novo() {
		unidadeMedida = new UnidadeMedida();
	}

	public void salvar() {

		try {

			UnidadeMedidaDAO dao = new UnidadeMedidaDAO();
			dao.merge(unidadeMedida);

			unidadeMedida = new UnidadeMedida();

			UnidadeMedidaDAO dao2 = new UnidadeMedidaDAO();
			unidadeMedidas = dao2.listar();

			Messages.addGlobalInfo("Unidade Medida salva com sucesso!");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar a Unidade Medida!");
			e.printStackTrace();

		}

	}

	public void excluir(ActionEvent evento) {
		try {
			unidadeMedida = (UnidadeMedida) evento.getComponent().getAttributes().get("unidadeSelecionada");
			UnidadeMedidaDAO dao = new UnidadeMedidaDAO();
			dao.excluir(unidadeMedida);

			unidadeMedidas = dao.listar();
			Messages.addGlobalInfo("Unidade Medida removida com sucesso!");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar excluir a Unidade Medida!");
			e.printStackTrace();

		}
	}

	public void editar(ActionEvent evento) {
		try {
			unidadeMedida = (UnidadeMedida) evento.getComponent().getAttributes().get("unidadeSelecionada");

			Messages.addGlobalInfo("Unidade Medida alterada com sucesso!");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar alterar a Unidade Medida! " + e);
			e.printStackTrace();

		}
	}

	public UnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public List<UnidadeMedida> getUnidadeMedidas() {
		return unidadeMedidas;
	}

	public void setUnidadeMedidas(List<UnidadeMedida> unidadeMedidas) {
		this.unidadeMedidas = unidadeMedidas;
	}

}
