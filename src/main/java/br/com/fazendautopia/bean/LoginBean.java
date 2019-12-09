package br.com.fazendautopia.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.com.fazendautopia.dao.UsuarioDAO;
import br.com.fazendautopia.domain.Usuario;

@SuppressWarnings("serial")
@Named
@SessionScoped
public class LoginBean implements Serializable {

	private Usuario usuarioLogado;
	private String email;
	private String senha;
	@Inject
	private UsuarioDAO usuarioDAO;
	private List<Usuario> usuarios;

	public LoginBean() {

	}

	@PostConstruct
	public void init() {
		this.email = "";
		this.senha = "";
		usuarios = usuarioDAO.listar();
		for(Usuario usuario : usuarios) {
		System.out.println(usuario);
		}
	}

	public String logIn() {

		UsuarioDAO dao = new UsuarioDAO();

		usuarioLogado = dao.autenticar(email, senha);

		if (usuarioLogado == null) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário ou Senha Inválidos", "Login Inválido"));
			return null;
		} else {
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext()
					.getSession(false);
			if (session != null) {
				session.setAttribute("usuario", usuarioLogado);
			}
			return "/index?faces-redirect=true";
		}
	}

	public String logOff() {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		session.invalidate();
		return "/login?faces-redirect=true";
	}
}
