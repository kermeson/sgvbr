package br.com.kermeson.sgvbr.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import br.com.kermeson.sgvbr.dao.CidadaoDao;
import br.com.kermeson.sgvbr.entity.Cidadao;

/**
 * Classe que realiza a manipulação de objetos do tipo Cidadao
 *
 * @author richard.madureira
 */
@Repository("cidadaoDao")
@SuppressWarnings("unchecked")
public class CidadaoDaoImpl extends AbstractDaoImpl<Cidadao>implements CidadaoDao {
	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = LoggerFactory.getLogger(CidadaoDaoImpl.class);

	/**
	 * Método construtor padrão
	 */
	public CidadaoDaoImpl() {
		setClazz(Cidadao.class);
	}

	@Override
	public List<Cidadao> obterListaCidadaoPorCpf(Long cpf) {
		LOGGER.debug("Iniciando pesquisa de cidadãos a partir do CPF ", cpf);
		try {
			Query query = entityManager.createNamedQuery("obterListaCidadaoPorCpf");
			query.setParameter("cpf", cpf);
			return query.getResultList();
		} finally {
			LOGGER.debug("Fim da pesquisa de cidadão a partir do CPF");
		}
	}

	@Override
	public List<Cidadao> obterListaCidadaoPorNit(Long nit) {
		LOGGER.debug("Iniciando pesquisa de cidadãos a partir do NIT ", nit);
		try {
			Query query = entityManager.createNamedQuery("obterListaCidadaoPorNit");
			query.setParameter("nit", nit);
			return query.getResultList();
		} finally {
			LOGGER.debug("Fim da pesquisa de cidadãos a partir do NIT");
		}
	}

	@Override
	public List<Cidadao> obterListaCidadaoPorNome(String nome) {
		LOGGER.debug("Iniciando pesquisa de cidadãos a partir do nome ", nome);
		try {
			Query query = entityManager.createNamedQuery("obterListaCidadaoPorNome");
			query.setParameter("nome", nome);
			return query.getResultList();
		} finally {
			LOGGER.debug("Fim da pesquisa de cidadãos a partir do nome");
		}
	}

	@Override
	public List<Cidadao> obterListaCidadaoPorExemplo(Cidadao cidadao) {
		LOGGER.debug("Iniciando pesquisa de cidadãos pelo exemplo ", cidadao);
		String qlString = "select c from Cidadao c where ";
		Map<String, Object> parametros = new HashMap<>();
		// if (cidadao.getCpf() != null) {
		// qlString = qlString.concat("c.cpf = :cpf and ");
		// parametros.put("cpf", cidadao.getCpf());
		// }
		// if (cidadao.getNit() != null) {
		// qlString = qlString.concat("c.nit = :nit and ");
		// parametros.put("nit", cidadao.getNit());
		// }
		// if (cidadao.getNb() != null) {
		// qlString = qlString.concat("c.nb = :nb and ");
		// parametros.put("nb", cidadao.getNb());
		// }
		// if (StringUtils.isNotBlank(cidadao.getNome())) {
		// qlString = qlString.concat("c.nome like :nome");
		// parametros.put("nome", "%" + cidadao.getNome() + "%");
		// }
		// qlString = StringUtils.removeEnd(qlString, " where ");
		// qlString = StringUtils.removeEnd(qlString, " and ");
		Query query = entityManager.createQuery(qlString);
		for (Entry<String, Object> parametro : parametros.entrySet()) {
			query.setParameter(parametro.getKey(), parametro.getValue());
		}
		try {
			return query.getResultList();
		} finally {
			LOGGER.debug("Fim da pesquisa de cidadãos pelo exemplo");
		}
	}

	/**
	 * @see br.gov.dataprev.portalatendimentoaps.dao.CidadaoDao#obterCidadao(br.gov.dataprev.portalatendimentoaps.entity.Cidadao)
	 */
	@Override
	public Cidadao obterCidadao(Cidadao cidadao) {
		LOGGER.debug("Iniciando pesquisa de Cidadão ", cidadao);
		String qlString = "select c from Cidadao c where ";
		Map<String, Object> parametros = new HashMap<>();
		// if (cidadao.getCpf() != null) {
		// qlString = qlString.concat("c.cpf = :cpf and ");
		// parametros.put("cpf", cidadao.getCpf());
		// } else {
		// qlString = qlString.concat("c.cpf is null and ");
		// }
		// if (cidadao.getNit() != null) {
		// qlString = qlString.concat("c.nit = :nit and ");
		// parametros.put("nit", cidadao.getNit());
		// } else {
		// qlString = qlString.concat("c.nit is null and ");
		// }
		if (cidadao.getDataNascimento() != null) {
			qlString = qlString.concat("c.dataNascimento = :dataNascimento and ");
			parametros.put("dataNascimento", cidadao.getDataNascimento());
		} else {
			qlString = qlString.concat("c.dataNascimento is null and ");
		}
		if (cidadao.getNome() != null) {
			qlString = qlString.concat("c.nome = :nome and ");
			parametros.put("nome", cidadao.getNome());
		} else {
			qlString = qlString.concat("c.nome is null and ");
		}
		if (cidadao.getNomeMae() != null) {
			qlString = qlString.concat("c.nomeMae = :nomeMae");
			parametros.put("nomeMae", cidadao.getNomeMae());
		} else {
			qlString = qlString.concat("c.nomeMae is null");
		}
		// qlString = StringUtils.removeEnd(qlString, " where ");
		// qlString = StringUtils.removeEnd(qlString, " and ");
		Query query = entityManager.createQuery(qlString);
		for (Entry<String, Object> parametro : parametros.entrySet()) {
			query.setParameter(parametro.getKey(), parametro.getValue());
		}
		try {
			return (Cidadao) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		} finally {
			LOGGER.debug("Fim da pesquisa de cidadão");
		}
	}

	/**
	 * @see br.gov.dataprev.portalatendimentoaps.dao.CidadaoDao#apagarCidadaos()
	 */
	@Override
	public void apagarCidadaos() {
		int numeroExclusoes = 0;
		try {
			numeroExclusoes = entityManager.createNamedQuery("apagarCidadaos").executeUpdate();
		} finally {
			LOGGER.debug("Número de cidadaos excluídos: " + numeroExclusoes);
		}
	}

}