package br.com.fazendautopia.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Pedido extends GenericDomain {
	private Date dataeHora;
	private Cliente cliente;
	private ArrayList<String> cestas;
	private ArrayList<String> produtosAdicionais;
	private boolean ecoBag;
	private Double valorTotal;
	private Double valorFrete;
	private String modoPagamento;
	private String observacoes;
	private int plano;
	private String endereco;

	public ArrayList<String> getCestas() {
		return cestas;
	}

	public void setCestas(ArrayList<String> cestas) {
		this.cestas = cestas;
	}

	public ArrayList<String> getProdutosAdicionais() {
		return produtosAdicionais;
	}

	public void setProdutosAdicionais(ArrayList<String> produtosAdicionais) {
		this.produtosAdicionais = produtosAdicionais;
	}

	public Date getDataeHora() {
		return dataeHora;
	}

	public void setDataeHora(Date dataeHora) {
		this.dataeHora = dataeHora;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public boolean isEcoBag() {
		return ecoBag;
	}

	public void setEcoBag(boolean ecoBag) {
		this.ecoBag = ecoBag;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Double getValorFrete() {
		return valorFrete;
	}

	public void setValorFrete(Double valorFrete) {
		this.valorFrete = valorFrete;
	}

	public String getModoPagamento() {
		return modoPagamento;
	}

	public void setModoPagamento(String modoPagamento) {
		this.modoPagamento = modoPagamento;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public int getPlano() {
		return plano;
	}

	public void setPlano(int plano) {
		this.plano = plano;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}
