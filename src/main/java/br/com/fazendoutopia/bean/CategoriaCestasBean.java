package br.com.fazendoutopia.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.fazendoutopia.dao.CategoriaCestasDAO;
import br.com.fazendoutopia.domain.CategoriaCesta;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CategoriaCestasBean implements Serializable {

	private CategoriaCesta categoriaCesta;

	private List<CategoriaCesta> categoriaCestas;

	@PostConstruct
	public void listar() {

		try {

			CategoriaCestasDAO dao = new CategoriaCestasDAO();
			categoriaCestas = dao.listar();
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar as Categoria Cestas!");
			e.printStackTrace();

		}

	}

	public void novo() {
		categoriaCesta = new CategoriaCesta();
	}

	public void salvar() {

		try {

			CategoriaCestasDAO dao = new CategoriaCestasDAO();
			dao.merge(categoriaCesta);

			categoriaCesta = new CategoriaCesta();
			CategoriaCestasDAO dao1 = new CategoriaCestasDAO();
			categoriaCestas = dao1.listar();

			Messages.addGlobalInfo("Categoria Cesta salva com sucesso!");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar as Categoria Cestas!");
			e.printStackTrace();

		}

	}

	public void excluir(ActionEvent evento) {
		try {
			categoriaCesta = (CategoriaCesta) evento.getComponent().getAttributes().get("categoriaselecionada");
			CategoriaCestasDAO dao = new CategoriaCestasDAO();
			dao.excluir(categoriaCesta);

			categoriaCestas = dao.listar();
			Messages.addGlobalInfo("CategoriaCesta removida com sucesso!");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar excluir a categoriaCesta!");
			e.printStackTrace();

		}
	}

	public void editar(ActionEvent evento) {
		try {
			categoriaCesta = (CategoriaCesta) evento.getComponent().getAttributes().get("categoriaselecionada");

			Messages.addGlobalInfo("CategoriaCesta alterada com sucesso!");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar alterar a categoriaCesta! " + e);
			e.printStackTrace();

		}
	}

	public CategoriaCesta getCategoria() {
		return categoriaCesta;
	}

	public void setCategoria(CategoriaCesta categoriaCesta) {
		this.categoriaCesta = categoriaCesta;
	}

	public List<CategoriaCesta> getCategorias() {
		return categoriaCestas;
	}

	public void setCategorias(List<CategoriaCesta> categoriaCestas) {
		this.categoriaCestas = categoriaCestas;
	}

}
