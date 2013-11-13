package com.gatewayjug.demoapp.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The persistent class for the DEMO_PHONE database table.
 * 
 */
@Entity
@Table(name = "DEMO_PHONE")
@IdClass(PhoneNumber.DemoPhonePK.class)
public class PhoneNumber extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(updatable = false)
	private String type;

	@Basic
	@Column(name = "AREA_CODE")
	private String areaCode;

	@Basic
	@Column(name = "P_NUMBER")
	private String pNumber;

	@Id
	@ManyToOne
	@JoinColumn(name="OWNER", referencedColumnName="EMP_ID")
	private Employee owner;

	public PhoneNumber() {
	}

	public PhoneNumber(String type, String areaCode, String number) {
		this();
		setType(type);
		setAreaCode(areaCode);
		setPNumber(number);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAreaCode() {
		return this.areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getPNumber() {
		return this.pNumber;
	}

	public void setPNumber(String pNumber) {
		this.pNumber = pNumber;
	}

	public Employee getOwner() {
		return this.owner;
	}

	protected void setOwner(Employee employee) {
		this.owner = employee;
	}
	
	static class DemoPhonePK implements Serializable {
		private static final long serialVersionUID = 1L;

		private Employee owner;

		private String type;

	    public DemoPhonePK() {
	    }
		public Employee getOwner() {
			return this.owner;
		}
		public void setOwner(Employee owner) {
			this.owner = owner;
		}
		public String getType() {
			return this.type;
		}
		public void setType(String type) {
			this.type = type;
		}

		public boolean equals(Object other) {
			if (this == other) {
				return true;
			}
			if (!(other instanceof DemoPhonePK)) {
				return false;
			}
			DemoPhonePK castOther = (DemoPhonePK)other;
			return 
				(this.owner.getEmpId() == castOther.owner.getEmpId())
				&& this.type.equals(castOther.type);

	    }
	    
		public int hashCode() {
			final int prime = 31;
			int hash = 17;
			hash = hash * prime + ((int) (this.owner.getEmpId() ^ (this.owner.getEmpId() >>> 32)));
			hash = hash * prime + this.type.hashCode();
			
			return hash;
	    }
	}
}