/**
 * 
 */
package com.verizon.iprom.orders.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ManjunathShivashimpi
 *
 */
@Entity
@Table(name = "IN_CENTER")
public class CenterEntity {
	
	@Id
	@Column(name = "CENTER_ID")
	private String centerId;
	
	@Column(name = "CENTER_DESCRIPTION")
	private String centerDescription;
	
	@Column(name = "ACTIVE_FLAG")
	private String activeFlag;

	/**
	 * @return the centerId
	 */
	public String getCenterId() {
		return centerId;
	}

	/**
	 * @param centerId the centerId to set
	 */
	public void setCenterId(String centerId) {
		this.centerId = centerId;
	}

	/**
	 * @return the centerDescription
	 */
	public String getCenterDescription() {
		return centerDescription;
	}

	/**
	 * @param centerDescription the centerDescription to set
	 */
	public void setCenterDescription(String centerDescription) {
		this.centerDescription = centerDescription;
	}

	/**
	 * @return the activeFlag
	 */
	public String getActiveFlag() {
		return activeFlag;
	}

	/**
	 * @param activeFlag the activeFlag to set
	 */
	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}
}
