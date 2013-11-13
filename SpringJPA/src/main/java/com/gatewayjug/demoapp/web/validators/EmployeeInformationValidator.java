package com.gatewayjug.demoapp.web.validators;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.gatewayjug.demoapp.common.WebConstants;
import com.gatewayjug.demoapp.web.beans.EmployeeInformationBackingBean;

/**
* Employee information validator
* 
* @author Mahesh Desai
* @version $Revision: 1.0
*/
@Component
public class EmployeeInformationValidator implements Validator, WebConstants {

	@Override
	public boolean supports(Class<?> clazz) {
		 return EmployeeInformationBackingBean.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		EmployeeInformationBackingBean employeeInformationBackingBean =(EmployeeInformationBackingBean)target;
		String firstName = employeeInformationBackingBean.getFirstName();
		String lastName = employeeInformationBackingBean.getLastName();
		String startDate = employeeInformationBackingBean.getStartDate();
		String salary = employeeInformationBackingBean.getSalary();
		String city = employeeInformationBackingBean.getCity();
		String country = employeeInformationBackingBean.getCountry();
		String zipCode = employeeInformationBackingBean.getZipCode();
		String email = employeeInformationBackingBean.getEmail();
		String phoneCellular = employeeInformationBackingBean.getPhoneCellular();
		String phoneCellularAreaCode = employeeInformationBackingBean.getPhoneCellularAreaCode();
		String phoneIsdnAreaCode = employeeInformationBackingBean.getPhoneIsdnAreaCode();
		String phoneWorkFaxAreaCode = employeeInformationBackingBean.getPhoneWorkFaxAreaCode();
		String phoneWorkAreaCode = employeeInformationBackingBean.getPhoneWorkAreaCode();
		String phonePagerAreaCode = employeeInformationBackingBean.getPhonePagerAreaCode();
		String phoneIsdn = employeeInformationBackingBean.getPhoneIsdn();
		String phoneWorkFax = employeeInformationBackingBean.getPhoneWorkFax();
		String phoneWork = employeeInformationBackingBean.getPhoneWork();
		String phonePager = employeeInformationBackingBean.getPhonePager();
		String gender = employeeInformationBackingBean.getGender();
		String jobTitle = employeeInformationBackingBean.getJobTitle();
		List<String> degrees = employeeInformationBackingBean.getDegree();
		
		if (!StringUtils.hasLength(firstName)) {
			errors.rejectValue("firstName", "required", VALIDATION_REQUIRED_FIELD);
		}
		if (!StringUtils.hasLength(lastName)) {
			errors.rejectValue("lastName", "required", VALIDATION_REQUIRED_FIELD);
		}
		if (!StringUtils.hasLength(startDate)) {
			errors.rejectValue("startDate", "required", VALIDATION_REQUIRED_FIELD);
		}
		if (!StringUtils.hasLength(city)) {
			errors.rejectValue("city", "required", VALIDATION_REQUIRED_FIELD);
		}
		if (!StringUtils.hasLength(country)) {
			errors.rejectValue("country", "required", VALIDATION_REQUIRED_FIELD);
		}
		if (!StringUtils.hasLength(email)) {
			errors.rejectValue("email", "required", VALIDATION_REQUIRED_FIELD);
		}
		if (!StringUtils.hasLength(salary)) {
			errors.rejectValue("salary", "required", VALIDATION_REQUIRED_FIELD);
		}
		validateNumericField(errors, "salary", salary);
		
		if (!StringUtils.hasLength(zipCode)) {
			errors.rejectValue("zipCode", "required", VALIDATION_REQUIRED_FIELD);
		}
		validateNumericField(errors, "zipCode", zipCode);
		
		if (!StringUtils.hasLength(phoneCellular)) {
			errors.rejectValue("phoneCellular", "required", VALIDATION_REQUIRED_FIELD);
		}
		
		if (!StringUtils.hasLength(phoneCellularAreaCode)) {
			errors.rejectValue("phoneCellularAreaCode", "required", VALIDATION_REQUIRED_FIELD);
		}
		
		if(DEFAULT_DROPDOWN_ID.equals(gender)){
			errors.rejectValue("gender", "required", VALIDATION_REQUIRED_FIELD);
		}
		if (DEFAULT_DROPDOWN_ID.equals(jobTitle)) {
			errors.rejectValue("jobTitle", "required", VALIDATION_REQUIRED_FIELD);
		} 
		if (DEFAULT_DROPDOWN_ID.equals(degrees.get(0))) {
			errors.rejectValue("degree", "required", VALIDATION_REQUIRED_FIELD);
		} 
		
		validateNumericField(errors, "phoneCellularAreaCode", phoneCellularAreaCode);
		validateNumericField(errors, "phoneCellular", phoneCellular);
		validateNumericField(errors, "phoneIsdn", phoneIsdn);
		validateNumericField(errors, "phoneWorkFax", phoneWorkFax);
		validateNumericField(errors, "phoneWork", phoneWork);
		validateNumericField(errors, "phonePager", phonePager);
		validateNumericField(errors, "phoneCellularAreaCode", phoneCellularAreaCode);
		validateNumericField(errors, "phoneIsdnAreaCode", phoneIsdnAreaCode);
		validateNumericField(errors, "phoneWorkFaxAreaCode", phoneWorkFaxAreaCode);
		validateNumericField(errors, "phoneWorkAreaCode", phoneWorkAreaCode);
		validateNumericField(errors, "phonePagerAreaCode", phonePagerAreaCode);
	}

	private void validateNumericField(Errors errors, String field, String value) {
		if (StringUtils.hasLength(value)) {
			try {
				Double.parseDouble(value);
			} catch (Exception e) {
				errors.rejectValue(field, "invalid", VALIDATION_NOT_VALID_NUMBER);
			}
		}
	}
}
