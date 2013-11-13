package com.gatewayjug.demoapp.dao.impl.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.gatewayjug.demoapp.dao.IGenericDao;
import com.gatewayjug.demoapp.model.BaseEntity;

/**
 * <p>
 * Generic DAO (Data Access Object) implementation with common methods to
 * <b>CRUD</b> POJOs.
 * </p>
 * 
 * <p>
 * This interface is suggested in order to minimize custom code, and to promote
 * Spring Dao best practices.<br/>
 * 
 * Please note that this interface is just a convenient interface. We should not
 * be forced to use it if we think it doesn't express the functionality of our
 * use case.
 * </p>
 * 
 * JEE 5.0 Persistence Annotation (@PersistenceContext) is used to get EntityMananger instance 
 * 
 * @param <E> the entity type
 * 
 * @author Mahesh Desai
 * @version $Revision: 1.0
 */
@Repository
public class JpaGenericDaoImpl<E extends BaseEntity> implements IGenericDao<E> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The entity manager. */
	@PersistenceContext
	public EntityManager entityManager;

	/** (non-Javadoc)
	 * @see com.opensource.jee.dao.IGenericDao#save(com.opensource.jee.latest.model.BaseEntity)
	 */
	public void save(E entity) {
		Assert.notNull(entity, DAO_ADD_ENTITY_CANNOT_NULL);

		this.entityManager.persist(entity);  /* persist() to insert new database row */
		this.entityManager.flush();
	}

	/** (non-Javadoc)
	 * @see com.opensource.jee.dao.IGenericDao#merge(com.opensource.jee.latest.model.BaseEntity)
	 */
	public void merge(E entity) {
		Assert.notNull(entity, DAO_UPDATE_ENTITY_CANNOT_NULL);

		this.entityManager.merge(entity); /* merge() to update the existing database row */
		this.entityManager.flush();
	}

	/** (non-Javadoc)
	 * @see com.opensource.jee.dao.IGenericDao#findByQuery(java.lang.String, java.lang.Object[])
	 */
	@SuppressWarnings("unchecked")
	public List<E> findByQuery(String queryName, Object... params) {
		Assert.notNull(queryName, DAO_SQL_QUERY_CANNOT_NULL);

		Query query = this.entityManager.createQuery(queryName); /* createQuery() API is used for Dynamic Queries */

		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i + 1, params[i]);
			}
		}

		return (List<E>) query.getResultList(); /* Actual JDBC Call */
	}

	/** (non-Javadoc)
	 * @see com.opensource.jee.dao.IGenericDao#findByQueryName(java.lang.String, java.lang.Object[])
	 */
	@SuppressWarnings("unchecked")
	public List<E> findByQueryName(String queryName, Object... params) {
		Assert.notNull(queryName, DAO_SQL_QUERY_CANNOT_NULL);

		Query query = this.entityManager.createNamedQuery(queryName); /* createNamedQuery() API is used for Named Queries */

		if (params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i + 1, params[i]);
			}
		}

		return (List<E>) query.getResultList(); /* Actual JDBC Call */
	}

	/** (non-Javadoc)
	 * @see com.opensource.jee.dao.IGenericDao#delete(com.opensource.jee.latest.model.BaseEntity)
	 */
	public void delete(E entity) {
		Assert.notNull(entity, DAO_ADD_ENTITY_CANNOT_NULL);

		this.entityManager.remove(entity); /* remove() to delete the database row */
		this.entityManager.flush();
	}

}