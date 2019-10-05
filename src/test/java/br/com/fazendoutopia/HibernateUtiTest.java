package br.com.fazendoutopia;

import org.hibernate.Session;
import org.junit.Test;

import br.com.fazendoutopia.util.HibernateUtil;

public class HibernateUtiTest {
	@Test
	public void conectar() {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		sessao.close();
		HibernateUtil.getFabricaDeSessoes().close();
	}
}
