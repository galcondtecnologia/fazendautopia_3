package br.com.fazendautopia.bean;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.imageio.ImageIO;
import javax.inject.Named;
import javax.servlet.http.Part;
import javax.xml.bind.DatatypeConverter;

import org.omnifaces.util.Messages;
import org.primefaces.model.DualListModel;

import br.com.fazendautopia.dao.CategoriaCestasDAO;
import br.com.fazendautopia.dao.CestaDAO;
import br.com.fazendautopia.dao.ProdutoDAO;
import br.com.fazendautopia.domain.CategoriaCesta;
import br.com.fazendautopia.domain.Cesta;
import br.com.fazendautopia.domain.Produto;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CestaBean implements Serializable {

	private Cesta cesta;
	private Cesta cestaSelecionada;
	private List<Cesta> cestas;
	private List<CategoriaCesta> categoriacestas;
	private List<Produto> produtos;
	private List<Produto> produtoListado = new ArrayList<Produto>();
	private List<Produto> produtoCaturado = new ArrayList<Produto>();
	private DualListModel<Produto> dualList;

	private Part img = null;

	@PostConstruct
	public void listar() {

		try {

			CestaDAO dao = new CestaDAO();
			cestas = dao.listar();

			ProdutoDAO dao1 = new ProdutoDAO();
			produtos = dao1.listar();

			CategoriaCestasDAO dao2 = new CategoriaCestasDAO();
			categoriacestas = dao2.listar();
			dualList = new DualListModel<>(produtos, getProdutoCaturado());
			// if (dualList.getTarget().size() == 0) {
			// dualList = new DualListModel<>(produtos, produtoCaturado);
			// } else if (dualList.getTarget().size() != 0) {
			//
			// produtoListado = dualList.getSource();
			//
			// }
			// // esta faltando a consição de editar

		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar as cestas!");
			e.printStackTrace();

		}

	}

	public void novo() {
		cesta = new Cesta();

	}

	public void salvar() throws IOException {
		
		if (img != null) {
		try {

			/* processando imagem */
			
				byte[] imagemByte = getByte(img.getInputStream());
				cesta.setImagemBase64(imagemByte); /* salva imagem original */

				/* transformar em buffere */
				BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(imagemByte));

				/*
				 * pegar o tipo da imagem = se for = ou diferente de 0 pega o
				 * ARGB senao getuype
				 */
				int type = bufferedImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : bufferedImage.getType();

				int largura = 200;
				int altura = 200;

				/* criar miniatura */
				BufferedImage imagemModificada = new BufferedImage(largura, altura, type);
				Graphics2D gra = imagemModificada.createGraphics();
				gra.drawImage(bufferedImage, 0, 0, largura, altura, null);
				gra.dispose();
				/* escrever novamente a imagem em tamanho menor */
				ByteArrayOutputStream saida = new ByteArrayOutputStream();
				String extensao = img.getContentType()
						.split("\\/")[1];/* salva nesse formato image/png */

				ImageIO.write(imagemModificada, extensao, saida);

				String imagemMiniatura = "data:" + img.getContentType() + ";base64,"
						+ DatatypeConverter.printBase64Binary(saida.toByteArray());

				cesta.setImagemnome(imagemMiniatura);
				cesta.setImagemformato(extensao);
				cesta.setDualListModelProdu(dualList);
				CestaDAO dao = new CestaDAO();
				dao.merge(cesta);
				cesta = new Cesta();
				cestas = dao.listar();

				ProdutoDAO dao1 = new ProdutoDAO();
				produtos = dao1.listar();

				CategoriaCestasDAO dao2 = new CategoriaCestasDAO();
				categoriacestas = dao2.listar();

				Messages.addGlobalInfo("Cesta salva com sucesso!");

		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar as cestas!");
			e.printStackTrace();

		}
		} else {
			try {
			cesta.setDualListModelProdu(dualList);
			CestaDAO dao = new CestaDAO();
			dao.merge(cesta);
			cesta = new Cesta();
			cestas = dao.listar();

			ProdutoDAO dao1 = new ProdutoDAO();
			produtos = dao1.listar();

			CategoriaCestasDAO dao2 = new CategoriaCestasDAO();
			categoriacestas = dao2.listar();

			Messages.addGlobalInfo("Cesta salva com sucesso!");
			
			} catch (RuntimeException e) {
				Messages.addGlobalError("Ocorreu um erro ao tentar salvar as cestas!");
				e.printStackTrace();

			}
		}

	}

	public void excluir(ActionEvent evento) {
		try {

			cesta = (Cesta) evento.getComponent().getAttributes().get("cestaSelecionada");
			

			CestaDAO dao = new CestaDAO();
			dao.excluir(cesta);
			cestas = dao.listar();

			Messages.addGlobalInfo("Cesta removida com sucesso!");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar excluir a cesta!");
			e.printStackTrace();

		}
	}
	@Named
	public void selecionarCesta(ActionEvent evento) {
		try {
			
			cestaSelecionada = (Cesta) evento.getComponent().getAttributes().get("cestaSelecionada");
			
			System.out.println("Cesta capturada: " + cestaSelecionada.getDescricao());
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar alterar a cesta! " + e);
			e.printStackTrace();

		}
	}


	public void editar(ActionEvent evento) {
		try {
			
			cesta = (Cesta) evento.getComponent().getAttributes().get("cestaSelecionada");
			System.out.println("Cesta capturada: " + cesta.getDescricao());
			Messages.addGlobalInfo("Cesta alterada com sucesso!");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar alterar a cesta! " + e);
			e.printStackTrace();

		}
	}

	private byte[] getByte(InputStream is) throws IOException {
		int len;
		int size = 1024;
		byte[] buf = null;
		if (is instanceof ByteArrayInputStream) {
			size = is.available();
			buf = new byte[size];
			len = is.read(buf, 0, size);
		} else {
			ByteArrayOutputStream saida = new ByteArrayOutputStream();
			buf = new byte[size];
			while ((len = is.read(buf, 0, size)) != -1) {
				saida.write(buf, 0, len);
			}
			buf = saida.toByteArray();
		}
		return buf;
	}
	
	public void download() {

	}


	public DualListModel<Produto> getDualList() {
		return dualList;
	}

	public void setDualList(DualListModel<Produto> dualList) {
		this.dualList = dualList;
	}

	public Cesta getCesta() {
		return cesta;
	}

	public void setCesta(Cesta cesta) {
		this.cesta = cesta;
	}

	public List<Cesta> getCestas() {
		return cestas;
	}

	public void setCestas(List<Cesta> cestas) {
		this.cestas = cestas;
	}

	public List<CategoriaCesta> getCategoriacestas() {
		return categoriacestas;
	}

	public void setCategoriacestas(List<CategoriaCesta> categoriacestas) {
		this.categoriacestas = categoriacestas;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Part getImg() {
		return img;
	}

	public void setImg(Part img) {
		this.img = img;
	}

	public List<Produto> getProdutoListado() {
		return produtoListado;
	}

	public void setProdutoListado(List<Produto> produtoListado) {
		this.produtoListado = produtoListado;
	}

	public List<Produto> getProdutoCaturado() {
		return produtoCaturado;
	}

	public void setProdutoCaturado(List<Produto> produtoCaturado) {
		this.produtoCaturado = produtoCaturado;
	}

	public Cesta getCestaSelecionada() {
		return cestaSelecionada;
	}

	public void setCestaSelecionada(Cesta cestaSelecionada) {
		this.cestaSelecionada = cestaSelecionada;
	}
	

}
