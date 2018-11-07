/**
 * @copyright 2018 Verizon
 * @author muneeb.ahmad@ibm.com
 * @since Oct 13, 2018
 */
package com.verizon.iprom.orders.service;

import java.math.BigInteger;
import java.util.List;

import com.eds.intrada.IntradaServer.BusinessObject.Common.FilterView;
import com.eds.intrada.IntradaServer.BusinessObject.Common.IntradaOrderSearchResponseRBO;
import com.verizon.iprom.orders.model.CancelOrderRequest;
import com.verizon.iprom.orders.model.CancelOrderResponse;
import com.verizon.iprom.orders.model.GenericCode;
import com.verizon.iprom.orders.model.IntradaOrderDetails;
import com.verizon.iprom.orders.model.SalesRepDetails;
import com.verizon.iprom.orders.model.ViewOrderReponse;

/**
 * Service Interface
 *
 */
public interface OrderService {
	
 //   public ViewOrderReponse getIntradaOrder(int orderIdParm);
    
//    public List<GenericCode> getGenericCodes(String codeType) throws Exception;
    
//    public List<GenericCode> getCenters() throws Exception;
//    
//    public List<SalesRepDetails> getSalesRepDetails() throws Exception;
//    
//    public BigInteger createOrder(IntradaOrderDetails intradaOrderDetails) throws Exception;
//	
//    public List<GenericCode> getCanceledReasons() throws Exception;
//    
//    public CancelOrderResponse cancelOrder(CancelOrderRequest cancelOrderRequest) throws Exception;
//    
//    public void modifyOrder(IntradaOrderDetails intradaOrderDetails) throws Exception;
	
	
	 public FilterView<IntradaOrderSearchResponseRBO> findIntradaOrderByIntradaOrderId( Long aIntradaOrderId, String userId);
}
