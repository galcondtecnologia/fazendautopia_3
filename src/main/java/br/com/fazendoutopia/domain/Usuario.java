package br.com.fazendoutopia.domain;

import java.util.Date;

import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Usuario extends GenericDomain {

	private String email;
	private String senha;
	private Date dataCadastro;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

}
