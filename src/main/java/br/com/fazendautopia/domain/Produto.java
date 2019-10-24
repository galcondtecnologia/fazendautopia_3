package br.com.fazendautopia.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Produto extends GenericDomain {

	@Column(columnDefinition = "text")
	private String imagemnome;
	private String imagemformato;
	@Lob
	private byte[] imagemBase64;
	private String descricao;
	@ManyToOne
	@JoinColumn(nullable = false)
	private CategoriaProduto categoriaProduto;
	private Double precoVenda;
	private Date dataCadastro;
	@ManyToOne
	@JoinColumn(nullable = false)
	private UnidadeMedida unidadeMedida;
	private String[] fornecedor;
	private boolean status;
	private int tipoproduto;
	private int multiplicador;

	public int getTipoproduto() {
		return tipoproduto;
	}

	public void setTipoproduto(int tipoproduto) {
		this.tipoproduto = tipoproduto;
	}

	public int getMultiplicador() {
		return multiplicador;
	}

	public void setMultiplicador(int multiplicador) {
		this.multiplicador = multiplicador;
	}

	private String informacoes;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getInformacoes() {
		return informacoes;
	}

	public void setInformacoes(String informacoes) {
		this.informacoes = informacoes;
	}

	public String getImagemformato() {
		return imagemformato;
	}

	public void setImagemformato(String imagemformato) {
		this.imagemformato = imagemformato;
	}

	public String getImagemnome() {
		return imagemnome;
	}

	public void setImagemnome(String imagemnome) {
		this.imagemnome = imagemnome;
	}

	public byte[] getImagemBase64() {
		return imagemBase64;
	}

	public void setImagemBase64(byte[] imagemBase64) {
		this.imagemBase64 = imagemBase64;
	}

	public CategoriaProduto getCategoriaProduto() {
		return categoriaProduto;
	}

	public void setCategoriaProduto(CategoriaProduto categoriaProduto) {
		this.categoriaProduto = categoriaProduto;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public UnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}


	public String[] getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String[] fornecedor) {
		this.fornecedor = fornecedor;
	}

	@Override
	public String toString() {
		return descricao;
	}

}
