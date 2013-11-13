package com.gatewayjug.demoapp.dao;

import java.util.List;

import com.gatewayjug.demoapp.common.DaoConstants;
import com.gatewayjug.demoapp.model.BaseEntity;

/**
 * <p>Generic DAO (Data Access Object) with common methods to CRUD POJOs.</p>
 * 
 * <p>This interface is suggested in order to minimize custom code, and to
 * promote Spring Dao best practices.<br/>
 * Please note that this interface is just a convenient interface.
 * We should not be forced to use it if we think it doesn't express the functionality
 * of our use case.</p>
 * 
 * @param <E> the entity object
 * 
 * @author Mahesh Desai
 * @version $Revision: 1.0
 */
public interface IGenericDao<E extends BaseEntity> extends DaoConstants {

	/**
	 * This method creates the entity on the database.
	 * 
	 * @param entity the entity
	 */
	public void save(E entity);

	/**
	 * This method updates the database.
	 * 
	 * @param entity the entity
	 */
	public void merge(E entity);

	/**
	 * This method deletes <code>E</code> from the database.
	 * 
	 * @param entity the entity
	 */
	public void delete(E entity);
	
	/**
     * Find using a named query.
     *
     * @param queryName the name of the query
     * @param params the query parameters
     *
     * @return the list of entities
     */
	public List<E> findByQuery(final String queryName, Object... params);
	
	/**
	 * Find by query name.
	 * 
	 * @param queryName the query name
	 * @param params the params
	 * 
	 * @return the list< e>
	 */
	public List<E> findByQueryName(final String queryName, Object... params);
	
}