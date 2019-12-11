package br.com.fazendautopia.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Frete extends GenericDomain {
	@ManyToOne
	@JoinColumn(nullable = false)
	private MinhaLoja unidadeMinhaLoja;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Cliente clienteDestinoRegiao;
	private Double valorFrete;

	public MinhaLoja getUnidadeMinhaLoja() {
		return unidadeMinhaLoja;
	}

	public void setUnidadeMinhaLoja(MinhaLoja unidadeMinhaLoja) {
		this.unidadeMinhaLoja = unidadeMinhaLoja;
	}

	public Cliente getClienteDestinoRegiao() {
		return clienteDestinoRegiao;
	}

	public void setClienteDestinoRegiao(Cliente clienteDestinoRegiao) {
		this.clienteDestinoRegiao = clienteDestinoRegiao;
	}

	public Double getValorFrete() {
		return valorFrete;
	}

	public void setValorFrete(Double valorFrete) {
		this.valorFrete = valorFrete;
	}

}
