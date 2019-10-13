package br.com.fazendautopia.domain;

import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class UnidadeMedida extends GenericDomain {
	private String descricao;
	private String status;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "UnidadeMedida [descricao=" + descricao + ", status=" + status + "]";
	}

}
