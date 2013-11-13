package com.gatewayjug.demoapp.assembler;

import com.gatewayjug.demoapp.common.BusinessConstants;
import com.gatewayjug.demoapp.dto.EmployeeDto;
import com.gatewayjug.demoapp.model.Employee;
import com.gatewayjug.demoapp.web.beans.EmployeeInformationBackingBean;

/**
 * Assembler interface converts Data Transfer Object to Business Objects and vice versa
 * 
 * @author Mahesh Desai
 * @version $1.0
 */
public interface IAssembler extends BusinessConstants {

	public void assembleBoFromDto(Employee bo, EmployeeDto dto);
	
	public EmployeeDto assembleDtoFromBo(Employee bo);
	
	public EmployeeInformationBackingBean assembleBackingBeanFromDto(EmployeeDto dto);
	
	public EmployeeDto assembleDtoFromBackingBean(EmployeeInformationBackingBean commond);
	
}
