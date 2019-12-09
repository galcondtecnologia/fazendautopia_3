package br.com.fazendautopia.domain;

import java.util.Date;
import java.util.Objects;
import java.util.logging.Logger;

import javax.persistence.Column;
import javax.persistence.Entity;

import br.com.fazendautopia.util.LoginUtil;

@SuppressWarnings("serial")
@Entity
public class Usuario extends GenericDomain {

	@Column(length = 100, nullable = false)
	private String email;
	private String senha;
	private Date dataCadastro;
	private static final Logger LOG = Logger.getLogger(Usuario.class.getName());
	
	//contrutor
	public Usuario() {
		
	}
	
	public Usuario(String email, String senha) {
		this.email = email;
		this.senha = new LoginUtil().MD5(senha);
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	public int hashCode() {
		int hash = 3;
		 hash = 83 * hash + Objects.hashCode(this.email);
	        return hash;
	}
	
	   @Override
	    public boolean equals(Object obj) {
	        if (this == obj) {
	            return true;
	        }
	        if (obj == null) {
	            return false;
	        }
	        if (getClass() != obj.getClass()) {
	            return false;
	        }
	        final Usuario other = (Usuario) obj;
	        if (!Objects.equals(this.email, other.email)) {
	            return false;
	        }
	        return true;
	    }

	    @Override
	    public String toString() {
	        return email;
	    }

	
	
	

}
