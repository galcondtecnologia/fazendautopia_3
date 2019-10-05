package br.com.fazendautopia.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class CategoriaCesta extends GenericDomain {
	@Column(length = 100, nullable = false)
	private String descricao;

	private boolean status;
	private int quantidadeitens;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	

	public int getQuantidadeitens() {
		return quantidadeitens;
	}

	public void setQuantidadeitens(int quantidadeitens) {
		this.quantidadeitens = quantidadeitens;
	}

	@Override
	public String toString() {
		return "CategoriaProduto [descricao=" + descricao + ", status=" + status + ", quantidadeitens="
				+ quantidadeitens + "]";
	}

}
