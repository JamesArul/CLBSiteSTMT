package com.jpro.studentsmeetbackend.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

@Embeddable
public class Qualification extends BaseDomain {
	
	@DecimalMin("0.00")
	@DecimalMax("100.00")
	private float tenthPercentage;
	
	@DecimalMin("0.00")
	@DecimalMax("100.00")
	private float twelfthPercentage;
	
	@DecimalMin("0.00")
	@DecimalMax("100.00")
	private float bachelorCGPAPercentage;

	public float getTenthPercentage() {
		return tenthPercentage;
	}

	public void setTenthPercentage(float tenthPercentage) {
		this.tenthPercentage = tenthPercentage;
	}

	public float getTwelfthPercentage() {
		return twelfthPercentage;
	}

	public void setTwelfthPercentage(float twelfthPercentage) {
		this.twelfthPercentage = twelfthPercentage;
	}

	public float getBachelorCGPAPercentage() {
		return bachelorCGPAPercentage;
	}

	public void setBachelorCGPAPercentage(float bachelorCGPAPercentage) {
		this.bachelorCGPAPercentage = bachelorCGPAPercentage;
	}
	
}
