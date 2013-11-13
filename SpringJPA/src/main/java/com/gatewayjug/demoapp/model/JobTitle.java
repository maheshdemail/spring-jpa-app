package com.gatewayjug.demoapp.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the DEMO_JOBTITLE database table.
 * 
 */
@Entity
@Table(name = "DEMO_JOBTITLE")
public class JobTitle extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "JOB_ID")
	@SequenceGenerator(name = "DEMO_JOBTITLE_SEQ_GENERATOR", sequenceName = "DEMO_JOBTITLE_SEQ")
	@GeneratedValue(generator = "DEMO_JOBTITLE_SEQ_GENERATOR")
	private long jobId;

	@Basic
	private String title;

	public JobTitle() {
	}

	public JobTitle(String title) {
		this.title = title;
	}

	public long getJobId() {
		return this.jobId;
	}

	public void setJobId(long jobId) {
		this.jobId = jobId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}