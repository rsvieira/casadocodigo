package br.com.casadocodigo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author Ramon Vieira
 *
 */

@Entity
public class Role implements GrantedAuthority{

	private static final long serialVersionUID = -627160272045345261L;

	@Id
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

	@Override
	public String getAuthority() {
		return this.nome;
	}

}

