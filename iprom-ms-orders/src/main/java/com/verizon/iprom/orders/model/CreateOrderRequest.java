/**
 * 
 */
package com.verizon.iprom.orders.model;


/**
 * @author ManjunathShivashimpi
 *
 */
public class CreateOrderRequest {
	
	private IntradaOrderDetails intradaOrder;

	/**
	 * @return the intradaOrderDetails
	 */
	public IntradaOrderDetails getIntradaOrder() {
		return intradaOrder;
	}

	/**
	 * @param intradaOrderDetails the intradaOrderDetails to set
	 */
	public void setIntradaOrder(IntradaOrderDetails intradaOrder) {
		this.intradaOrder = intradaOrder;
	}
	

}
