package com.jpro.studentsmeetbackend.model;

import java.math.BigDecimal;

import javax.persistence.Embeddable;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

@Embeddable
public class Qualification extends BaseDomain {
	
	@DecimalMin("0.00")
	@DecimalMax("100.00")
	private BigDecimal tenthPercentage;
	
	@DecimalMin("0.00")
	@DecimalMax("100.00")
	private BigDecimal twelfthPercentage;
	
	@DecimalMin("0.00")
	@DecimalMax("100.00")
	private BigDecimal bachelorCGPAPercentage;

	public BigDecimal getTenthPercentage() {
		return tenthPercentage;
	}

	public void setTenthPercentage(BigDecimal tenthPercentage) {
		this.tenthPercentage = tenthPercentage;
	}

	public BigDecimal getTwelfthPercentage() {
		return twelfthPercentage;
	}

	public void setTwelfthPercentage(BigDecimal twelfthPercentage) {
		this.twelfthPercentage = twelfthPercentage;
	}

	public BigDecimal getBachelorCGPAPercentage() {
		return bachelorCGPAPercentage;
	}

	public void setBachelorCGPAPercentage(BigDecimal bachelorCGPAPercentage) {
		this.bachelorCGPAPercentage = bachelorCGPAPercentage;
	}
	
}
