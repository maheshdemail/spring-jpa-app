package com.gatewayjug.demoapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.gatewayjug.demoapp.assembler.IAssembler;
import com.gatewayjug.demoapp.common.WebConstants.ActionStatus;
import com.gatewayjug.demoapp.dao.IEmployeeDao;
import com.gatewayjug.demoapp.dto.EmployeeDto;
import com.gatewayjug.demoapp.model.Degree;
import com.gatewayjug.demoapp.model.Employee;
import com.gatewayjug.demoapp.model.PhoneNumber;
import com.gatewayjug.demoapp.service.IEmployeeService;

/** 
 * 1. Acts as Facade
 * 2. Every method runs in Transaction
 * 3. Transaction Scoped Persistence Context is used
 *
 * @author Mahesh Desai
 * @version $Revision: 1.0
 */
@Service
@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
public class EmployeeServiceImpl implements IEmployeeService {

	/** 
	 * Object Assembler 
	 * 
	 * Command Object --> DTO
	 * DTO --> BO 
	 * BO --> DTO 
	 * DTO --> Command Object
	 */
	@Autowired
	private IAssembler iAssembler; 

	@Autowired
	private IEmployeeDao iEmployeeDao;
	
	@Override
	public ActionStatus saveOrUpdateEmployee(EmployeeDto employeeDto) {
		if(!StringUtils.hasLength(employeeDto.getEmployeeId())){ 
			/* Creates New Employee */
			
			Employee employee = new Employee();
			
			iAssembler.assembleBoFromDto(employee, employeeDto);
			
			iEmployeeDao.save(employee);
			
			return ActionStatus.SAVE;
		} else { 
			/* Updates Existing Employee */
			
			Employee employee = iEmployeeDao.findEmployeById(employeeDto.getEmployeeId());
			
			updateDependents(employee);
			
			iAssembler.assembleBoFromDto(employee, employeeDto);
			
			iEmployeeDao.merge(employee);
			
			return ActionStatus.UPDATE;
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public EmployeeDto findEmployeById(String employeeId) {
		return iAssembler.assembleDtoFromBo(iEmployeeDao.findEmployeById(employeeId));
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<EmployeeDto> loadAllEmployees() {
		
		List<EmployeeDto> employeeDtos = new ArrayList<EmployeeDto>();
		List<Employee> employees = iEmployeeDao.loadAllEmployees();
		
		for (Employee employeeBo : employees) {
			EmployeeDto employeeDto = iAssembler.assembleDtoFromBo(employeeBo);
			
			employeeDtos.add(employeeDto);
		}
		
		return employeeDtos;
	}

	@Override
	public void deleteEmployee(String employeeId) {
		Employee employee = iEmployeeDao.findEmployeById(employeeId);
		
		if(employee != null){
			iEmployeeDao.delete(employee);
		}
	}
	
	private void updateDependents(Employee employee) {
		List<Degree> degrees = employee.getDegrees();
		List<String> responsibilities = employee.getResponsibilities();
		List<PhoneNumber> phoneNumbers = employee.getPhoneNumbers();

		List<Degree> degreesToBeRemoved = new ArrayList<Degree>();
		List<String> responsibilitiesToBeRemoved = new ArrayList<String>();
		List<PhoneNumber> phoneNumbersToBeRemoved = new ArrayList<PhoneNumber>();
		
		if(phoneNumbers != null){
			for (PhoneNumber phoneNumber : phoneNumbers) {
				phoneNumbersToBeRemoved.add(phoneNumber);
			}
		}
		
		for (PhoneNumber phoneNumber : phoneNumbersToBeRemoved) {
			employee.getPhoneNumbers().remove(phoneNumber);
		}
		
		if(degrees != null){
			for (Degree degree : degrees) {
				degreesToBeRemoved.add(degree);
			}
		}
		
		for (Degree degree : degreesToBeRemoved) {
			employee.getDegrees().remove(degree);
		}
		
		if(responsibilities != null){
			for (String responsibility : responsibilities) {
				responsibilitiesToBeRemoved.add(responsibility);
			}
		}
		
		for (String degree : responsibilitiesToBeRemoved) {
			employee.getResponsibilities().remove(degree);
		}
	}
	
}
