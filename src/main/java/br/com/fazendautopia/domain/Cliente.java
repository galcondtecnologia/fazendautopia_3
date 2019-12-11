package br.com.fazendautopia.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Cliente extends GenericDomain {
	@ManyToOne
	@JoinColumn(nullable = false)
	private Usuario usuario;
	private String telefone;
	private String nome;
	private String cep;
	private String cidade;
	private String estado;
	private String logradouro;
	private String codIbge;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Regiao regiao;
	private boolean avisoRegiao;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCodIbge() {
		return codIbge;
	}

	public void setCodIbge(String codIbge) {
		this.codIbge = codIbge;
	}

	public Regiao getRegiao() {
		return regiao;
	}

	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}

	public boolean isAvisoRegiao() {
		return avisoRegiao;
	}

	public void setAvisoRegiao(boolean avisoRegiao) {
		this.avisoRegiao = avisoRegiao;
	}

}
