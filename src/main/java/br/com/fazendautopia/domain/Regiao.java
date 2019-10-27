package br.com.fazendautopia.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Regiao extends GenericDomain {

	@Column(length = 25, nullable = false)
	private String descricao;
	private boolean status;

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

	@Override
	public String toString() {
		return "Regiao [descricao=" + descricao + ", status=" + status + "]";
	}

}
