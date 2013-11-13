package com.gatewayjug.demoapp.dao.impl.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.gatewayjug.demoapp.dao.IEmployeeSearchDao;
import com.gatewayjug.demoapp.model.Employee;
import com.gatewayjug.demoapp.model.Employee_;
import com.gatewayjug.demoapp.model.Gender;

/** 
 * 
 * 1. Data Access Object (DAO) for Employee Search Use Case
 * 
 * 2. JEE 5.0 Persistence Annotation (@PersistenceContext) is used to get EntityMananger instance 
 * 
 * 3. Every method runs in Transaction which is initiated in Service layer
 * 
 * 4. Transaction Scoped Persistence Context is used, and Need to be very very careful when 'FetchType.LAZY' is defined on Relationships
 * 
 * @author Mahesh Desai
 * @version $Revision: 1.0
 */
@Repository
public class JpaEmployeeSearchDaoImpl extends JpaGenericDaoImpl<Employee> implements IEmployeeSearchDao {

	@PersistenceContext /* JEE 5.0 Annotation */
	protected EntityManager entityManager;
	
	/* JPA Criteria APIs with Static MetaModel (JPA 2.0) */
	
	/****************************************** ORDER BY OPERATOR ******************************************/
	
	/* 
	 * Equivalent SQL Query:  
	 * 
	 * 		SELECT * FROM DEMO_EMPLOYEE EMP 
	 * 		ORDER BY EMP.F_NAME, EMP.L_NAME ASC 
	 */
	@Override
	public List<Employee> findAllEmployees() { /* With Static Canonical MetaModel */
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		
        CriteriaQuery<Employee> criteria = criteriaBuilder.createQuery(Employee.class);
        
        Root<Employee> entity = criteria.from(Employee.class);
        
        criteria.select(entity);
        
        criteria.orderBy(criteriaBuilder.asc(entity.get(Employee_.firstName)), criteriaBuilder.asc(entity.get(Employee_.lastName))); /* Safe & Strong Typed Version */
        
        return entityManager.createQuery(criteria).getResultList();
	}

	@Override
	public List<Employee> findAllEmployees_StaticQuery() { /* Static Queries which are attached to Employee JPA entity using @NamedQueries */
		return (List<Employee>) super.findByQueryName(EMPLOYEE_STATIC_QUERY_FIND_ALL_EMPLOYEES);
	}

	@Override
	public List<Employee> findAllEmployees_DynamicQuery() {
		return (List<Employee>) super.findByQuery("SELECT e FROM Employee e ORDER BY e.firstName, e.lastName ASC");
	}

	/****************************************** LIKE OPERATOR ******************************************/
	
	/*
	 * Equivalent SQL Query: 
	 * 
	 * 		SELECT * FROM DEMO_EMPLOYEE EMP 
	 * 		WHERE EMP.F_NAME LIKE ? OR EMP.L_NAME LIKE ? 
	 * 		ORDER BY EMP.F_NAME, EMP.L_NAME ASC
	 */
	@Override
	public List<Employee> findEmployeeByName(String name) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder(); 
		
		CriteriaQuery<Employee> criteria = criteriaBuilder.createQuery(Employee.class);
        
		Root<Employee> entity = criteria.from(Employee.class);

		criteria.select(entity);
		
		criteria.where(criteriaBuilder.or(criteriaBuilder.like(criteriaBuilder.upper(entity.<String>get(Employee_.firstName)), "%"+name+"%"), criteriaBuilder.like(criteriaBuilder.upper(entity.<String>get(Employee_.lastName)), "%"+name+"%")));
        
        criteria.orderBy(criteriaBuilder.asc(entity.get(Employee_.firstName)), criteriaBuilder.asc(entity.get(Employee_.lastName))); /* Safe & Strong Typed Version */
        
