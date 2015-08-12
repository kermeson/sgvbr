package br.com.kermeson.sgvbr.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "produtos")
@AttributeOverride(name = "id", column = @Column(name = "id_produto") )
@SequenceGenerator(name = "sequenceId", sequenceName = "sq_produto", allocationSize = 1)
public class Produto extends Entidade {
	private static final long serialVersionUID = 1L;

	@Column(name = "nm_produto", length = 255)
	@Size(max = 255)
	private String nome;

	@Column(name = "nu_codigo", length = 255)
	private Integer codigo;

	@Column(name = "vl_preco_venda")
	private Float precoVenda;

	@Column(name = "vl_preco_custo")
	private Float precoCusco;

	public Produto() {
	}

	public Produto(Long id) {
		super(id);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Float getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(Float precoVenda) {
		this.precoVenda = precoVenda;
	}

	public Float getPrecoCusco() {
		return precoCusco;
	}

	public void setPrecoCusco(Float precoCusco) {
		this.precoCusco = precoCusco;
	}

	/**
	 * Utiliza: nome, codigo.
	 */
	public int hashCodeAtributosPrincipais() {
		int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	/**
	 * Utiliza: nome, codigo.
	 */
	public boolean equalsAtributosPrincipais(Produto outroProduto) {
		if (this == outroProduto) {
			return true;
		}
		if (outroProduto == null) {
			return false;
		}
		if (nome == null) {
			if (outroProduto.nome != null) {
				return false;
			}
		} else if (!nome.equals(outroProduto.nome)) {
			return false;
		}

		if (codigo == null) {
			if (outroProduto.codigo != null) {
				return false;
			}
		} else if (!codigo.equals(outroProduto.codigo)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + "]";
	}
}
