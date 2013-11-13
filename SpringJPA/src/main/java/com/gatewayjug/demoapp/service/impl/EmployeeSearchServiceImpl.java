package com.gatewayjug.demoapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gatewayjug.demoapp.assembler.IAssembler;
import com.gatewayjug.demoapp.common.JpaMethod;
import com.gatewayjug.demoapp.dao.IEmployeeSearchDao;
import com.gatewayjug.demoapp.dto.EmployeeDto;
import com.gatewayjug.demoapp.model.Employee;
import com.gatewayjug.demoapp.service.IEmployeeSearchService;

/**
 * 1. Acts as Facade 
 * 2. Every method runs in Transaction 
 * 3. Transaction Scoped Persistence Context is used
 * 
 * @author Mahesh Desai
 * @version $Revision: 1.0
 */
@Service
@Transactional(readOnly = true)
public class EmployeeSearchServiceImpl implements IEmployeeSearchService {

	@Autowired
	private IEmployeeSearchDao iEmployeeSearchDao;
	
	@Autowired
	private IAssembler iAssembler;
	
	@Override
	public List<EmployeeDto> findAllEmployees(JpaMethod jpaMethod) {
		List<Employee> employees = null;
		List<EmployeeDto> employeeDtos = null;
		
		switch (jpaMethod) {
			case CRITERIA_API_METAMODEL:
				employees = iEmployeeSearchDao.findAllEmployees();
				
				break;
			case STATIC_QUERIES:
				employees = iEmployeeSearchDao.findAllEmployees_StaticQuery();
				
				break;
			case DYNAMIC_QUERIES:
				employees = iEmployeeSearchDao.findAllEmployees_DynamicQuery();
				
				break;
		}
		
		employeeDtos = assembleResult(employees, employeeDtos);
		
		return employeeDtos;
	}

	@Override
	public List<EmployeeDto> findEmployeeByName(JpaMethod jpaMethod, String name) {
		List<Employee> employees = null;
		List<EmployeeDto> employeeDtos = null;
		
		switch (jpaMethod) {
			case CRITERIA_API_METAMODEL:
				employees = iEmployeeSearchDao.findEmployeeByName(name);
				
				break;
			case STATIC_QUERIES:
				employees = iEmployeeSearchDao.findEmployeeByName_StaticQuery(name);
				
				break;
			case DYNAMIC_QUERIES:
				employees = iEmployeeSearchDao.findEmployeeByName_DynamicQuery(name);
				
				break;
		}
		
		employeeDtos = assembleResult(employees, employeeDtos);
		
		return employeeDtos;
	}

	@Override
	public List<EmployeeDto> findEmployeeBySalaryRange(JpaMethod jpaMethod, Double minimumSalary, Double maximumSalary) {
		List<Employee> employees = null;
		List<EmployeeDto> employeeDtos = null;
		
		switch (jpaMethod) {
			case CRITERIA_API_METAMODEL:
				employees = iEmployeeSearchDao.findEmployeeBySalaries_Between(minimumSalary, maximumSalary);
				
				break;
			case STATIC_QUERIES:
				employees = iEmployeeSearchDao.findEmployeeBySalaries_Between_StaticQuery(minimumSalary, maximumSalary);
				
				break;
			case DYNAMIC_QUERIES:
				employees = iEmployeeSearchDao.findEmployeeBySalaries_Between_DynamicQuery(minimumSalary, maximumSalary);
				
				break;
		}
		
		employeeDtos = assembleResult(employees, employeeDtos);
		
		return employeeDtos;
	}
	
	@Override
	public List<EmployeeDto> findEmployeeByMaximumSalary(JpaMethod jpaMethod, Double maximumSalary) {
		List<Employee> employees = null;
		List<EmployeeDto> employeeDtos = null;
		
		switch (jpaMethod) {
			case CRITERIA_API_METAMODEL:
				employees = iEmployeeSearchDao.findEmployeeBySalaries_LessThan(maximumSalary);
				
				break;
			case STATIC_QUERIES:
				employees = iEmployeeSearchDao.findEmployeeBySalaries_LessThan_StaticQuery(maximumSalary);
				
				break;
			case DYNAMIC_QUERIES:
				employees = iEmployeeSearchDao.findEmployeeBySalaries_LessThan_DynamicQuery(maximumSalary);
				
				break;
		}
		
		employeeDtos = assembleResult(employees, employeeDtos);
		
		return employeeDtos;
	}

	@Override
	public List<EmployeeDto> findEmployeeByMinumumSalary(JpaMethod jpaMethod, Double minimumSalary) {
		List<Employee> employees = null;
		List<EmployeeDto> employeeDtos = null;
		
		switch (jpaMethod) {
			case CRITERIA_API_METAMODEL:
				employees = iEmployeeSearchDao.findEmployeeBySalaries_GreaterThan(minimumSalary);
				
				break;
			case STATIC_QUERIES:
				employees = iEmployeeSearchDao.findEmployeeBySalaries_GreaterThan_StaticQuery(minimumSalary);
				
				break;
			case DYNAMIC_QUERIES:
				employees = iEmployeeSearchDao.findEmployeeBySalaries_GreaterThan_DynamicQuery(minimumSalary);
				
				break;
		}
		
		employeeDtos = assembleResult(employees, employeeDtos);
		
		return employeeDtos;
	}

	@Override
	public List<EmployeeDto> findEmployeeByGenderIn(JpaMethod jpaMethod, String gender) {
		List<Employee> employees = null;
		List<EmployeeDto> employeeDtos = null;
		
		gender = "M".equals(gender) ? "Male" : "Female";
		
		switch (jpaMethod) {
			case CRITERIA_API_METAMODEL:
				employees = iEmployeeSearchDao.findEmployeeByGender(gender);
				
				break;
			case STATIC_QUERIES:
				employees = iEmployeeSearchDao.findEmployeeByGender_StaticQuery(gender);
				
				break;
			case DYNAMIC_QUERIES:
				employees = iEmployeeSearchDao.findEmployeeByGender_DynamicQuery(gender);
				
				break;
		}
		
		employeeDtos = assembleResult(employees, employeeDtos);
		
		return employeeDtos;
	}

	@Override
	public List<EmployeeDto> findAllEmployeeUsingJoinFetch(JpaMethod jpaMethod) {
		List<Employee> employees = null;
		List<EmployeeDto> employeeDtos = null;
		
		switch (jpaMethod) {
			case CRITERIA_API_METAMODEL:
				employees = iEmployeeSearchDao.findAllEmployeesUsingJoinFetch();
				
				break;
			case STATIC_QUERIES:
				employees = iEmployeeSearchDao.findAllEmployeesUsingJoinFetch_StaticQuery();
				
				break;
			case DYNAMIC_QUERIES:
				employees = iEmployeeSearchDao.findAllEmployeesUsingJoinFetch_DynamicQuery();
				
				break;
		}
		
		employeeDtos = assembleResult(employees, employeeDtos);
		
		return employeeDtos;
	}
	
	private List<EmployeeDto> assembleResult(List<Employee> employees, List<EmployeeDto> employeeDtos) {
		if(employees != null){
			employeeDtos = new ArrayList<EmployeeDto>();
			
			for (Employee employeeBo : employees) {
				EmployeeDto employeeDto = iAssembler.assembleDtoFromBo(employeeBo);
				employeeDtos.add(employeeDto);
			}
		}
		
		return employeeDtos;
	}
}
