package br.com.fazendautopia.DaoTeste;

import org.junit.Ignore;
import org.junit.Test;

import br.com.fazendautopia.dao.RegiaoDAO;
import br.com.fazendautopia.domain.Regiao;

public class RegiaoDAOTest {
	@Ignore
	@Test
	public void salvar() {

		RegiaoDAO dao = new RegiaoDAO();
		Regiao regiao = new Regiao();

		regiao.setDescricao("Copacabana-RJ");
		regiao.setStatus(false);
		dao.salvar(regiao);
		System.out.println("Regiao salva com sucesso : " + regiao);
	}

}
