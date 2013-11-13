package com.gatewayjug.demoapp.web.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gatewayjug.demoapp.common.JpaMethod;
import com.gatewayjug.demoapp.dto.EmployeeDto;
import com.gatewayjug.demoapp.service.IEmployeeSearchService;
import com.gatewayjug.demoapp.web.beans.SearchBackingBean;

/**
* Employee Search controller
* 
* @author Mahesh Desai
* @version $Revision: 1.0
*/
@Controller
public class EmployeeSearchController extends BaseController {
	private Logger logger = LoggerFactory.getLogger(EmployeeSearchController.class);

	@Autowired
	private IEmployeeSearchService iSearchService;
	
	
	@RequestMapping(value = "/findEmployees-OrderBy.do", method = RequestMethod.GET)
	public String viewSearchEmployeeScreen_OrderBy(Model model, HttpServletRequest request) {
		logger.info("FindEmployeeController > viewSearchEmployeeScreen_OrderBy");
		
		SearchBackingBean searchBackingBean = new SearchBackingBean();
		searchBackingBean.setJpaMethod(JpaMethod.CRITERIA_API_METAMODEL);
		model.addAttribute("jpaMethods", JpaMethod.values());
		model.addAttribute("searchBackingBean", searchBackingBean);
		
		return "views/searchEmployee-OrderBy";
	}
	
	@RequestMapping(value = "/searchEmployees-OrderBy.do", method = RequestMethod.POST)
	public String searchEmployees_OrderBy(@ModelAttribute("searchBackingBean") SearchBackingBean backingBean, HttpServletRequest request) {
		logger.info("FindEmployeeController > searchEmployees_OrderBy-OrderBy");
		
		List<EmployeeDto> employees = iSearchService.findAllEmployees(backingBean.getJpaMethod());
		request.setAttribute("employeeList", employees);
		backingBean.setJpaMethod(backingBean.getJpaMethod());
		request.setAttribute("jpaMethods", JpaMethod.values());

		return "views/searchEmployee-OrderBy";
	}
	
	@RequestMapping(value = "/findEmployees-Like.do", method = RequestMethod.GET)
	public String viewSearchEmployeeScreen_Like(Model model, HttpServletRequest request) {
		logger.info("FindEmployeeController > viewSearchEmployeeScreen_Like");
		
		SearchBackingBean searchBackingBean = new SearchBackingBean();
		searchBackingBean.setJpaMethod(JpaMethod.CRITERIA_API_METAMODEL);
		model.addAttribute("jpaMethods", JpaMethod.values());
		model.addAttribute("searchBackingBean", searchBackingBean);
		
		return "views/searchEmployee-Like";
	}
	
	@RequestMapping(value = "/searchEmployees-Like.do", method = RequestMethod.POST)
	public String searchEmployees_Like(@ModelAttribute("searchBackingBean") SearchBackingBean backingBean, HttpServletRequest request) {
		logger.info("FindEmployeeController > searchEmployees_Like");
		
		List<EmployeeDto> employees = iSearchService.findEmployeeByName(backingBean.getJpaMethod(), backingBean.getName());
		request.setAttribute("employeeList", employees);
		
		SearchBackingBean searchBackingBean = new SearchBackingBean();
		searchBackingBean.setJpaMethod(JpaMethod.CRITERIA_API_METAMODEL);
		searchBackingBean.setName(backingBean.getName());
		request.setAttribute("jpaMethods", JpaMethod.values());
		request.setAttribute("searchBackingBean", searchBackingBean);
		
		return "views/searchEmployee-Like";
	}
	
	@RequestMapping(value = "/findEmployees-Between.do", method = RequestMethod.GET)
	public String viewSearchEmployeeScreen_Between(Model model, HttpServletRequest request) {
		logger.info("FindEmployeeController > viewSearchEmployeeScreen_Between");
		
		SearchBackingBean searchBackingBean = new SearchBackingBean();
		searchBackingBean.setJpaMethod(JpaMethod.CRITERIA_API_METAMODEL);
		model.addAttribute("jpaMethods", JpaMethod.values());
		model.addAttribute("searchBackingBean", searchBackingBean);
		
		return "views/searchEmployees-Between";
	}
	
