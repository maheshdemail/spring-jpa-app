package com.gatewayjug.demoapp.dao.impl.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.gatewayjug.demoapp.dao.IEmployeeDao;
import com.gatewayjug.demoapp.model.Employee;
import com.gatewayjug.demoapp.model.Employee_;

/** 
 * 
 * 1. Data Access Object (DAO) for Add/Update/Delete Employees Use Case
 * 
 * 2. JEE 5.0 Persistence Annotation (@PersistenceContext) is used to get EntityMananger instance 
 * 
 * 3. Every method runs in Transaction which is initiated in Service layer
 * 
 * @author Mahesh Desai
 * @version $Revision: 1.0
 */
@Repository
public class JpaEmployeeDaoImpl extends JpaGenericDaoImpl<Employee> implements IEmployeeDao {

	@PersistenceContext
	protected EntityManager entityMananger;
	
	/* JPA Criteria APIs (JPA 2.0) */
	
	@Override
	public List<Employee> loadAllEmployees() {
		CriteriaBuilder cb = entityMananger.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = cb.createQuery(Employee.class);
        Root<Employee> entity = criteria.from(Employee.class);
        criteria.orderBy(cb.asc(entity.get(Employee_.firstName)), cb.asc(entity.get(Employee_.lastName)));

        return entityMananger.createQuery(criteria).getResultList();
	}

	@Override
	public Employee findEmployeById(String employeeId) {
		return entityMananger.find(Employee.class, Long.valueOf(employeeId));
	}

}
