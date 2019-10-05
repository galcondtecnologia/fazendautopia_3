package br.com.fazendoutopia.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.fazendoutopia.dao.RegiaoDAO;
import br.com.fazendoutopia.domain.Regiao;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class RegiaoBean implements Serializable {

	private Regiao regiao;

	private List<Regiao> regioes;

	@PostConstruct
	public void listar() {

		try {
			RegiaoDAO dao = new RegiaoDAO();
			regioes = dao.listar();

		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar as Regiões!");
			e.printStackTrace();

		}

	}

	public void novo() {
		regiao = new Regiao();
	}

	public void salvar() {

		try {
			RegiaoDAO dao = new RegiaoDAO();
			dao.merge(regiao);

			regiao = new Regiao();

			regioes = dao.listar();

			Messages.addGlobalInfo("Região salva com sucesso!");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar a Região!");
			e.printStackTrace();

		}

	}

	public void excluir(ActionEvent evento) {
		try {

			regiao = (Regiao) evento.getComponent().getAttributes().get("regiaoSelecionada");
			RegiaoDAO dao = new RegiaoDAO();
			dao.excluir(regiao);

			regioes = dao.listar();
			Messages.addGlobalInfo("Região removida com sucesso!");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar excluir a Região!");
			e.printStackTrace();

		}
	}

	public void editar(ActionEvent evento) {
		try {
			regiao = (Regiao) evento.getComponent().getAttributes().get("regiaoSelecionada");

			Messages.addGlobalInfo("Região alterada com sucesso!");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar alterar a Região! " + e);
			e.printStackTrace();

		}
	}

	public Regiao getRegiao() {
		return regiao;
	}

	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}

	public List<Regiao> getRegioes() {
		return regioes;
	}

	public void setRegioes(List<Regiao> regioes) {
		this.regioes = regioes;
	}

}
