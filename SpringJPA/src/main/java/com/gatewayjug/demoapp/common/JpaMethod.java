package com.gatewayjug.demoapp.common;

/**
 * JPA Method Enum <br>
 * 
 * @author Mahesh Desai
 * @version $Revision: 1.0
 */
public enum JpaMethod {
	
	CRITERIA_API_METAMODEL("Criteria API"), 
	STATIC_QUERIES("Static Named Queries"), 
	DYNAMIC_QUERIES("Dynamic Queries");

	private String jpaType;

	JpaMethod(String jpaType) {
		this.jpaType = jpaType;
	}

	public String getJpaType() {
		return jpaType;
	}
}
