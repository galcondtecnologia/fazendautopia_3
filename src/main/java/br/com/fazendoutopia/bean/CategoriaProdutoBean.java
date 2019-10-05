package br.com.fazendoutopia.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;


import br.com.fazendoutopia.dao.CategoriaProdutoDAO;
import br.com.fazendoutopia.domain.CategoriaProduto;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CategoriaProdutoBean implements Serializable {

	private CategoriaProduto categoriaProduto;

	private List<CategoriaProduto> categoriaProdutos;

	@PostConstruct
	public void listar() {

		try {

			CategoriaProdutoDAO dao = new CategoriaProdutoDAO();
			categoriaProdutos = dao.listar();
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar as Categoria Produtos!");
			e.printStackTrace();

		}

	}

	public void novo() {
		categoriaProduto = new CategoriaProduto();
	}

	public void salvar() {

		try {

			CategoriaProdutoDAO dao = new CategoriaProdutoDAO();
			dao.merge(categoriaProduto);

			categoriaProduto = new CategoriaProduto();
			CategoriaProdutoDAO dao1 = new CategoriaProdutoDAO();
			categoriaProdutos = dao1.listar();

			Messages.addGlobalInfo("Categoria Produto salva com sucesso!");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar as Categoria Produtos!");
			e.printStackTrace();

		}

	}

	public void excluir(ActionEvent evento) {
		try {
			categoriaProduto = (CategoriaProduto) evento.getComponent().getAttributes().get("categoriaselecionada");
			CategoriaProdutoDAO dao = new CategoriaProdutoDAO();
			dao.excluir(categoriaProduto);

			categoriaProdutos = dao.listar();
			Messages.addGlobalInfo("Categoria Produto removida com sucesso!");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar excluir a Categoria Produto!");
			e.printStackTrace();

		}
	}

	public void editar(ActionEvent evento) {
		try {
			categoriaProduto = (CategoriaProduto) evento.getComponent().getAttributes().get("categoriaselecionada");

			Messages.addGlobalInfo("Categoria Produto alterada com sucesso!");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar alterar a Categoria Produto! " + e);
			e.printStackTrace();

		}
	}

	public CategoriaProduto getCategoriaProduto() {
		return categoriaProduto;
	}

	public void setCategoriaProduto(CategoriaProduto categoriaProduto) {
		this.categoriaProduto = categoriaProduto;
	}

	public List<CategoriaProduto> getCategoriaProdutos() {
		return categoriaProdutos;
	}

	public void setCategoriaProdutos(List<CategoriaProduto> categoriaProdutos) {
		this.categoriaProdutos = categoriaProdutos;
	}

	

}
