package br.com.fazendautopia.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.fazendautopia.domain.Usuario;
import br.com.fazendautopia.util.HibernateUtil;

public class UsuarioDAO extends GenericDAO<Usuario> {

	public Usuario autenticar(String email, String senha) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(Usuario.class);
			consulta.add(Restrictions.eq("email", email));
			consulta.add(Restrictions.eq("senha", senha));

			Usuario resultado = (Usuario) consulta.uniqueResult();

			return resultado;
		} catch (RuntimeException e) {
			throw e;
		} finally {
			sessao.close();
		}
	}

}
