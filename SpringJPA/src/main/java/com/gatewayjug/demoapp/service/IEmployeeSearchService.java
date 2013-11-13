package com.gatewayjug.demoapp.service;

import java.util.List;

import com.gatewayjug.demoapp.common.BusinessConstants;
import com.gatewayjug.demoapp.common.JpaMethod;
import com.gatewayjug.demoapp.dto.EmployeeDto;

/**
* Employee Search service at as business facade
* 
* @author Mahesh Desai
* @version $Revision: 1.0
*/
public interface IEmployeeSearchService extends BusinessConstants {

	public List<EmployeeDto> findAllEmployees(JpaMethod jpaMethod);

	public List<EmployeeDto> findEmployeeByName(JpaMethod jpaMethod, String name);

	public List<EmployeeDto> findEmployeeBySalaryRange(JpaMethod jpaMethod, Double minimumSalary, Double maximumSalary);
	
	public List<EmployeeDto> findEmployeeByMinumumSalary(JpaMethod jpaMethod, Double minimumSalary);
	
	public List<EmployeeDto> findEmployeeByMaximumSalary(JpaMethod jpaMethod, Double maximumSalary);
	
	public List<EmployeeDto> findEmployeeByGenderIn(JpaMethod jpaMethod, String gender);

	public List<EmployeeDto> findAllEmployeeUsingJoinFetch(JpaMethod jpaMethod);

}
