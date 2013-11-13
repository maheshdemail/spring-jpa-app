package com.gatewayjug.demoapp.service;

import java.util.List;

import com.gatewayjug.demoapp.common.BusinessConstants;
import com.gatewayjug.demoapp.common.WebConstants.ActionStatus;
import com.gatewayjug.demoapp.dto.EmployeeDto;

/**
* Employee Service at as business facade
* 
* @author Mahesh Desai
* @version $Revision: 1.0
*/
public interface IEmployeeService extends BusinessConstants {

	public List<EmployeeDto> loadAllEmployees();

	public EmployeeDto findEmployeById(String employeeId);

	public ActionStatus saveOrUpdateEmployee(EmployeeDto employeeDto);

	public void deleteEmployee(String employeeId);

}
