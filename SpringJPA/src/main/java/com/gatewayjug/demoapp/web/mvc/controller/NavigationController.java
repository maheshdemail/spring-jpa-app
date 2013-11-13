package com.gatewayjug.demoapp.web.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* Navigation Controller
* 
* @author Mahesh Desai
* @version $Revision: 1.0
*/
@Controller
public class NavigationController extends BaseController {
	
	private Logger logger = LoggerFactory.getLogger(NavigationController.class);

	@RequestMapping("/desingArchitecture.do")
	public String desingArchitecture(HttpServletRequest request) {
		logger.info("NavigationController > desingArchitecture");

		checkSuccessfulFormSubmission(request);
		
		return "views/designArchitecture";
	}
	
	@RequestMapping("/welcome.do")
	public String welcome(HttpServletRequest request) {
		logger.info("NavigationController > welcome");
		
		checkSuccessfulFormSubmission(request);
		
		return "views/welcome";
	}
	
}
