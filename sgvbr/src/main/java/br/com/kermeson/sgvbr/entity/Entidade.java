package br.com.kermeson.sgvbr.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * Classe abstrata, base para todas as entidades
 *
 * @author kermeson.martins
 */
@MappedSuperclass
public abstract class Entidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceId")
	protected Long id;

	@Version
	@Column(name = "nu_versao_registro", nullable = false)
	protected Long versaoRegistro;

	public Entidade() {
	}

	public Entidade(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVersaoRegistro() {
		return versaoRegistro;
	}

	public void setVersaoRegistro(Long versaoRegistro) {
		this.versaoRegistro = versaoRegistro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		return result;
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
		Entidade other = (Entidade) obj;
		if (getId() == null) {
			if (other.getId() != null) {
				return false;
			}
		} else if (!getId().equals(other.getId())) {
			return false;
		}
		return true;
	}

}
