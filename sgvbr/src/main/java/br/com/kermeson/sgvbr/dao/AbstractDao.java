package br.com.kermeson.sgvbr.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

/**
 * Interface genérica para criação de Daos para Entidades
 *
 * @author kermeson.martins
 * @param <T>
 *            - o tipo de entidade que será manipulada no Dao
 */
public interface AbstractDao<T extends Serializable> {

	/**
	 * Método que retorna a instância do objeto desejado a partir de seu id
	 *
	 * @param id
	 *            - o id do objeto desejado
	 * @return - a instância do objeto desejado, ou null, caso não encontre
	 *         nenhum objeto associado ao id informado
	 */
	T find(Object id);

	/**
	 * Método que retorna a lista de todos os objetos do tipo informado no
	 * parâmetro genérico
	 *
	 * @return a lista de todos oso objetos
	 */
	List<T> findAll();

	/**
	 * Método que realiza a persistência da entidade no banco de dados
	 *
	 * @param entidade
	 *            - a entidade a ser gravada no banco de dados
	 */
	void save(T entidade);

	/**
	 * Método que realiza a alteração de uma entidade existente no banco de
	 * dados
	 *
	 * @param entidade
	 *            - a entidade a ser alterada
	 * @return - a entidade alterada
	 */
	T update(T entidade);

	/**
	 * Método que exclui do banco de dados uma determinada entidade
	 *
	 * @param entidade
	 *            a entidade a ser excluída do banco de dados
	 */
	void delete(T entidade);

	/**
	 * Método que exclui do banco de dados uma determinada entidade a partir do
	 * seu id informado.
	 *
	 * @param id
	 *            - o id da entidade a ser excluída do banco de dados
	 */
	void deleteById(Long id);

	/**
	 * Método que retorna a entidade com apenas o seu id preenchido
	 *
	 * @param id
	 *            - o id da entidade desejada
	 * @return a instância da entidade apenas com o seu id informado, ou null,
	 *         caso não encontre o objeto no banco de dados
	 */
	T getReference(Long id);

	/**
	 * Synchronize the persistence context to the underlying database.
	 */
	void flush();

	EntityManager getEntityManager();

}