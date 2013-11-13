package com.gatewayjug.demoapp.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(Address.class)
public abstract class Address_ {

	public static volatile SingularAttribute<Address, String> street;
	public static volatile SingularAttribute<Address, String> province;
	public static volatile SingularAttribute<Address, String> pCode;
	public static volatile SingularAttribute<Address, Long> addressId;
	public static volatile SingularAttribute<Address, String> country;
	public static volatile SingularAttribute<Address, String> city;

}

