package com.gatewayjug.demoapp.dao;

import java.util.List;

import com.gatewayjug.demoapp.model.Employee;

/**
* Employee DAO interface
* 
* @author Mahesh Desai
* @version $Revision: 1.0
*/
public interface IEmployeeDao extends IGenericDao<Employee>{

	public List<Employee> loadAllEmployees();

	public Employee findEmployeById(String employeeId);


}
