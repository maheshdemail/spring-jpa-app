package com.gatewayjug.demoapp.model;

import java.util.Calendar;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(EmploymentPeriod.class)
public abstract class EmploymentPeriod_ {

	public static volatile SingularAttribute<EmploymentPeriod, Calendar> startDate;
	public static volatile SingularAttribute<EmploymentPeriod, Calendar> endDate;

}