	@RequestMapping(value = "/searchEmployees-Between.do", method = RequestMethod.POST)
	public String searchEmployees_Between(@ModelAttribute("searchBackingBean") SearchBackingBean backingBean, HttpServletRequest request) {
		logger.info("FindEmployeeController > searchEmployees_Between");
		
		List<EmployeeDto> employees = iSearchService.findEmployeeBySalaryRange(backingBean.getJpaMethod(), backingBean.getMinimumSalary(), backingBean.getMaximumSalary());
		
		request.setAttribute("employeeList", employees);
		
		SearchBackingBean searchBackingBean = new SearchBackingBean();
		searchBackingBean.setJpaMethod(JpaMethod.CRITERIA_API_METAMODEL);
		searchBackingBean.setMinimumSalary(backingBean.getMinimumSalary());
		searchBackingBean.setMaximumSalary(backingBean.getMaximumSalary());
		
		request.setAttribute("jpaMethods", JpaMethod.values());
		request.setAttribute("searchBackingBean", searchBackingBean);

		return "views/searchEmployees-Between";
	}
	
	@RequestMapping(value = "/findEmployees-LessThan.do", method = RequestMethod.GET)
	public String viewSearchEmployeeScreen_LessThan(Model model, HttpServletRequest request) {
		logger.info("FindEmployeeController > viewSearchEmployeeScreen_LessThan");
		
		SearchBackingBean searchBackingBean = new SearchBackingBean();
		searchBackingBean.setJpaMethod(JpaMethod.CRITERIA_API_METAMODEL);
		model.addAttribute("jpaMethods", JpaMethod.values());
		model.addAttribute("searchBackingBean", searchBackingBean);
		
		return "views/searchEmployees-LessThan";
	}
	
	@RequestMapping(value = "/searchEmployees-LessThan.do", method = RequestMethod.POST)
	public String searchEmployees_LessThan(@ModelAttribute("searchBackingBean") SearchBackingBean backingBean, HttpServletRequest request) {
		logger.info("FindEmployeeController > searchEmployees_LessThan");
		
		List<EmployeeDto> employees = iSearchService.findEmployeeByMaximumSalary(backingBean.getJpaMethod(), backingBean.getMaximumSalary());
		
		request.setAttribute("employeeList", employees);
		
		SearchBackingBean searchBackingBean = new SearchBackingBean();
		searchBackingBean.setJpaMethod(JpaMethod.CRITERIA_API_METAMODEL);
		searchBackingBean.setMinimumSalary(backingBean.getMinimumSalary());
		searchBackingBean.setMaximumSalary(backingBean.getMaximumSalary());
		
		request.setAttribute("jpaMethods", JpaMethod.values());
		request.setAttribute("searchBackingBean", searchBackingBean);

		return "views/searchEmployees-LessThan";
	}
	
	@RequestMapping(value = "/findEmployees-GreaterThan.do", method = RequestMethod.GET)
	public String viewSearchEmployeeScreen_GreaterThan(Model model, HttpServletRequest request) {
		logger.info("FindEmployeeController > viewSearchEmployeeScreen_GreaterThan");
		
		SearchBackingBean searchBackingBean = new SearchBackingBean();
		searchBackingBean.setJpaMethod(JpaMethod.CRITERIA_API_METAMODEL);
		model.addAttribute("jpaMethods", JpaMethod.values());
		model.addAttribute("searchBackingBean", searchBackingBean);
		
		return "views/searchEmployees-GreaterThan";
	}
	
