package br.com.fazendoutopia.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class BeanCrua implements Serializable {

	@PostConstruct
	public void listar() {

		try {
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar as Categoria Cestas!");
			e.printStackTrace();

		}

	}

	public void novo() {

	}

	public void salvar() {

		try {
			Messages.addGlobalInfo("Categoria Cesta salva com sucesso!");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar as Categoria Cestas!");
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
