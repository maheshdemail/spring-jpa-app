package com.gatewayjug.demoapp.assembler;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.gatewayjug.demoapp.dto.EmployeeDto;
import com.gatewayjug.demoapp.model.Address;
import com.gatewayjug.demoapp.model.Degree;
import com.gatewayjug.demoapp.model.Employee;
import com.gatewayjug.demoapp.model.EmploymentPeriod;
import com.gatewayjug.demoapp.model.Gender;
import com.gatewayjug.demoapp.model.JobTitle;
import com.gatewayjug.demoapp.model.PhoneNumber;
import com.gatewayjug.demoapp.web.beans.EmployeeInformationBackingBean;

/**
 * Assemble converts Data Transfer Object to Business Objects and vice versa
 * 
 * @author Mahesh Desai
 * @version $1.0
 */
@Component
public class AssemblerImpl implements IAssembler {

	@Override
	public EmployeeDto assembleDtoFromBackingBean(EmployeeInformationBackingBean command) {
		EmployeeDto dto = new EmployeeDto();
		dto.setEmployeeId(command.getEmployeeId());
		dto.setFirstName(command.getFirstName());
		dto.setLastName(command.getLastName());
		dto.setGender(command.getGender());
		dto.setEndDate(command.getEndDate());
		dto.setStartDate(command.getStartDate());
		dto.setJobTitle(command.getJobTitle());
		dto.setDegree(command.getDegree());
		dto.setSalary(command.getSalary());
		dto.setCity(command.getCity());
		dto.setCountry(command.getCountry());
		dto.setZipCode(command.getZipCode());
		dto.setProvince(command.getProvince());
		dto.setStreet(command.getStreet());
		dto.setEmail(command.getEmail());
		dto.setPhoneIsdn(command.getPhoneIsdn());
		dto.setPhoneIsdn(command.getPhoneIsdn());
		dto.setPhoneWork(command.getPhoneWork());
		dto.setPhoneWorkFax(command.getPhoneWorkFax());
		dto.setPhoneCellular(command.getPhoneCellular());
		dto.setPhonePager(command.getPhonePager());
		dto.setResponsibility(command.getResponsibility());
		
		dto.setPhoneIsdnAreaCode(command.getPhoneIsdnAreaCode());
		dto.setPhoneWorkFaxAreaCode(command.getPhoneWorkFaxAreaCode());
		dto.setPhoneWorkAreaCode(command.getPhoneWorkAreaCode());
		dto.setPhoneCellularAreaCode(command.getPhoneCellularAreaCode());
		dto.setPhonePagerAreaCode(command.getPhonePagerAreaCode());
		
		dto.setEmail(command.getEmail());
		
		return dto;
	}
	
	@Override
	public EmployeeInformationBackingBean assembleBackingBeanFromDto(EmployeeDto dto) {
		EmployeeInformationBackingBean commond = new EmployeeInformationBackingBean();
		
		commond.setEmployeeId(dto.getEmployeeId());
		commond.setEmployeeId(dto.getEmployeeId());
		commond.setFirstName(dto.getFirstName());
		commond.setLastName(dto.getLastName());
		commond.setGender(dto.getGender());
		commond.setEndDate(dto.getEndDate());
		commond.setStartDate(dto.getStartDate());
		commond.setJobTitle(dto.getJobTitle());
		commond.setDegree(dto.getDegree());
		commond.setSalary(dto.getSalary());
		commond.setCity(dto.getCity());
		commond.setCountry(dto.getCountry());
		commond.setZipCode(dto.getZipCode());
		commond.setProvince(dto.getProvince());
		commond.setStreet(dto.getStreet());
		commond.setEmail(dto.getEmail());
		commond.setPhoneIsdn(dto.getPhoneIsdn());
		commond.setPhoneWork(dto.getPhoneWork());
		commond.setPhoneWorkFax(dto.getPhoneWorkFax());
		commond.setPhoneCellular(dto.getPhoneCellular());
		commond.setPhonePager(dto.getPhonePager());
		commond.setResponsibility(dto.getResponsibility());
		commond.setPhoneIsdnAreaCode(dto.getPhoneIsdnAreaCode());
		commond.setPhoneWorkFaxAreaCode(dto.getPhoneWorkFaxAreaCode());
		commond.setPhoneWorkAreaCode(dto.getPhoneWorkAreaCode());
		commond.setPhoneCellularAreaCode(dto.getPhoneCellularAreaCode());
		commond.setPhonePagerAreaCode(dto.getPhonePagerAreaCode());
		commond.setEmail(dto.getEmail());
		
		return commond;
	}
	
