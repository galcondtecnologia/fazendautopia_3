package br.com.fazendautopia.domain;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Itens extends GenericDomain {

	private String _preco;
	private ArrayList<String> _produtos;
	private String _qtd;
	private String _titulo;

	public String get_preco() {
		return _preco;
	}

	public void set_preco(String _preco) {
		this._preco = _preco;
	}

	public ArrayList<String> get_produtos() {
		return _produtos;
	}

	public void set_produtos(ArrayList<String> _produtos) {
		this._produtos = _produtos;
	}

	public String get_qtd() {
		return _qtd;
	}

	public void set_qtd(String _qtd) {
		this._qtd = _qtd;
	}

	public String get_titulo() {
		return _titulo;
	}

	public void set_titulo(String _titulo) {
		this._titulo = _titulo;
	}

	@Override
	public String toString() {
		return "Itens [_preco=" + _preco + ", _produtos=" + _produtos + ", _qtd=" + _qtd + ", _titulo=" + _titulo + "]";
	}

}
