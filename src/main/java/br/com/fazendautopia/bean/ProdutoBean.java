package br.com.fazendautopia.bean;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Date;
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

import br.com.fazendautopia.dao.CategoriaProdutoDAO;
import br.com.fazendautopia.dao.FornecedorDAO;
import br.com.fazendautopia.dao.ProdutoDAO;
import br.com.fazendautopia.dao.UnidadeMedidaDAO;
import br.com.fazendautopia.domain.CategoriaProduto;
import br.com.fazendautopia.domain.Fornecedor;
import br.com.fazendautopia.domain.Produto;
import br.com.fazendautopia.domain.UnidadeMedida;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ProdutoBean implements Serializable {
	private Produto produto;
	private List<Produto> produtos;
	private List<CategoriaProduto> categoriaProdutos;
	private List<Fornecedor> fornecedores;
	private List<UnidadeMedida> unidadeMedidas;
	private Produto produtoSelecionado;

	private Part img = null;

	// @ManagedProperty(value = "")
	// private HibernateUtil hi;

	@PostConstruct
	public void listar() {

		try {

			ProdutoDAO dao = new ProdutoDAO();
			produtos = dao.listar();
			FornecedorDAO dao2 = new FornecedorDAO();
			fornecedores = dao2.listar();

			UnidadeMedidaDAO dao3 = new UnidadeMedidaDAO();
			unidadeMedidas = dao3.listar();

		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar as Categoria Cestas!");
			e.printStackTrace();

		}

	}

	public void novo() {
		try {
			produto = new Produto();

			CategoriaProdutoDAO dao = new CategoriaProdutoDAO();
			categoriaProdutos = dao.listar();

			FornecedorDAO dao2 = new FornecedorDAO();
			fornecedores = dao2.listar();

			UnidadeMedidaDAO dao3 = new UnidadeMedidaDAO();
			unidadeMedidas = dao3.listar();

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao gerar um novo produto");
			erro.printStackTrace();
		}

	}

	public void salvar() {

		try {
			ProdutoDAO dao = new ProdutoDAO();
			dao.merge(produto);
			Messages.addGlobalInfo("Produto salvo com sucesso!");
			ProdutoDAO dao1 = new ProdutoDAO();
			produtos = dao1.listar();

		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar as Categoria Cestas!");
			e.printStackTrace();
		}

	}

	public void salvar1() throws IOException {
		if(img != null) {
		try {
			/* processando imagem */
			byte[] imagemByte = getByte(img.getInputStream());
			produto.setImagemBase64(imagemByte); /* salva imagem original */

			/* transformar em buffere */
			BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(imagemByte));

			/*
			 * pegar o tipo da imagem = se for = ou diferente de 0 pega o ARGB
			 * senao getuype
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

			produto.setImagemnome(imagemMiniatura);
			produto.setImagemformato(extensao);
			ProdutoDAO dao = new ProdutoDAO();
			produto.setDataCadastro(new Date());
			dao.merge(produto);

			produto = new Produto();

			ProdutoDAO dao1 = new ProdutoDAO();
			produtos = dao1.listar();
			Messages.addGlobalInfo("Produto salvo com sucesso!");
			
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o produto!");
			e.printStackTrace();

		}
		}else {
			try {
			ProdutoDAO dao = new ProdutoDAO();
			produto.setDataCadastro(new Date());
			dao.merge(produto);

			produto = new Produto();

			ProdutoDAO dao1 = new ProdutoDAO();
			produtos = dao1.listar();
			Messages.addGlobalInfo("Produto salvo com sucesso!");
			
			} catch (RuntimeException e) {
				Messages.addGlobalError("Ocorreu um erro ao tentar salvar o produto!");
				e.printStackTrace();

			}
		}

	}

	public void excluir(ActionEvent evento) {
		try {
			produto = (Produto) evento.getComponent().getAttributes().get("produtoSelecionado");

			ProdutoDAO dao = new ProdutoDAO();
			dao.excluir(produto);

			produtos = dao.listar();
			Messages.addGlobalInfo("Produto removido com sucesso!");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar excluir o produto!");
			e.printStackTrace();

		}
	}
	
	@Named
	public void selecionar(ActionEvent event) {
		try {
			produtoSelecionado = (Produto) event.getComponent().getAttributes().get("produtoSelecionado");
			System.out.println("Produto capturado: " + produtoSelecionado.getDescricao());
			
		}catch(RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar selecionar o produto! " + e);
			e.printStackTrace();
		}
	}
	

	public void editar(ActionEvent evento) {
		try {
			
			CategoriaProdutoDAO dao3 = new CategoriaProdutoDAO();
			categoriaProdutos = dao3.listar();

			FornecedorDAO dao2 = new FornecedorDAO();
			fornecedores = dao2.listar();

			produto = (Produto) evento.getComponent().getAttributes().get("produtoSelecionado");

			ProdutoDAO dao = new ProdutoDAO();
			produtos = dao.listar();
			System.out.println("Produto capturado: " + produto.getDescricao());
			Messages.addGlobalInfo("Produto alterado com sucesso!");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar alterar o produto! " + e);
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

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
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

	public List<CategoriaProduto> getCategoriaProdutos() {
		return categoriaProdutos;
	}

	public void setCategoriaProdutos(List<CategoriaProduto> categoriaProdutos) {
		this.categoriaProdutos = categoriaProdutos;
	}

	public void setImg(Part img) {
		this.img = img;
	}

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	public List<UnidadeMedida> getUnidadeMedidas() {
		return unidadeMedidas;
	}

	public void setUnidadeMedidas(List<UnidadeMedida> unidadeMedidas) {
		this.unidadeMedidas = unidadeMedidas;
	}

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}

}
