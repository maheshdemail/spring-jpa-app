package com.gatewayjug.demoapp.common;

/**
 * The constants which are used in DAO layer of the application.<br>
 * 
 * @author Mahesh Desai
 * @version $Revision: 1.0
 */
public interface DaoConstants {
	public final static String DAO_ADD_ENTITY_CANNOT_NULL = "[Assertion failed] : Entity can't be null. Please make sure the entity you want to persist is not null.",
			DAO_DELETE_ENTITY_CANNOT_NULL = "[Assertion failed] : Entity can't be null. Please make sure the entity you want to delete is not null.",
			DAO_UPDATE_ENTITY_CANNOT_NULL = "[Assertion failed] : Entity can't be null. Please make sure the entity you want to update is not null.",
			DAO_SQL_QUERY_CANNOT_NULL = "[Assertion failed] : Query can't be empty or null. Please make sure the query you want to execute is excecutable.";

	public final static String EMPLOYEE_STATIC_QUERY_FIND_ALL_EMPLOYEES = "Employee.findAllEmployees",
			EMPLOYEE_STATIC_QUERY_FIND_EMPLOYEES_BY_NAME = "Employee.findEmployeeByName",
			EMPLOYEE_STATIC_QUERY_FIND_EMPLOYEES_BY_SALARIES_USING_BETWEEN = "Employee.findEmployeeBySalaries_Between",
			EMPLOYEE_STATIC_QUERY_FIND_EMPLOYEES_BY_SALARIES_USING_GREATER_THAN = "Employee.findEmployeeBySalaries_GreaterThan",
			EMPLOYEE_STATIC_QUERY_FIND_EMPLOYEES_BY_SALARIES_USING_LESS_THAN = "Employee.findEmployeeBySalaries_LessThan",
			EMPLOYEE_STATIC_QUERY_FIND_EMPLOYEES_BY_GENDER_USING_IN = "Employee.findEmployeeByGender_In",
			EMPLOYEE_STATIC_QUERY_FIND_EMPLOYEES_USING_JOIN_FETCH = "Employee.findAllEmployees_JoinFetch";
}
