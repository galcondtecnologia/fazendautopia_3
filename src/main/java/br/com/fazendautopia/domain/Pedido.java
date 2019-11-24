package br.com.fazendautopia.domain;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Pedido extends GenericDomain {

	private String ecoBag;
	private String valorFrete;
	private List<String> produto;

	public String getEcoBag() {
		return ecoBag;
	}

	public List<String> getProduto() {
		return produto;
	}

	public void setProduto(List<String> produto) {
		this.produto = produto;
	}

	public void setEcoBag(String ecoBag) {
		this.ecoBag = ecoBag;
	}

	public String getValorFrete() {
		return valorFrete;
	}

	public void setValorFrete(String valorFrete) {
		this.valorFrete = valorFrete;
	}

}
