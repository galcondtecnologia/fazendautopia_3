package br.com.fazendautopia.domain;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.primefaces.model.DualListModel;

@SuppressWarnings("serial")
@Entity
public class Cesta extends GenericDomain {

	@Column(columnDefinition = "text")
	private String imagemnome;
	private String imagemformato;
	@Lob
	private byte[] imagemBase64;
	private String descricao;
	@ManyToOne
	@JoinColumn(nullable = false)
	private CategoriaCesta categoriaCesta;
	private DualListModel<Produto> dualListModelProdu;
	private boolean status;
	private int quantItens;
	private Double precovenda;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public CategoriaCesta getCategoriaCesta() {
		return categoriaCesta;
	}

	public void setCategoriaCesta(CategoriaCesta categoriaCesta) {
		this.categoriaCesta = categoriaCesta;
	}

	public String getImagemnome() {
		return imagemnome;
	}

	public void setImagemnome(String imagemnome) {
		this.imagemnome = imagemnome;
	}

	public String getImagemformato() {
		return imagemformato;
	}

	public void setImagemformato(String imagemformato) {
		this.imagemformato = imagemformato;
	}

	public byte[] getImagemBase64() {
		return imagemBase64;
	}

	public void setImagemBase64(byte[] imagemBase64) {
		this.imagemBase64 = imagemBase64;
	}

	

	public DualListModel<Produto> getDualListModelProdu() {
		return dualListModelProdu;
	}

	public void setDualListModelProdu(DualListModel<Produto> dualListModelProdu) {
		this.dualListModelProdu = dualListModelProdu;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getQuantItens() {
		return quantItens;
	}

	public void setQuantItens(int quantItens) {
		this.quantItens = quantItens;
	}

	public Double getPrecovenda() {
		return precovenda;
	}

	public void setPrecovenda(Double precovenda) {
		this.precovenda = precovenda;
	}

}