	@Override
	public EmployeeDto assembleDtoFromBo(Employee bo) {
		EmployeeDto dto = null;
		
		if(bo != null){
			dto = new EmployeeDto();
			DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
			
			dto.setEmployeeId(String.valueOf(bo.getEmpId()));
			dto.setName(bo.getFirstName() + " " + bo.getLastName());
			dto.setFirstName(bo.getFirstName());
			dto.setLastName(bo.getLastName());
			dto.setGender(Gender.Male.equals(bo.getGender()) ? "M" : "F");
			
			if(bo.getPeriod().getEndDate() != null){
				dto.setEndDate(format.format(new Date(bo.getPeriod().getEndDate().getTimeInMillis())));
			}
			if(bo.getPeriod().getStartDate() != null){
				dto.setStartDate(format.format(new Date(bo.getPeriod().getStartDate().getTimeInMillis())));
			}
	
			if(bo.getJobTitle() != null){
				dto.setJobTitle(bo.getJobTitle().getTitle());
			}
			if(bo.getDegrees() != null && bo.getDegrees().size() > 0){
				dto.setDegree(convert(bo.getDegrees()));
			}
			dto.setSalary(String.valueOf(bo.getSalary()));
			
			if(bo.getAddress() != null){
				dto.setAddress(bo.getAddress().getStreet() +", "+bo.getAddress().getCity()+", "+
						bo.getAddress().getProvince() +", "+ bo.getAddress().getPCode()+", "+
						bo.getAddress().getCountry());
				
				dto.setCity(bo.getAddress().getCity());
				dto.setCountry(bo.getAddress().getCountry());
				dto.setZipCode(bo.getAddress().getPCode());
				dto.setProvince(bo.getAddress().getProvince());
				dto.setStreet(bo.getAddress().getStreet());
			}
			if(bo.getEmailAddresses() != null && bo.getEmailAddresses().size() > 0 && bo.getEmailAddresses().get("Work") != null){
				dto.setEmail(bo.getEmailAddresses().get("Work").getAddress());
			}
			if(bo.getPhoneNumbers() != null && bo.getPhoneNumbers().size() > 0){
				int phoneNumberSize = bo.getPhoneNumbers().size();
				StringBuilder phoneNumberString = new StringBuilder();
				for (PhoneNumber phoneNumber : bo.getPhoneNumbers()) {
					if(PHONE_TYPE_ISDN.equals(phoneNumber.getType())){
						dto.setPhoneIsdnAreaCode(phoneNumber.getAreaCode());
						dto.setPhoneIsdn(phoneNumber.getPNumber());
						preparePhoneNumbers(bo, phoneNumberSize, phoneNumberString, phoneNumber);
					} else if(PHONE_TYPE_CELLULAR.equals(phoneNumber.getType())){
						dto.setPhoneCellularAreaCode(phoneNumber.getAreaCode());
						dto.setPhoneCellular(phoneNumber.getPNumber());
						preparePhoneNumbers(bo, phoneNumberSize, phoneNumberString, phoneNumber);
					} else if(PHONE_TYPE_PAGER.equals(phoneNumber.getType())){
						dto.setPhonePagerAreaCode(phoneNumber.getAreaCode());
						dto.setPhonePager(phoneNumber.getPNumber());
						preparePhoneNumbers(bo, phoneNumberSize, phoneNumberString, phoneNumber);
					} else if(PHONE_TYPE_WORK.equals(phoneNumber.getType())){	
						dto.setPhoneWorkAreaCode(phoneNumber.getAreaCode());
						dto.setPhoneWork(phoneNumber.getPNumber());
						preparePhoneNumbers(bo, phoneNumberSize, phoneNumberString, phoneNumber);
					} else if(PHONE_TYPE_WORK_FAX.equals(phoneNumber.getType())){
						dto.setPhoneWorkFaxAreaCode(phoneNumber.getAreaCode());
						dto.setPhoneWorkFax(phoneNumber.getPNumber());
						preparePhoneNumbers(bo, phoneNumberSize, phoneNumberString, phoneNumber);
					}
				}
				
				dto.setAllPhones(phoneNumberString.toString());
			}
			
			if(bo.getResponsibilities() != null && bo.getResponsibilities().size() > 0){
				dto.setResponsibility(bo.getResponsibilities().get(0));
			}
		}
		
		return dto;
	}

