package com.gatewayjug.demoapp.web.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.util.WebUtils;

import com.gatewayjug.demoapp.assembler.IAssembler;
import com.gatewayjug.demoapp.dto.EmployeeDto;
import com.gatewayjug.demoapp.service.IEmployeeService;
import com.gatewayjug.demoapp.web.beans.EmployeeInformationBackingBean;
import com.gatewayjug.demoapp.web.validators.EmployeeInformationValidator;

/**
* CRUD controller
* 
* @author Mahesh Desai
* @version $Revision: 1.0
*/
@Controller
public class CrudController extends BaseController {
	private Logger logger = LoggerFactory.getLogger(CrudController.class);
	
	@Autowired
	private IEmployeeService iEmployeeService;
	
	@Autowired
	private EmployeeInformationValidator validator;
	
	@Autowired
	private IAssembler iAssembler;
	
	@RequestMapping(value = "/addEmployee.do", method = RequestMethod.GET)
	public String viewAddEmployeeScreen(Model model, HttpServletRequest request) {
		logger.info("AddEmployeeController > viewAddEmployeeScreen");

		model.addAttribute("employeeInformationModel", new EmployeeInformationBackingBean());
		model.addAttribute("isAddEmployeeUseCase", true);
		
		checkSuccessfulFormSubmission(request);
		
		return VIEW_ADD_EMPLOYEE;
	}
	
	@RequestMapping(value = "/updateEmployee.do", method = RequestMethod.GET)
	public String viewUpdateEmployeeScreen(Model model, HttpServletRequest request, @RequestParam String id) {
		logger.info("AddEmployeeController > viewUpdateEmployeeScreen");

		EmployeeDto employeeDto = iEmployeeService.findEmployeById(id);
		
		if(employeeDto != null){
			model.addAttribute("isAddEmployeeUseCase", false);
			model.addAttribute("employeeInformationModel", iAssembler.assembleBackingBeanFromDto(employeeDto));
		} else {
			model.addAttribute("isAddEmployeeUseCase", true);
			model.addAttribute("employeeInformationModel", new EmployeeInformationBackingBean());
		}
		
		checkSuccessfulFormSubmission(request);
		
		return VIEW_ADD_EMPLOYEE;
	}

	@RequestMapping("/viewAllEmployees.do")
	public String viewAllEmployees(HttpServletRequest request, @RequestParam String useCase) {
		logger.info("AddEmployeeController > viewAllEmployees");

		request.setAttribute("employeeList", iEmployeeService.loadAllEmployees());
		request.setAttribute("useCase", useCase);
		
		checkSuccessfulFormSubmission(request);
		
		return "views/viewAllEmployees";
	}
	
	@RequestMapping("/deleteEmployee.do")
	public String deleteEmployee(HttpServletRequest request, @RequestParam String id) {
		logger.info("AddEmployeeController > deleteEmployee");
		
		iEmployeeService.deleteEmployee(id);
		
		WebUtils.setSessionAttribute(request, REQUEST_PARAM_SUCCESSFUL_MESSAGE, STATUS_MESSAGE_EMPLOYEE_INFO_REMOVED_SUCCESSFUL);
		
		return VIEW_REDIRECT_SHOW_ALL_EMPLOYEES_FROM_REMOVE_USE_CASE;
	}
	
	@RequestMapping(value = "/saveEmployeeInformation.do", method = RequestMethod.POST)
	public String processSubmit(@ModelAttribute("employeeInformationModel") EmployeeInformationBackingBean backingBean,
			BindingResult errors,  ModelMap modelMap, SessionStatus status, HttpServletRequest request) throws ParseException {
		
		validator.validate(backingBean, errors);

		if (errors.hasErrors()) {

			checkSuccessfulFormSubmission(request);

			return VIEW_ADD_EMPLOYEE;
		} else {
			
			EmployeeDto employeeDto = iAssembler.assembleDtoFromBackingBean(backingBean);
			
			ActionStatus action = iEmployeeService.saveOrUpdateEmployee(employeeDto);
			
			if(ActionStatus.SAVE.equals(action)) {
				WebUtils.setSessionAttribute(request, REQUEST_PARAM_SUCCESSFUL_MESSAGE, STATUS_MESSAGE_EMPLOYEE_INFO_SAVE_SUCCESSFUL);
			} else {
				WebUtils.setSessionAttribute(request, REQUEST_PARAM_SUCCESSFUL_MESSAGE, STATUS_MESSAGE_EMPLOYEE_INFO_UPDATE_SUCCESSFUL);
			}

			status.setComplete();

			return VIEW_REDIRECT_SHOW_ALL_EMPLOYEES;
		}
	}

}
