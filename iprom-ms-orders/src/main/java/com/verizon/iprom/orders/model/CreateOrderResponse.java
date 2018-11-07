/**
 * 
 */
package com.verizon.iprom.orders.model;

import java.math.BigInteger;
import java.util.List;

/**
 * @author ManjunathShivashimpi
 *
 */
public class CreateOrderResponse {
	
	private String responseCode;
	private String status;
	private String errorMessage;
	
	private BigInteger orderId;
	
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
	private List<GenericCode> serviceTypes;
	
	private List<GenericCode> billingSystems;
	
	private List<GenericCode> orderTypes;
	
	private List<GenericCode> centers;
	
	private List<SalesRepDetails> salesRepDetails;
	/**
	 * @return the responseCode
	 */
	public String getResponseCode() {
		return responseCode;
	}
	/**
	 * @param responseCode the responseCode to set
	 */
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the serviceTypes
	 */
	public List<GenericCode> getServiceTypes() {
		return serviceTypes;
	}
	/**
	 * @param serviceTypes the serviceTypes to set
	 */
	public void setServiceTypes(List<GenericCode> serviceTypes) {
		this.serviceTypes = serviceTypes;
	}
	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	/**
	 * @return the billingSystems
	 */
	public List<GenericCode> getBillingSystems() {
		return billingSystems;
	}
	/**
	 * @param billingSystems the billingSystems to set
	 */
	public void setBillingSystems(List<GenericCode> billingSystems) {
		this.billingSystems = billingSystems;
	}
	/**
	 * @return the orderTypes
	 */
	public List<GenericCode> getOrderTypes() {
		return orderTypes;
	}
	/**
	 * @param orderTypes the orderTypes to set
	 */
	public void setOrderTypes(List<GenericCode> orderTypes) {
		this.orderTypes = orderTypes;
	}
	/**
	 * @return the centers
	 */
	public List<GenericCode> getCenters() {
		return centers;
	}
	/**
	 * @param centers the centers to set
	 */
	public void setCenters(List<GenericCode> centers) {
		this.centers = centers;
	}
	/**
	 * @return the salesRepDetails
	 */
	public List<SalesRepDetails> getSalesRepDetails() {
		return salesRepDetails;
	}
	/**
	 * @param salesRepDetails the salesRepDetails to set
	 */
	public void setSalesRepDetails(List<SalesRepDetails> salesRepDetails) {
		this.salesRepDetails = salesRepDetails;
	}
	
}
