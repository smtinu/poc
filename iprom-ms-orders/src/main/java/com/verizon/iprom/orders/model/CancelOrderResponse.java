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
public class CancelOrderResponse {
	private String status;
	private String responseCode;
	private String errorMessage;
	private List<GenericCode> canceledReasons;
	private BigInteger orderId;
	private String cancelReason;
	
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
	 * @return the canceledReasons
	 */
	public List<GenericCode> getCanceledReasons() {
		return canceledReasons;
	}
	/**
	 * @param canceledReasons the canceledReasons to set
	 */
	public void setCanceledReasons(List<GenericCode> canceledReasons) {
		this.canceledReasons = canceledReasons;
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
	 * @return the cancelReason
	 */
	public String getCancelReason() {
		return cancelReason;
	}
	/**
	 * @param cancelReason the cancelReason to set
	 */
	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}
	
}
