/**
 * 
 */
package com.verizon.iprom.orders.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ManjunathShivashimpi
 *
 */
@Entity
@Table(name = "IN_CANCELED_REASON")
public class CanceledReasonEntity {
	
	@Id
	@Column(name = "CANCELED_REASON_CODE")
	private BigInteger canceledReasonCode;
	
	@Column(name = "CANCELED_DESCRIPTION")
	private String canceledDescription;

	/**
	 * @return the canceledReasonCode
	 */
	public BigInteger getCanceledReasonCode() {
		return canceledReasonCode;
	}

	/**
	 * @param canceledReasonCode the canceledReasonCode to set
	 */
	public void setCanceledReasonCode(BigInteger canceledReasonCode) {
		this.canceledReasonCode = canceledReasonCode;
	}

	/**
	 * @return the canceledDescription
	 */
	public String getCanceledDescription() {
		return canceledDescription;
	}

	/**
	 * @param canceledDescription the canceledDescription to set
	 */
	public void setCanceledDescription(String canceledDescription) {
		this.canceledDescription = canceledDescription;
	}

}
