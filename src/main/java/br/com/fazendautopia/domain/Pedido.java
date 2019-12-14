package br.com.fazendautopia.domain;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Pedido extends GenericDomain {
	private Date dataeHora;
	private Cliente cliente;
	private ArrayList<Itens> itens = new ArrayList<Itens>();
	private boolean ecoBag;
	private Double totalPedido;
	private Double valorFrete;
	private String tipoPagamento;
	private String observacao;
	private int plano;
	private String enderecoEntrega;
	private String regiao;
	private boolean retirada;
	private String nomeRecebedor;

	public String getNomeRecebedor() {
		return nomeRecebedor;
	}

	public void setNomeRecebedor(String nomeRecebedor) {
		this.nomeRecebedor = nomeRecebedor;
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

	public ArrayList<Itens> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Itens> itens) {
		this.itens = itens;
	}

	public boolean isEcoBag() {
		return ecoBag;
	}

	public void setEcoBag(boolean ecoBag) {
		this.ecoBag = ecoBag;
	}

	public Double getTotalPedido() {
		return totalPedido;
	}

	public void setTotalPedido(Double totalPedido) {
		this.totalPedido = totalPedido;
	}

	public Double getValorFrete() {
		return valorFrete;
	}

	public void setValorFrete(Double valorFrete) {
		this.valorFrete = valorFrete;
	}

	public String getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public int getPlano() {
		return plano;
	}

	public void setPlano(int plano) {
		this.plano = plano;
	}

	public String getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(String enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	public boolean isRetirada() {
		return retirada;
	}

	public void setRetirada(boolean retirada) {
		this.retirada = retirada;
	}

}
