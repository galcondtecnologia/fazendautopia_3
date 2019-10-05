package br.com.fazendautopia;

import org.hibernate.Session;
import org.junit.Test;

import br.com.fazendautopia.util.HibernateUtil;

public class HibernateUtiTest {
	@Test
	public void conectar() {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		sessao.close();
		HibernateUtil.getFabricaDeSessoes().close();
	}
}
