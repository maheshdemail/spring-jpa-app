package com.gatewayjug.demoapp.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(PhoneNumber.class)
public abstract class PhoneNumber_ {

	public static volatile SingularAttribute<PhoneNumber, String> pNumber;
	public static volatile SingularAttribute<PhoneNumber, String> areaCode;
	public static volatile SingularAttribute<PhoneNumber, Employee> owner;
	public static volatile SingularAttribute<PhoneNumber, String> type;

}