        return entityManager.createQuery(criteria).getResultList();
	}

	@Override
	public List<Employee> findEmployeeByName_StaticQuery(String name) {
		return (List<Employee>) super.findByQueryName(EMPLOYEE_STATIC_QUERY_FIND_EMPLOYEES_BY_NAME, "%"+name+"%", "%"+name+"%");
	}
	
	@Override
	public List<Employee> findEmployeeByName_DynamicQuery(String name) {
		return (List<Employee>) super.findByQuery("SELECT e FROM Employee e WHERE e.firstName LIKE ?1 OR e.lastName LIKE ?2 ORDER BY e.firstName, e.lastName ASC", "%"+name+"%", "%"+name+"%");
	}

	/****************************************** BETWEEN OPERATOR ******************************************/

	/* 
	 * Equivalent SQL Query:  
	 * 
	 * 		SELECT * FROM DEMO_EMPLOYEE EMP 
	 * 		WHERE EMP.SALARY BETWEEN ? AND ?
	 * 		ORDER BY EMP.F_NAME, EMP.L_NAME DESC 
	 */
	@Override
	public List<Employee> findEmployeeBySalaries_Between(Double minimumSalary, Double maximumSalary) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Employee> criteria = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> entity = criteria.from(Employee.class);
        
        criteria.select(entity);
        criteria.where(criteriaBuilder.between(entity.get(Employee_.salary), minimumSalary.doubleValue(), maximumSalary.doubleValue())); /* between() */
        criteria.orderBy(criteriaBuilder.desc(entity.get(Employee_.salary)));
        		
        return entityManager.createQuery(criteria).getResultList();
	}
	
	@Override
	public List<Employee> findEmployeeBySalaries_Between_StaticQuery(Double minimumSalary, Double maximumSalary) {
		return (List<Employee>) super.findByQueryName(EMPLOYEE_STATIC_QUERY_FIND_EMPLOYEES_BY_SALARIES_USING_BETWEEN, minimumSalary, maximumSalary);
	}

	@Override
	public List<Employee> findEmployeeBySalaries_Between_DynamicQuery(Double minimumSalary, Double maximumSalary) {
		return (List<Employee>) super.findByQuery("SELECT e FROM Employee e WHERE e.salary BETWEEN ?1 AND ?2 ORDER BY e.salary DESC" , minimumSalary, maximumSalary);
	}

	/****************************************** GREATER THAN OPERATOR ******************************************/
	
	/* 
	 * Equivalent SQL Query:  
	 * 
	 * 		SELECT * FROM DEMO_EMPLOYEE EMP 
	 * 		WHERE EMP.SALARY >= ?
	 * 		ORDER BY EMP.F_NAME, EMP.L_NAME DESC 
	 */
	@Override
	public List<Employee> findEmployeeBySalaries_GreaterThan(Double minimumSalary) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Employee> criteria = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> entity = criteria.from(Employee.class);
        
        criteria.select(entity);
        criteria.where(criteriaBuilder.greaterThanOrEqualTo(entity.get(Employee_.salary), minimumSalary.doubleValue())); /* greaterThanOrEqualTo() */
        criteria.orderBy(criteriaBuilder.desc(entity.get(Employee_.salary)));
        		
        return entityManager.createQuery(criteria).getResultList();
	}
	
	@Override
	public List<Employee> findEmployeeBySalaries_GreaterThan_StaticQuery(Double minimumSalary) {
		return (List<Employee>) super.findByQueryName(EMPLOYEE_STATIC_QUERY_FIND_EMPLOYEES_BY_SALARIES_USING_GREATER_THAN, minimumSalary);
	}

	@Override
	public List<Employee> findEmployeeBySalaries_GreaterThan_DynamicQuery(Double minimumSalary) {
		return (List<Employee>) super.findByQuery("FROM Employee e WHERE e.salary >= ?1 ORDER BY e.salary DESC", minimumSalary);
	}

	/****************************************** LESS THAN OPERATOR ******************************************/
	
	/* 
	 * Equivalent SQL Query:  
	 * 
	 * 		SELECT * FROM DEMO_EMPLOYEE EMP 
	 * 		WHERE EMP.SALARY <= ?
	 * 		ORDER BY EMP.F_NAME, EMP.L_NAME DESC 
	 */
	@Override
	public List<Employee> findEmployeeBySalaries_LessThan(Double maximumSalary) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Employee> criteria = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> entity = criteria.from(Employee.class);
        
        criteria.select(entity);
        criteria.where(criteriaBuilder.lessThanOrEqualTo(entity.get(Employee_.salary), maximumSalary.doubleValue())); /* lessThanOrEqualTo() */
        criteria.orderBy(criteriaBuilder.desc(entity.get(Employee_.salary)));
        		
        return entityManager.createQuery(criteria).getResultList();
	}

	@Override
	public List<Employee> findEmployeeBySalaries_LessThan_StaticQuery(Double maximumSalary) {
		return (List<Employee>) super.findByQueryName(EMPLOYEE_STATIC_QUERY_FIND_EMPLOYEES_BY_SALARIES_USING_LESS_THAN, maximumSalary);
	}
	
	@Override
	public List<Employee> findEmployeeBySalaries_LessThan_DynamicQuery(Double maximumSalary) {
		return (List<Employee>) super.findByQuery("FROM Employee e WHERE e.salary <= ?1 ORDER BY e.salary DESC", maximumSalary);
	}
	
	/****************************************** IN OPERATOR ******************************************/

	/* 
	 * Equivalent SQL Query:  
	 * 
	 * 		SELECT * FROM DEMO_EMPLOYEE EMP 
	 * 		WHERE EMP.GENDER IN (?)
	 * 		ORDER BY EMP.F_NAME, EMP.L_NAME ASC 
	 */
	@Override
	public List<Employee> findEmployeeByGender(String gender) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Employee> criteria = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> entity = criteria.from(Employee.class);
        
        criteria.select(entity);
        criteria.where(entity.get(Employee_.gender).in(gender)); /* in() */
        criteria.orderBy(criteriaBuilder.asc(entity.get(Employee_.firstName)), criteriaBuilder.asc(entity.get(Employee_.lastName))); 

        return entityManager.createQuery(criteria).getResultList();
	}
	
	@Override
	public List<Employee> findEmployeeByGender_StaticQuery(String gender) {
		return (List<Employee>) super.findByQueryName(EMPLOYEE_STATIC_QUERY_FIND_EMPLOYEES_BY_GENDER_USING_IN, "Male".equals(gender) ? Gender.Male : Gender.Female);
	}
	
	@Override
	public List<Employee> findEmployeeByGender_DynamicQuery(String gender) {
		return (List<Employee>) super.findByQuery("FROM Employee e WHERE e.gender IN (?1) ORDER BY e.firstName, e.lastName ASC", "Male".equals(gender) ? Gender.Male : Gender.Female);
	}
	
	/****************************************** JOIN FETCH OPERATOR ******************************************/
	
	/* 
	 * Equivalent SQL Query:  
	 * 
	 * 		SELECT * FROM DEMO_EMPLOYEE EMP 
	 * 		ORDER BY EMP.F_NAME, EMP.L_NAME ASC 
	 */
	@Override
	public List<Employee> findAllEmployeesUsingJoinFetch() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Employee> criteria = criteriaBuilder.createQuery(Employee.class);
		Root<Employee> entity = criteria.from(Employee.class);
		
		criteria.select(entity);
		
		entity.fetch(Employee_.phoneNumbers); /* JOIN FETCH with MetaModel - Safe & Strong Typed Version */
		
		criteria.distinct(true);
		
		criteria.orderBy(criteriaBuilder.asc(entity.get(Employee_.firstName)), criteriaBuilder.asc(entity.get(Employee_.lastName)));

		return entityManager.createQuery(criteria).getResultList();
	}

	@Override
	public List<Employee> findAllEmployeesUsingJoinFetch_StaticQuery() { /* Static Queries which are attached to Employee entity using @NamedQueries */
		List<Employee> employees = (List<Employee>) findByQueryName(EMPLOYEE_STATIC_QUERY_FIND_EMPLOYEES_USING_JOIN_FETCH);
		
		/* 
		 * Navigate the relationships if lazy loading is used so that PhoneNumbers will be available outside persistence context 
		 */
		if(employees != null) {
			for (Employee employee : employees) {
				employee.getPhoneNumbers().size();
			}
		}
		
		return employees;
	}
	
	@Override
	public List<Employee> findAllEmployeesUsingJoinFetch_DynamicQuery() {
		List<Employee> employees = (List<Employee>) findByQuery("FROM Employee e ORDER BY e.firstName, e.lastName ASC");
		
		/* 
		 * Navigate the relationships if lazy loading is used so that PhoneNumbers will be available outside persistence context 
		 */
		if(employees != null) {
			for (Employee employee : employees) {
				employee.getPhoneNumbers().size();
			}
		}
		
		return employees;
	}

}
