package br.com.fazendautopia.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.hibernate.Session;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import br.com.fazendautopia.dao.UsuarioDAO;
import br.com.fazendautopia.domain.Usuario;
import br.com.fazendautopia.util.HibernateUtil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class AutenticacaoBean implements Serializable {

	private Usuario usuario = new Usuario();
	private Usuario usuarioLogado;

	public void inicia() {
		usuario = new Usuario();

	}

	@PostConstruct
	public void autenticar() {
		try {

			UsuarioDAO dao = new UsuarioDAO();
			usuarioLogado = dao.autenticar(usuario.getEmail(), usuario.getSenha());
			if (usuarioLogado == null) {
				Messages.addFlashGlobalError("Email e/ou Senha incorretos");
				return;
			} else {
				Messages.addGlobalError("Erro na autenticação ");
			}
			Messages.addGlobalInfo("Usuario Logado" + usuarioLogado);
			Faces.redirect("./index.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
			Messages.addGlobalError(e.getMessage());
		}
	}

	public void sair() {
		System.out.println("Chama sessão");
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		if (usuarioLogado.equals(true)) {
			session.disconnect();
			System.out.println("Fechou sessão: " + session + usuarioLogado.getEmail());
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

}