	@Override
	public void assembleBoFromDto(Employee bo, EmployeeDto dto) {
		bo.setFirstName(dto.getFirstName());
		bo.setLastName(dto.getLastName());
		bo.setGender("M".equals(dto.getGender()) ? Gender.Male : Gender.Female);
		bo.setSalary(Double.valueOf(dto.getSalary()));

		try {
			if(StringUtils.hasLength(dto.getStartDate())) { 
				Date startDate = new SimpleDateFormat("MM/dd/yyyy").parse(dto.getStartDate());
				if (bo.getPeriod() != null){
					bo.getPeriod().setStartDate(startDate);
				} else {
					EmploymentPeriod period = new EmploymentPeriod();
					period.setStartDate(startDate);
					bo.setPeriod(period);
				}
			}
			if(StringUtils.hasLength(dto.getEndDate()) && bo.getPeriod() != null){
				Date endDate = new SimpleDateFormat("MM/dd/yyyy").parse(dto.getEndDate());
				if (bo.getPeriod() != null){
					bo.getPeriod().setEndDate(endDate);
				} else {
					EmploymentPeriod period = new EmploymentPeriod();
					period.setEndDate(endDate);
					bo.setPeriod(period);
				}
			}
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
		
		if(bo.getAddress() != null){
			bo.getAddress().setCity(dto.getCity());
			bo.getAddress().setPCode(dto.getZipCode());
			bo.getAddress().setCountry(dto.getCountry());
			if(StringUtils.hasLength(dto.getProvince())){
				bo.getAddress().setProvince(dto.getProvince());
			}
			if(StringUtils.hasLength(dto.getStreet())){
				bo.getAddress().setStreet(dto.getStreet());
			}
		} else {
			Address address = new Address();
			address.setCity(dto.getCity());
			address.setPCode(dto.getZipCode());
			address.setCountry(dto.getCountry());
			if(StringUtils.hasLength(dto.getProvince())){
				address.setProvince(dto.getProvince());
			}
			if(StringUtils.hasLength(dto.getStreet())){
				address.setStreet(dto.getStreet());
			}
			bo.setAddress(address);
		}

		if(!"-1".equals(dto.getResponsibility())){
			bo.addResponsibility(dto.getResponsibility());
		}
		if(!"-1".equals(dto.getJobTitle())){
			bo.setJobTitle(new JobTitle(dto.getJobTitle()));
		}
		if(!"-1".equals(dto.getDegree())){
			List<String> degrees = dto.getDegree();
			for (String degree : degrees) {
				bo.addDegree(degree);
			}
		}
		
		if(StringUtils.hasLength(dto.getPhoneCellular()) && StringUtils.hasLength(dto.getPhoneCellularAreaCode())){
			bo.addPhoneNumber("Cellular", dto.getPhoneCellularAreaCode(), dto.getPhoneCellular());
		}
		if(StringUtils.hasLength(dto.getPhoneIsdn()) && StringUtils.hasLength(dto.getPhoneIsdnAreaCode())){
			bo.addPhoneNumber("ISDN", dto.getPhoneIsdnAreaCode(), dto.getPhoneIsdn());
		}
		if(StringUtils.hasLength(dto.getPhoneWork()) && StringUtils.hasLength(dto.getPhoneWorkAreaCode())){
			bo.addPhoneNumber("Work", dto.getPhoneWorkAreaCode(), dto.getPhoneWork());
		}
		if(StringUtils.hasLength(dto.getPhoneWorkFax()) && StringUtils.hasLength(dto.getPhoneWorkFaxAreaCode())){
			bo.addPhoneNumber("WorkFax", dto.getPhoneWorkFaxAreaCode(), dto.getPhoneWorkFax());
		}
		if(StringUtils.hasLength(dto.getPhonePager()) && StringUtils.hasLength(dto.getPhonePagerAreaCode())){
			bo.addPhoneNumber("Pager", dto.getPhonePagerAreaCode(), dto.getPhonePager());
		}
		
		if(StringUtils.hasLength(dto.getEmail())){
			bo.addEmailAddress("Work", dto.getEmail());
		}
		
	}

	private void preparePhoneNumbers(Employee source, int phoneNumberSize, StringBuilder phoneNumbers, PhoneNumber phoneNumber) {
		phoneNumbers.append(phoneNumber.getAreaCode()).append("-").append(phoneNumber.getPNumber());
		
		if(phoneNumberSize == source.getPhoneNumbers().size()){
			phoneNumbers.append("<br>");
		}
	}
	
	private List<String> convert(List<Degree> degrees) {
		List<String> degreeList = new LinkedList<String>();
		
		for (Degree degree : degrees) {
			degreeList.add(degree.getName());
		}
		
		return degreeList;
	}
	
}
