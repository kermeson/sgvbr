package br.com.kermeson.sgvbr.dao;

import java.util.List;

import br.com.kermeson.sgvbr.entity.Cidadao;

/**
 * Interface que realiza a manipulação de objetos do tipo Cidadao
 *
 * @author richard.madureira
 */
public interface CidadaoDao extends AbstractDao<Cidadao> {

	/**
	 * Método que retorna a lista de cidadãos para um cpf
	 *
	 * @param cpf
	 *            - o cpf do(s) cidadão(s)
	 * @return a lista de cidadãos que possuem o cpf informado, ou uma lista
	 *         vazia, caso não encontre nenhum Cidadao
	 */
	List<Cidadao> obterListaCidadaoPorCpf(Long cpf);

	/**
	 * Método que retorna a lista de cidadãos para um NIT
	 *
	 * @param nit
	 *            - o nit do(s) cidadão(s)
	 * @return a lista de cidadãos que possuem o nit informado, ou uma lista
	 *         vazia, caso não encontre nenhum Cidadao
	 */
	List<Cidadao> obterListaCidadaoPorNit(Long nit);

	/**
	 * Método que retorna a lista de cidadãos para um nome
	 *
	 * @param nome
	 *            - o nome do(s) cidadão(s)
	 * @return a lista de cidadãos que possuem o nome informado, ou uma lista
	 *         vazia, caso não encontre nenhum Cidadao
	 */
	List<Cidadao> obterListaCidadaoPorNome(String nome);

	/**
	 * Método que retorna a lista de cidadãos a partir de uma entidade exemplo
	 * (query by sample)
	 *
	 * @param cidadao
	 *            - a entidade com as informações do cidadao desejado
	 * @return - a lista de Cidadaos que atém aos parâmetros informados, ou uma
	 *         lista vazia, caso não encontre nenhum Cidadao.
	 */
	List<Cidadao> obterListaCidadaoPorExemplo(Cidadao cidadao);

	/**
	 * Obtem o cidadao pelo nit, cpf, nome, nome da mãe e data de nascimento.
	 * Utiliza o mesmo critério do <code>equals()</code>.
	 *
	 * @param cidadao
	 * @return
	 */
	Cidadao obterCidadao(Cidadao cidadao);

	/**
	 * Método que exclui os cidadãos durante o processo noturno.
	 */
	void apagarCidadaos();

}