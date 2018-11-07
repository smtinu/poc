/**
 * 
 */
package com.verizon.iprom.orders.model;

import java.math.BigInteger;

/**
 * @author ManjunathShivashimpi
 *
 */
public class CancelOrderRequest {

	private BigInteger orderId;
	private Integer canceledReasonCode;
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
	 * @return the canceledReasonCode
	 */
	public Integer getCanceledReasonCode() {
		return canceledReasonCode;
	}
	/**
	 * @param canceledReasonCode the canceledReasonCode to set
	 */
	public void setCanceledReasonCode(Integer canceledReasonCode) {
		this.canceledReasonCode = canceledReasonCode;
	}
}
