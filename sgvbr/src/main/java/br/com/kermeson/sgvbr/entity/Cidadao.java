package br.com.kermeson.sgvbr.entity;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cidadaos")
@AttributeOverride(name = "id", column = @Column(name = "id_cidadao") )
@SequenceGenerator(name = "sequenceId", sequenceName = "sq_cidadao", allocationSize = 1)
public class Cidadao extends Entidade {
	private static final long serialVersionUID = 1L;

	@Column(name = "nm_cidadao", length = 255)
	@Size(max = 255)
	private String nome;

	@Column(name = "nm_mae_cidadao", length = 255)
	@Size(max = 255)
	private String nomeMae;

	@Column(name = "dt_nascimento")
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;

	@Column(name = "in_encontrado_cnis")
	private Boolean encontradoCnis;

	public Cidadao() {
	}

	public Cidadao(Long id) {
		super(id);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Boolean getEncontradoCnis() {
		return encontradoCnis;
	}

	public void setEncontradoCnis(Boolean encontradoCnis) {
		this.encontradoCnis = encontradoCnis;
	}

	/**
	 * Utiliza: nit, nome, nome da mãe e data de nascimento.
	 */
	public int hashCodeAtributosPrincipais() {
		int prime = 31;
		int result = 1;
		result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((nomeMae == null) ? 0 : nomeMae.hashCode());
		return result;
	}

	/**
	 * Utiliza: nit, nome, nome da mãe e data de nascimento.
	 */
	public boolean equalsAtributosPrincipais(Cidadao outroCidadao) {
		if (this == outroCidadao) {
			return true;
		}
		if (outroCidadao == null) {
			return false;
		}
		if (dataNascimento == null) {
			if (outroCidadao.dataNascimento != null) {
				return false;
			}
		} else if (!dataNascimento.equals(outroCidadao.dataNascimento)) {
			return false;
		}

		if (nome == null) {
			if (outroCidadao.nome != null) {
				return false;
			}
		} else if (!nome.equals(outroCidadao.nome)) {
			return false;
		}
		if (nomeMae == null) {
			if (outroCidadao.nomeMae != null) {
				return false;
			}
		} else if (!nomeMae.equals(outroCidadao.nomeMae)) {
			return false;
		}
		return true;
	}

	// public boolean equalsCpf(Cidadao outroCidadao) {
	// return getCpf() != null && outroCidadao != null && outroCidadao.getCpf()
	// != null
	// && getCpf().equals(outroCidadao.getCpf());
	// }

	@Override
	public String toString() {
		return "Cidadao [id=" + id + ", nome=" + nome + "]";
	}
}
