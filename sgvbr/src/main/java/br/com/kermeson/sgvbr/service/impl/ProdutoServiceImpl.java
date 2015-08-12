package br.com.kermeson.sgvbr.service.impl;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.kermeson.sgvbr.dao.ProdutoDao;
import br.com.kermeson.sgvbr.entity.Produto;
import br.com.kermeson.sgvbr.service.ProdutoService;

/**
 * Classe que contém os serviços relacionados à entidade cidadao
 *
 * @author richard.madureira
 */
@Service("produtoService")
@Transactional(readOnly = true)
public class ProdutoServiceImpl implements ProdutoService, Serializable {
	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = LoggerFactory.getLogger(ProdutoServiceImpl.class);

	@Autowired
	private ProdutoDao produtoDao;

	@Transactional(readOnly = false)
	@Override
	public Produto incluir(Produto produto) {
		LOGGER.debug("Gravando produto ", produto);
		try {
			getProdutoDao().save(produto);
			return produto;
		} finally {
			LOGGER.debug("Fim da gravação dos dados do produto");
		}
	}

	public ProdutoDao getProdutoDao() {
		return produtoDao;
	}

	public void setProdutoDao(ProdutoDao produtoDao) {
		this.produtoDao = produtoDao;
	}

	@Override
	public List<Produto> buscarTodos() {
		return this.produtoDao.findAll();
	}

}