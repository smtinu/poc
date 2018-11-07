/**
 * @copyright 2018 Verizon
 * @author muneeb.ahmad@ibm.com
 * @since Oct 16, 2018
 */
package com.verizon.iprom.orders.model;

import java.math.BigInteger;

/**
 * TODO Describe the purpose of this class.
 *
 */
public class IntradaOrderDetails
{
    private String orderName;
    private String orderType;
    private String orderTypeCode;
    private String center;
    private BigInteger orderId;
    private BigInteger accountName;
    private String billingSys;
    private String referredTo;
    private Integer centerId;
    private String serviceTypeId;
    private String serviceType;
    private BigInteger relatedOrderId;
    private String tin;
    private Integer version;
    private String projectNumber;
    private String salesRepId;
    private String canceled;
    
    
    /**
	 * @return the orderTypeCode
	 */
	public String getOrderTypeCode() {
		return orderTypeCode;
	}
	/**
	 * @param orderTypeCode the orderTypeCode to set
	 */
	public void setOrderTypeCode(String orderTypeCode) {
		this.orderTypeCode = orderTypeCode;
	}
	/**
	 * @return the canceled
	 */
	public String getCanceled() {
		return canceled;
	}
	/**
	 * @param canceled the canceled to set
	 */
	public void setCanceled(String canceled) {
		this.canceled = canceled;
	}
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
     * 
     */
    public IntradaOrderDetails()
    {

    }
    /**
     * @return the orderName
     */
    public String getOrderName()
    {
        return orderName;
    }
    /**
     * @param orderNameParm the orderName to set
     */
    public void setOrderName(String orderNameParm)
    {
        orderName = orderNameParm;
    }
    /**
     * @return the orderType
     */
    public String getOrderType()
    {
        return orderType;
    }
    /**
     * @param orderTypeParm the orderType to set
     */
    public void setOrderType(String orderTypeParm)
    {
        orderType = orderTypeParm;
    }
    /**
     * @return the center
     */
    public String getCenter()
    {
        return center;
    }
    /**
     * @param centerParm the center to set
     */
    public void setCenter(String centerParm)
    {
        center = centerParm;
    }
	/**
	 * @return the orderId
	 */
	public BigInteger getOrderId() {
		return orderId;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(BigInteger orderId) {
		this.orderId = orderId;
	}
	/**
	 * @return the accountName
	 */
	public BigInteger getAccountName() {
		return accountName;
	}
	/**
	 * @param accountName the accountName to set
	 */
	public void setAccountName(BigInteger accountName) {
		this.accountName = accountName;
	}
	/**
	 * @return the billingSys
	 */
	public String getBillingSys() {
		return billingSys;
	}
	/**
	 * @param billingSys the billingSys to set
	 */
	public void setBillingSys(String billingSys) {
		this.billingSys = billingSys;
	}
	/**
	 * @return the refferedTo
	 */
	public String getReferredTo() {
		return referredTo;
	}
	/**
	 * @param refferedTo the refferedTo to set
	 */
	public void setReferredTo(String referredTo) {
		this.referredTo = referredTo;
	}
	/**
	 * @return the centerId
	 */
	public Integer getCenterId() {
		return centerId;
	}
	/**
	 * @param centerId the centerId to set
	 */
	public void setCenterId(Integer centerId) {
		this.centerId = centerId;
	}
	/**
	 * @return the serviceTypeId
	 */
	public String getServiceTypeId() {
		return serviceTypeId;
	}
	/**
	 * @param serviceTypeId the serviceTypeId to set
	 */
	public void setServiceTypeId(String serviceTypeId) {
		this.serviceTypeId = serviceTypeId;
	}
	/**
	 * @return the serviceType
	 */
	public String getServiceType() {
		return serviceType;
	}
	/**
	 * @param serviceType the serviceType to set
	 */
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	/**
	 * @return the relatedOrderId
	 */
	public BigInteger getRelatedOrderId() {
		return relatedOrderId;
	}
	/**
	 * @param relatedOrderId the relatedOrderId to set
	 */
	public void setRelatedOrderId(BigInteger relatedOrderId) {
		this.relatedOrderId = relatedOrderId;
	}
	/**
	 * @return the tin
	 */
	public String getTin() {
		return tin;
	}
	/**
	 * @param tin the tin to set
	 */
	public void setTin(String tin) {
		this.tin = tin;
	}
	/**
	 * @return the version
	 */
	public Integer getVersion() {
		return version;
	}
	/**
	 * @param version the version to set
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}
	/**
	 * @return the projectNumber
	 */
	public String getProjectNumber() {
		return projectNumber;
	}
	/**
	 * @param projectNumber the projectNumber to set
	 */
	public void setProjectNumber(String projectNumber) {
		this.projectNumber = projectNumber;
	}
}

