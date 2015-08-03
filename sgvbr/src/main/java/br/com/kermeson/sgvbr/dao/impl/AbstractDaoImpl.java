package br.com.kermeson.sgvbr.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.kermeson.sgvbr.dao.AbstractDao;

/**
 * Classe que possui as implementações genéricas para manipulação de entidades
 * pelas classes Dao.
 *
 * @author richard.madureira
 * @param <T>
 *            - a classe que será manipulada pelo dao
 */
public abstract class AbstractDaoImpl<T extends Serializable> implements AbstractDao<T>, Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractDaoImpl.class);

	private Class<T> clazz;

	@PersistenceContext
	protected EntityManager entityManager;

	@Override
	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	/**
	 * Método que altera o tipo de classe do Dao
	 *
	 * @param clazzToSet
	 *            - o novo tipo da classe
	 */
	public void setClazz(Class<T> clazzToSet) {
		this.clazz = clazzToSet;
	}

	/**
	 * @see br.com.kermeson.sgvbr.dao.AbstractDao#find(Object)
	 */
	@Override
	public T find(Object id) {
		LOGGER.debug("Pesquisando entidade {}. ID: {}", clazz.getSimpleName(), id);
		return this.entityManager.find(this.clazz, id);
	}

	/**
	 * @see br.com.kermeson.sgvbr.dao.AbstractDao#findAll()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		LOGGER.debug("Pesquisando todos os objetos da entidade {}", clazz.getSimpleName());
		return this.entityManager.createQuery("from " + this.clazz.getName()).getResultList();
	}

	/**
	 * @see br.com.kermeson.sgvbr.dao.AbstractDao#save(java.io.Serializable)
	 */
	@Override
	public void save(T entidade) {
		LOGGER.debug("Salvando objeto da entidade {}", clazz.getSimpleName());
		this.entityManager.persist(entidade);
	}

	@Override
	public T update(T entidade) {
		LOGGER.debug("Atualizando objeto da entidade {}", clazz.getSimpleName());
		T merge = this.entityManager.merge(entidade);
		return merge;
	}

	/**
	 * @see br.com.kermeson.sgvbr.dao.AbstractDao#delete(java.io.Serializable)
	 */
	@Override
	public void delete(T entidade) {
		LOGGER.debug("Excluindo objeto da entidade {}", clazz.getSimpleName());
		this.entityManager.remove(entidade);
	}

	/**
	 * @see br.com.kermeson.sgvbr.dao.AbstractDao#deleteById(java.lang.Long)
	 */
	@Override
	public void deleteById(Long id) {
		LOGGER.debug("Excluíndo objeto da entidade {}. ID: {}", clazz.getSimpleName(), id);
		T entity = this.entityManager.getReference(clazz, id);
		this.delete(entity);
	}

	/**
	 * @see br.com.kermeson.sgvbr.dao.AbstractDao#getReference(java.lang.Long)
	 */
	@Override
	public T getReference(Long id) {
		LOGGER.debug("Pesquisando referencia do objeto da entidade {}. ID: {}", clazz.getSimpleName(), id);
		return this.entityManager.getReference(clazz, id);
	}

	/**
	 * @see br.com.kermeson.sgvbr.dao.AbstractDao#flush()
	 */
	@Override
	public void flush() {
		this.entityManager.flush();
	}
}