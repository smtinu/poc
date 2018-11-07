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
@Table(name = "IN_SALES_REP")
public class SalesRepEntity {

	@Id
	@Column(name = "SALES_REP_ID") 
	private String salesRepId;
	
	@Column(name = "BRANCH_ID")
	private String branchId;
	
	@Column(name = "SALES_REP_NAME")
	private String salesRepName;
	
	@Column(name = "SALES_REP_PHONE")
	private String salesRepPhone;
	
	@Column(name = "SALES_REP_FAX")
	private String salesRepFax;
	
	@Column(name = "REP_TYPE")
	private String salesRepType;

	/**
	 * @return the salesRepId
	 */
	public String getSalesRepId() {
		return salesRepId;
	}

	/**
	 * @param salesRepId the salesRepId to set
	 */
	public void setSalesRepId(String salesRepId) {
		this.salesRepId = salesRepId;
	}

	/**
	 * @return the branchId
	 */
	public String getBranchId() {
		return branchId;
	}

	/**
	 * @param branchId the branchId to set
	 */
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	/**
	 * @return the salesRepName
	 */
	public String getSalesRepName() {
		return salesRepName;
	}

	/**
	 * @param salesRepName the salesRepName to set
	 */
	public void setSalesRepName(String salesRepName) {
		this.salesRepName = salesRepName;
	}

	/**
	 * @return the salesRepPhone
	 */
	public String getSalesRepPhone() {
		return salesRepPhone;
	}

	/**
	 * @param salesRepPhone the salesRepPhone to set
	 */
	public void setSalesRepPhone(String salesRepPhone) {
		this.salesRepPhone = salesRepPhone;
	}

	/**
	 * @return the salesRepFax
	 */
	public String getSalesRepFax() {
		return salesRepFax;
	}

	/**
	 * @param salesRepFax the salesRepFax to set
	 */
	public void setSalesRepFax(String salesRepFax) {
		this.salesRepFax = salesRepFax;
	}

	/**
	 * @return the salesRepType
	 */
	public String getSalesRepType() {
		return salesRepType;
	}

	/**
	 * @param salesRepType the salesRepType to set
	 */
	public void setSalesRepType(String salesRepType) {
		this.salesRepType = salesRepType;
	}
}
