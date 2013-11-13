package com.gatewayjug.demoapp.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the DEMO_DEGREE database table.
 * 
 */
@Entity
@Table(name = "DEMO_DEGREE")
public class Degree extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "DEGREE_ID")
	@SequenceGenerator(name = "DEMO_DEGREE_SEQ_GENERATOR", sequenceName = "DEMO_DEGREE_SEQ")
	@GeneratedValue(generator = "DEMO_DEGREE_SEQ_GENERATOR")
	private long degreeId;

	@Basic
	private String name;

	public Degree() {
	}
	
	public Degree(String name) {
        this.name = name;
    }

	public long getDegreeId() {
		return this.degreeId;
	}

	public void setDegreeId(long degreeId) {
		this.degreeId = degreeId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}