	@RequestMapping(value = "/searchEmployees-GreaterThan.do", method = RequestMethod.POST)
	public String searchEmployees_GreaterThan(@ModelAttribute("searchBackingBean") SearchBackingBean backingBean, HttpServletRequest request) {
		logger.info("FindEmployeeController > searchEmployees_GreaterThan");
		
		List<EmployeeDto> employees = iSearchService.findEmployeeByMinumumSalary(backingBean.getJpaMethod(), backingBean.getMinimumSalary());
		
		request.setAttribute("employeeList", employees);
		
		SearchBackingBean searchBackingBean = new SearchBackingBean();
		searchBackingBean.setJpaMethod(JpaMethod.CRITERIA_API_METAMODEL);
		searchBackingBean.setMinimumSalary(backingBean.getMinimumSalary());
		searchBackingBean.setMaximumSalary(backingBean.getMaximumSalary());
		
		request.setAttribute("jpaMethods", JpaMethod.values());
		request.setAttribute("searchBackingBean", searchBackingBean);

		return "views/searchEmployees-GreaterThan";
	}
	
	@RequestMapping(value = "/findEmployees-In.do", method = RequestMethod.GET)
	public String viewSearchEmployeeScreen_In(Model model, HttpServletRequest request) {
		logger.info("FindEmployeeController > viewSearchEmployeeScreen_In");
		
		SearchBackingBean searchBackingBean = new SearchBackingBean();
		searchBackingBean.setJpaMethod(JpaMethod.CRITERIA_API_METAMODEL);

		model.addAttribute("jpaMethods", JpaMethod.values());
		model.addAttribute("searchBackingBean", searchBackingBean);
		
		return "views/searchEmployees-In";
	}
	
	@RequestMapping(value = "/searchEmployees-In.do", method = RequestMethod.POST)
	public String searchEmployees_In(@ModelAttribute("searchBackingBean") SearchBackingBean backingBean, Model model, HttpServletRequest request) {
		logger.info("FindEmployeeController > searchEmployees_In");
		
		List<EmployeeDto> employees = iSearchService.findEmployeeByGenderIn(backingBean.getJpaMethod(), backingBean.getGender());
		
		request.setAttribute("employeeList", employees);
		
		SearchBackingBean searchBackingBean = new SearchBackingBean();
		searchBackingBean.setJpaMethod(JpaMethod.CRITERIA_API_METAMODEL);
		searchBackingBean.setGender(backingBean.getGender());
		
		request.setAttribute("jpaMethods", JpaMethod.values());
		request.setAttribute("searchBackingBean", searchBackingBean);

		return "views/searchEmployees-In";
	}
	
	@RequestMapping(value = "/findEmployees-JoinFetch.do", method = RequestMethod.GET)
	public String viewSearchEmployeeScreen_JoinFetch(Model model, HttpServletRequest request) {
		logger.info("FindEmployeeController > viewSearchEmployeeScreen_JoinFetch");
		
		SearchBackingBean searchBackingBean = new SearchBackingBean();
		searchBackingBean.setJpaMethod(JpaMethod.CRITERIA_API_METAMODEL);

		model.addAttribute("jpaMethods", JpaMethod.values());
		model.addAttribute("searchBackingBean", searchBackingBean);
		
		return "views/searchEmployees-JoinFetch";
	}
	
	@RequestMapping(value = "/searchEmployees-JoinFetch.do", method = RequestMethod.POST)
	public String searchEmployees_JoinFetch(@ModelAttribute("searchBackingBean") SearchBackingBean backingBean, Model model, HttpServletRequest request) {
		logger.info("FindEmployeeController > searchEmployees_JoinFetch");
		
		List<EmployeeDto> employees = iSearchService.findAllEmployeeUsingJoinFetch(backingBean.getJpaMethod());
		
		request.setAttribute("employeeList", employees);
		
		SearchBackingBean searchBackingBean = new SearchBackingBean();
		searchBackingBean.setJpaMethod(JpaMethod.CRITERIA_API_METAMODEL);
		
		request.setAttribute("jpaMethods", JpaMethod.values());
		request.setAttribute("searchBackingBean", searchBackingBean);

		return "views/searchEmployees-JoinFetch";
	}
		
}
