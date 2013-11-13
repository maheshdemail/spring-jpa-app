package com.gatewayjug.demoapp.common;

/**
 * The constants which are used in Spring Web MVC layer of the application.<br>
 * 
 * @author Mahesh Desai
 * @version $Revision: 1.0
 */
public interface WebConstants{

	enum ActionStatus {
		SAVE, UPDATE, DELETE, FIND
	}
	

	final public String DEFAULT_DROPDOWN_ID = "-1";

	final public String VALIDATION_REQUIRED_FIELD = "Required field.",
			VALIDATION_NOT_VALID_NUMBER = "Not a valid number.";

	final public String REQUEST_PARAM_UPLOAD_SUCCESSFUL = "success",
			REQUEST_PARAM_SUCCESSFUL_MESSAGE = "successMessages",
			REQUEST_PARAM_TRUE_STRING = "true";

	final public String STATUS_MESSAGE_EMPLOYEE_INFO_SAVE_SUCCESSFUL = "Employee information has been saved successfully.",
			STATUS_MESSAGE_EMPLOYEE_INFO_UPDATE_SUCCESSFUL = "Employee information has been updated successfully.",
			STATUS_MESSAGE_EMPLOYEE_INFO_REMOVED_SUCCESSFUL = "Employee has been removed successfully.";

	final public String VIEW_ADD_EMPLOYEE = "views/addUpdateEmployee";

	final public String VIEW_REDIRECT_PROTOCOL_INFORMATION = "redirect:welcome.do?success=true",
			VIEW_REDIRECT_SHOW_ALL_EMPLOYEES = "redirect:viewAllEmployees.do?success=true&useCase=UpdateEmployee",
			VIEW_REDIRECT_SHOW_ALL_EMPLOYEES_FROM_REMOVE_USE_CASE = "redirect:viewAllEmployees.do?success=true&useCase=RemoveEmployee";

}
