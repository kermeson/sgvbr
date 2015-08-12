package br.com.kermeson.sgvbr.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import br.com.kermeson.sgvbr.dao.ProdutoDao;
import br.com.kermeson.sgvbr.entity.Produto;

/**
 * Classe que realiza a manipulação de objetos do tipo Produto
 *
 * @author kermeson.martins
 */
@Repository("produtoDao")
@SuppressWarnings("unchecked")
public class ProdutoDaoImpl extends AbstractDaoImpl<Produto>implements ProdutoDao {
	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = LoggerFactory.getLogger(ProdutoDaoImpl.class);

	/**
	 * Método construtor padrão
	 */
	public ProdutoDaoImpl() {
		setClazz(Produto.class);
	}

}