package br.com.kermeson.sgvbr.service.impl;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.kermeson.sgvbr.dao.CidadaoDao;
import br.com.kermeson.sgvbr.entity.Cidadao;
import br.com.kermeson.sgvbr.service.CidadaoService;

/**
 * Classe que contém os serviços relacionados à entidade cidadao
 *
 * @author richard.madureira
 */
@Service("cidadaoService")
@Transactional(readOnly = true)
public class CidadaoServiceImpl implements CidadaoService, Serializable {
	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = LoggerFactory.getLogger(CidadaoServiceImpl.class);

	@Autowired
	private CidadaoDao cidadaoDao;

	/**
	 * @see br.gov.dataprev.portalatendimentoaps.service.CidadaoService#obterListaCidadaoPorCpf(java.lang.Long)
	 */
	@Override
	public List<Cidadao> obterListaCidadaoPorCpf(Long cpf) {
		LOGGER.debug("Obtendo lista de cidaão por CPF ", cpf);
		return getCidadaoDao().obterListaCidadaoPorCpf(cpf);
	}

	/**
	 * @see br.gov.dataprev.portalatendimentoaps.service.CidadaoService#obterListaCidadaoPorNit(java.lang.Long)
	 */
	@Override
	public List<Cidadao> obterListaCidadaoPorNit(Long nit) {
		LOGGER.debug("Obtendo lista de cidadao por nit ", nit);
		return getCidadaoDao().obterListaCidadaoPorNit(nit);
	}

	/**
	 * @see br.gov.dataprev.portalatendimentoaps.service.CidadaoService#obterListaCidadaoPorNome(java.lang.String)
	 */
	@Override
	public List<Cidadao> obterListaCidadaoPorNome(String nome) {
		LOGGER.debug("Obtendo lista de cidadão por nome ", nome);
		return getCidadaoDao().obterListaCidadaoPorNome(nome);
	}

	/**
	 * @see br.gov.dataprev.portalatendimentoaps.service.CidadaoService#obterListaCidadaoPorExemplo(br.gov.dataprev.portalatendimentoaps.entity.Cidadao)
	 */
	@Override
	public List<Cidadao> obterListaCidadaoPorExemplo(Cidadao cidadao) {
		LOGGER.debug("Obtendo lista de cidadãos pelo exemplo ", cidadao);
		return getCidadaoDao().obterListaCidadaoPorExemplo(cidadao);
	}

	/**
	 * @see br.gov.dataprev.portalatendimentoaps.service.CidadaoService#incluir(br.gov.dataprev.portalatendimentoaps.entity.Cidadao)
	 */
	@Override
	public Cidadao incluir(Cidadao cidadao) {
		LOGGER.debug("Gravando cidadão ", cidadao);
		try {
			getCidadaoDao().save(cidadao);
			return cidadao;
		} finally {
			LOGGER.debug("Fim da gravação dos dados do cidadão");
		}
	}

	/**
	 * @see br.gov.dataprev.portalatendimentoaps.service.CidadaoService#obterCidadao(br.gov.dataprev.portalatendimentoaps.entity.Cidadao)
	 */
	@Override
	public Cidadao obterCidadao(Cidadao cidadao) {
		LOGGER.debug("Obtendo cidadão ", cidadao);
		return cidadaoDao.obterCidadao(cidadao);
	}

	/**
	 * @see br.gov.dataprev.portalatendimentoaps.service.CidadaoService#salvar(br.gov.dataprev.portalatendimentoaps.entity.Cidadao)
	 */
	@Override
	@Transactional(readOnly = false)
	public Cidadao salvar(Cidadao cidadao) {
		LOGGER.debug("Atualizando cidadão ", cidadao);
		// cidadao.setDataAlteracao(new Date());
		return getCidadaoDao().update(cidadao);
	}

	/**
	 * @see br.gov.dataprev.portalatendimentoaps.service.CidadaoService#apagarCidadaos()
	 */
	@Override
	@Transactional(readOnly = false)
	public void apagarCidadaos() {
		getCidadaoDao().apagarCidadaos();
	}

	/**
	 * Método get...
	 *
	 * @return o dao
	 */
	public CidadaoDao getCidadaoDao() {
		return cidadaoDao;
	}

	/**
	 * Método que altera o dao
	 *
	 * @param cidadaoDao
	 *            - o novo dao
	 */
	public void setCidadaoDao(CidadaoDao cidadaoDao) {
		this.cidadaoDao = cidadaoDao;
	}

}