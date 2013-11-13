package com.gatewayjug.demoapp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gatewayjug.demoapp.model.Employee;

/**
* Employee search DAO interface
* 
* @author Mahesh Desai
* @version $Revision: 1.0
*/
@Repository
public interface IEmployeeSearchDao extends IGenericDao<Employee> {

	public List<Employee> findAllEmployees();
	public List<Employee> findAllEmployees_StaticQuery();
	public List<Employee> findAllEmployees_DynamicQuery();
	
	public List<Employee> findEmployeeByName(String name);
	public List<Employee> findEmployeeByName_StaticQuery(String name);
	public List<Employee> findEmployeeByName_DynamicQuery(String name);
	
	public List<Employee> findEmployeeBySalaries_Between(Double minimumSalary, Double maximumSalary);
	public List<Employee> findEmployeeBySalaries_Between_DynamicQuery(Double minimumSalary, Double maximumSalary);
	public List<Employee> findEmployeeBySalaries_Between_StaticQuery(Double minimumSalary, Double maximumSalary);
	
	public List<Employee> findEmployeeBySalaries_GreaterThan(Double minimumSalary);
	public List<Employee> findEmployeeBySalaries_GreaterThan_StaticQuery(Double minimumSalary);
	public List<Employee> findEmployeeBySalaries_GreaterThan_DynamicQuery(Double minimumSalary);
	
	public List<Employee> findEmployeeBySalaries_LessThan(Double maximumSalary);
	public List<Employee> findEmployeeBySalaries_LessThan_StaticQuery(Double maximumSalary);
	public List<Employee> findEmployeeBySalaries_LessThan_DynamicQuery(Double maximumSalary);
	
	public List<Employee> findEmployeeByGender(String gender);
	public List<Employee> findEmployeeByGender_StaticQuery(String gender);
	public List<Employee> findEmployeeByGender_DynamicQuery(String gender);
	
	public List<Employee> findAllEmployeesUsingJoinFetch();
	public List<Employee> findAllEmployeesUsingJoinFetch_StaticQuery();
	public List<Employee> findAllEmployeesUsingJoinFetch_DynamicQuery();

}
