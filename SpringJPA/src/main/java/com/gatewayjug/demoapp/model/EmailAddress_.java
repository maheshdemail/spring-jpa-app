package com.gatewayjug.demoapp.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(EmailAddress.class)
public abstract class EmailAddress_ {

	public static volatile SingularAttribute<EmailAddress, String> address;

}

