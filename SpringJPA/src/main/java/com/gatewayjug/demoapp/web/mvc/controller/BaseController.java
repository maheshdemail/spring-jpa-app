package com.gatewayjug.demoapp.web.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import com.gatewayjug.demoapp.common.WebConstants;

/**
 * Spring Web MVC Base Controller to handle Common functionalities across all Use Cases. <br>
 * 
 * @author Mahesh Desai
 * @version $1.0
 */
public abstract class BaseController implements WebConstants {

	/**
	 * Check successful form submission.
	 * 
	 * @param request the request
	 */
	protected void checkSuccessfulFormSubmission(HttpServletRequest request) {
		if(!(request.getParameter(REQUEST_PARAM_UPLOAD_SUCCESSFUL) != null && REQUEST_PARAM_TRUE_STRING.equals(request.getParameter(REQUEST_PARAM_UPLOAD_SUCCESSFUL)))){
			request.getSession().setAttribute(REQUEST_PARAM_SUCCESSFUL_MESSAGE, null);
		}
	}
}
