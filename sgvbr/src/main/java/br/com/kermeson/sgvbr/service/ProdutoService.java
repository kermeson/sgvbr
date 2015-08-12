package br.com.kermeson.sgvbr.service;

import java.util.List;

import br.com.kermeson.sgvbr.entity.Produto;

/**
 * Interface que realiza a manipulação de objetos do tipo Produto
 *
 * @author kermeson.martins
 */
public interface ProdutoService {

	/**
	 * Método usado para persistir um produto no banco de dados.
	 *
	 * @param produto
	 *            {@link Produto}
	 * @return produto
	 */
	public Produto incluir(Produto produto);

	public List<Produto> buscarTodos();

}