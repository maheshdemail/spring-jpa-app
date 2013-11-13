package com.gatewayjug.demoapp.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(JobTitle.class)
public abstract class JobTitle_ {

	public static volatile SingularAttribute<JobTitle, String> title;
	public static volatile SingularAttribute<JobTitle, Long> jobId;

}

