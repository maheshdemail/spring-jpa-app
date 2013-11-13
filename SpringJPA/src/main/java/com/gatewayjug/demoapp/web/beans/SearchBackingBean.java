package com.gatewayjug.demoapp.web.beans;

import java.util.List;

import com.gatewayjug.demoapp.common.JpaMethod;

/**
* Search backing bean
* 
* @author Mahesh Desai
* @version $Revision: 1.0
*/
public class SearchBackingBean {
	private JpaMethod jpaMethod;
	private String name;
	private Double minimumSalary;
	private Double maximumSalary;
	private List<String> jobTitles;
	private String gender;

	public void setJpaMethod(JpaMethod jpaMethod) {
		this.jpaMethod = jpaMethod;
	}

	public JpaMethod getJpaMethod() {
		return jpaMethod;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getMinimumSalary() {
		return minimumSalary;
	}

	public void setMinimumSalary(Double minimumSalary) {
		this.minimumSalary = minimumSalary;
	}

	public Double getMaximumSalary() {
		return maximumSalary;
	}

	public void setMaximumSalary(Double maximumSalary) {
		this.maximumSalary = maximumSalary;
	}

	public void setJobTitles(List<String> jobTitles) {
		this.jobTitles = jobTitles;
	}

	public List<String> getJobTitles() {
		return jobTitles;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
