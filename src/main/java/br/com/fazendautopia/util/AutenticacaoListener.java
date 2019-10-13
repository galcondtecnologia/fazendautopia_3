package br.com.fazendautopia.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.omnifaces.util.Faces;

import br.com.fazendautopia.bean.AutenticacaoBean;
import br.com.fazendautopia.domain.Usuario;

@SuppressWarnings("serial")
public class AutenticacaoListener implements PhaseListener {

	@Override
	public void afterPhase(PhaseEvent event) {
		// pega a pagina atual
		String paginaAtual = Faces.getViewId();

		boolean ehPaginaDeAutenticacao = paginaAtual.contains("login.xhtml");
		// se nao for a pagina de autenticacao , entao e privada

		if (!ehPaginaDeAutenticacao) {
			AutenticacaoBean autenticacaoBean = Faces.getSessionAttribute("autenticacaoBean");
			if (autenticacaoBean == null) {
				Faces.navigate("/login.xhtml");
				return;
			}
			// se o bean for criado pego a autenticacao
			Usuario usuario = autenticacaoBean.getUsuarioLogado();
			if (usuario == null) {
				Faces.navigate("/login.xhtml");
				return;
			}
		}

	}

	@Override
	public void beforePhase(PhaseEvent event) {
		// TODO Auto-generated method stub

//		FacesContext ctx = FacesContext.getCurrentInstance();
//		if (!ctx.getViewRoot().getViewId().equals("/login.xhtml")) {
//
//		}

	}

	@Override
	public PhaseId getPhaseId() {
		// TODO Auto-generated method stub
		return PhaseId.RESTORE_VIEW;
	}

}
