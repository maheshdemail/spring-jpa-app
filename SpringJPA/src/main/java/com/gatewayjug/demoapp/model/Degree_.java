package com.gatewayjug.demoapp.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(Degree.class)
public abstract class Degree_ {

	public static volatile SingularAttribute<Degree, String> name;
	public static volatile SingularAttribute<Degree, Long> degreeId;

}

